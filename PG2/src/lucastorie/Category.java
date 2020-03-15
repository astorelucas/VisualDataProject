package lucastorie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

public class Category {
	
	static ArrayList<String> Categorias = new ArrayList<String>(); // Vetor das categorias
	static ArrayList<String> KeyWords = new ArrayList<String>(); // Vetor das categorias
	static ArrayList<Integer> nVezesCat = new ArrayList<Integer>();
	static ArrayList<String> ResultadoCategorias = new ArrayList<String>(); 
	
	//static int[] nVezesCat = new int[qddCat]; // Vetor onde tem a quantidade que a categoria aparece
	
	public static void createData(ArrayList<String> in,ArrayList<String> CategoriasKeyWords) throws IOException {
		
	//	Random gerador = new Random();
	//	String numero = String.valueOf(gerador.nextInt(100));
		
		for(int j=0; j< in.size(); j++) {
			ResultadoCategorias.add("tweet"+(j+1)+"|");
		}
		
		String out0 = FileOpener.fileName;
		
		int posfile = out0.lastIndexOf("\\");
		
		String out1 = out0.substring(0,posfile+1);
		
		out1 = out1.concat("SaidaCategorizado.txt");
		
				
		
		// CRIAÇÃO DE UM ARQUIVO SAÍDA CATEGORIZADO
		File arquivocopy = new File( out1 );
	
		if(arquivocopy.exists()) {
			
			arquivocopy.delete();
			//System.out.println("excluiu?");
		}
		
		arquivocopy.createNewFile();
		
		FileWriter fw = new FileWriter( arquivocopy, true );
		BufferedWriter bw = new BufferedWriter( fw );
		
		fw.flush();
		bw.flush();
		
		//int qddTweets = in.size();

		//Construção da Array de Categorias
		for(int i=0; i< CategoriasKeyWords.size() ; i++) {
			
			if(CategoriasKeyWords.get(i).indexOf("|")>-1) {
				
				int pos = CategoriasKeyWords.get(i).indexOf("|"); //Pega a posição que aparece "|"
				Categorias.add(CategoriasKeyWords.get(i).substring(0, pos)); //adiciona em Categorias a categoria
				nVezesCat.add(i,0);
			

			}
		}
		
		//Construção da Array das Keywords
		for(int i=0; i< CategoriasKeyWords.size() ; i++) {
			
			if(CategoriasKeyWords.get(i).indexOf("|")>-1) {
				
				int pos = CategoriasKeyWords.get(i).indexOf("|"); //Pega a posição que aparece "|"
				KeyWords.add(CategoriasKeyWords.get(i).substring(pos+1)); //adiciona em Categorias a categoria
				
				
			}
		}

		
		ArrayList<String> theKey = new ArrayList<String>();
		
	
		for(int i=0; i< KeyWords.size(); i++) {
				int indexPos=0;
				int pos=0;
				int lastOcu = KeyWords.get(i).lastIndexOf(";");
							
				//While não chegar no fim das keywords, continua pegando-as
					while(indexPos!=(lastOcu+1)) {
					pos = KeyWords.get(i).indexOf(";",indexPos);
					theKey.add(KeyWords.get(i).substring(indexPos,pos));
					indexPos = pos+1;
													
				}

					for(int j=0; j< in.size(); j++) {

						for(int a=0; a< theKey.size(); a++) {
							
							String ver = in.get(j).toLowerCase();
							
							if(ver.contains(theKey.get(a).toLowerCase())) {
							
								String thenew = ResultadoCategorias.get(j).concat(Categorias.get(i) + ";");

								ResultadoCategorias.set(j, thenew);
								
								nVezesCat.set(i,nVezesCat.get(i) + 1);

								a=theKey.size(); //Se eu entrar nesse if, o tweet já foi categorizado, pode sair
							}else {
								
							}
							
						}
		
				}

				theKey.clear();
				
			}
		
		
		nVezesCat.add(0);
		
		int last = nVezesCat.size() - 1;
		
		for(int j=0; j< in.size(); j++) {
						
			if(ResultadoCategorias.get(j).contains(";")==false) {
				nVezesCat.set(last,nVezesCat.get(last) + 1);
				String thenew = ResultadoCategorias.get(j).concat("Não Classificado");
				ResultadoCategorias.set(j, thenew);
			}
			System.out.println(ResultadoCategorias.get(j));
			bw.write(ResultadoCategorias.get(j));
			bw.newLine();
		}
		bw.close();
		fw.close();
	}
	
	public static void createBarCat(ArrayList<String> in,ArrayList<String> key) throws IOException {
		
		createData(in,key);
		
		Categorias.add("Não Classificado");

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
	    for (int i = 0; i < Categorias.size(); i++) {
	  	  dataset.addValue(nVezesCat.get(i),"Categorias",Categorias.get(i));   
	    }

		@SuppressWarnings("unused")
		JFreeChart chart = ChartFactory.createBarChart(
		"", // chart title
		"", // domain axis label
		"Nº de vezes", // range axis label
		dataset, // data
		PlotOrientation.HORIZONTAL, // orientation
		true, // include legend
		false, // tooltips?
		false // URLs?
		);
		
		ChartFrame demo = new ChartFrame("Gráfico de Barras - Categorias", chart);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		
		renderer.setBarPainter(new StandardBarPainter());

		 clearAllVariables();
	}
	
	public static void createPizzaCat(ArrayList<String> in,ArrayList<String> key) throws IOException {
		
		createData(in,key);
		
		Categorias.add("Não Classificado");
		
		DefaultPieDataset data = new DefaultPieDataset();
	 
	 for (int i = 0; i < Categorias.size(); i++) {
	 	  data.setValue(Categorias.get(i),nVezesCat.get(i));  
	 	  System.out.println(nVezesCat.get(i) + " " + Categorias.get(i));
	    }

	 JFreeChart chart = ChartFactory.createPieChart(
	 "", //title
	 data,
	 true, // legend?
	 true, // tooltips?
	 false // URLs?
	 );
	 chart.removeLegend();
	 PiePlot plot = (PiePlot) chart.getPlot();
	 PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator("{0} = {2}",new DecimalFormat("0"), new DecimalFormat("0.00%"));
	 plot.setLabelGenerator(generator);
	// PiePlot plot = (PiePlot) chart.getPlot();  //Mudando de cor
	// plot.setSectionPaint("Category 1", new Color(200, 66, 255)); //.setSectionPaint(Comparable,Paint)
	// plot.setSectionOutlinesVisible(true); //Contorno entre as fatias do gr�fico
	// plot.setBaseSectionOutlinePaint(new Color(203, 66, 255)); //muda cor do contorno

	 ChartFrame frame = new ChartFrame("Gráfico de Pizza - Categorias", chart);
	 frame.pack();
	 frame.setVisible(true);
	 
	 clearAllVariables();
	}
	
	public static void clearAllVariables() {
		
		Categorias.clear();
		KeyWords.clear();
		nVezesCat.clear();
		ResultadoCategorias.clear();
		
	}



}
