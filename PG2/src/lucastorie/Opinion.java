package lucastorie;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

public class Opinion {

	public static String[] cat = {"Contra","A Favor","Imparcial / Notícia","Não classificado"};
	
	public static ArrayList<String> ReadWordsPro(){
		
		String finalFileWords1 = DataEntry.wordsPro;
		
		// ARQUIVO TXT COM AS KEYWORDS
		File kw1 = new File("C:\\Java IO\\" + finalFileWords1 );
		ArrayList<String> keyWords1 = DataEntry.read_file(kw1);
		return keyWords1;
		
		}
	
	public static ArrayList<String> ReadWordsAgainst(){
		
		String finalFileWords2 = DataEntry.wordsAgainst;
		
		// ARQUIVO TXT COM AS KEYWORDS
		File kw2 = new File("C:\\Java IO\\" + finalFileWords2 );
		ArrayList<String> keyWords2 = DataEntry.read_file(kw2);
		return keyWords2;
		
		}
	
	public static ArrayList<String> ReadWordsImparcial(){
		
		String finalFileWords3 = DataEntry.wordsImparcial;
		
		// ARQUIVO TXT COM AS KEYWORDS
		File kw3 = new File("C:\\Java IO\\" + finalFileWords3 );
		ArrayList<String> keyWords3 = DataEntry.read_file(kw3);
		return keyWords3;
		
		}
	
	public static int[] calculateOpintion(ArrayList<String> tw) {
		
		ArrayList<String> pkw = ReadWordsPro();
		ArrayList<String> ckw = ReadWordsAgainst();
		ArrayList<String> imp = ReadWordsImparcial();
		
		
		int[] Count = new int[4];
		
		
		// 0 -> contra ; 1-> a favor ; 2->imparcial
			
		//CONTAGEM DO CONTRA
		for(int j=0; j< ckw.size() ; j++) {
			
			for(int i=0; i< ckw.size() ; i++) {
			
				if(tw.get(i).contains(ckw.get(j))) {
				Count[0]++;
				//System.out.print("Posicao:" + i);
				//System.out.println("CKW:" + ckw.get(j));
				}
				
			}
			
		}

		//CONTAGEM A FAVOR 
		for(int j=0; j< pkw.size() ; j++) {
			
			for(int i=0; i< tw.size() ; i++) {
			
				if(tw.get(i).contains(pkw.get(j))) {
				Count[1]++;
				
		//		System.out.println("PKW:" + pkw.get(j));
				}
				
			}
			
		}

		//CONTAGEM IMPARCIAL
		for(int j=0; j< imp.size() ; j++) {
			
			for(int i=0; i< tw.size() ; i++) {
				
				if(tw.get(i).contains(imp.get(j))) {
					Count[2]++;
			//		System.out.print("Posicao:" + i);
			//		System.out.println("PKW:" + pkw.get(j));
					}
					
			}
				
		}

			Count[3]= tw.size() - Count[0] - Count[1] - Count[2]; //CONTAGEM DOS NAO CLASSIFICADOS
			
//		
//			System.out.println(Count[3]);
//			System.out.println(Count[2]);
//			System.out.println(Count[1]);
//			System.out.println(Count[0]);
//			
			return Count;
		
	}
	

	public static void createPieOpinion(ArrayList<String> tw, String title) {

	
	int Count[] = calculateOpintion(tw);
		
	 DefaultPieDataset data = new DefaultPieDataset();
	 
	 for (int i = 0; i < 4; i++) {
	 	  data.setValue(cat[i],Count[i]);   
	    }
	
	 JFreeChart chart = ChartFactory.createPieChart(
	 title, //title
	 data,
	 true, // legend?
	 true, // tooltips?
	 false // URLs?
	 );

	 PiePlot plot = (PiePlot) chart.getPlot();
	 PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator("{0} = {2}",new DecimalFormat("0"), new DecimalFormat("0.00%"));
	 plot.setLabelGenerator(generator);
	// PiePlot plot = (PiePlot) chart.getPlot();  //Mudando de cor
	// plot.setSectionPaint("Category 1", new Color(200, 66, 255)); //.setSectionPaint(Comparable,Paint)
	// plot.setSectionOutlinesVisible(true); //Contorno entre as fatias do gr�fico
	// plot.setBaseSectionOutlinePaint(new Color(203, 66, 255)); //muda cor do contorno
	
	 ChartFrame frame = new ChartFrame("Gráfico de Pizza - Opiniões", chart);
	 frame.pack();
	 frame.setVisible(true);
}

	
public static void createBarOpinion(ArrayList<String> tw, String title, String y, String x) throws IOException{
		

	
		int Count[] = calculateOpintion(tw);
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		

		 for (int i = 0; i < 4; i++) {
		  	  dataset.addValue(Count[i],x,cat[i]);   
		    }
		
		
		 @SuppressWarnings("unused")
			JFreeChart chart = ChartFactory.createBarChart(
			title, // chart title
			y, // domain axis label
			"Nº de vezes", // range axis label
			dataset, // data
			PlotOrientation.HORIZONTAL, // orientation
			true, // include legend
			false, // tooltips?
			false // URLs?
			);
			
			ChartFrame demo = new ChartFrame("Grágico de Barras - Opiniões", chart);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
		 
		
	}
	
	

}
