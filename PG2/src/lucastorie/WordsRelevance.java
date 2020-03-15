package lucastorie;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

public class WordsRelevance {
	
	static ArrayList<Integer> nVezesW = new ArrayList<Integer>(); //vetor que contém a quantidade que as # aparece
	
public static void createData(ArrayList<String> in, ArrayList<String> KW) {
	
	for(int i=0; i< KW.size() ; i++) {
		nVezesW.add(i,0);
	}
	

	//CONTAGEM DE TERMOS
	
	for(int j=0 ; j< KW.size(); j++) {
		for(int i=0; i< in.size() ; i++) {
			
				if(in.get(i).toLowerCase().contains(KW.get(j).toLowerCase())){
					
					nVezesW.set(j,nVezesW.get(j) + 1);
													}
				
											}	
										}

}
	
	
	public static void createBarWR(ArrayList<String> in, ArrayList<String> KW) throws IOException{
		
		createData(in, KW);
		
		if (nVezesW.isEmpty()) {
			
			System.out.println("Não tem nenhuma palavra");
			
		}
			
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//String retweets = "#HashTags"; 

		 for (int i = 1; i < KW.size(); i++) {
		  	  dataset.addValue(nVezesW.get(i),"Frequência",KW.get(i)); 
		  	System.out.println(KW.get(i) + " = " + nVezesW.get(i));
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
			
			ChartFrame demo = new ChartFrame("Gráfico de Barras - Relevância de Palavras", chart);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);

			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			
			BarRenderer renderer = (BarRenderer) plot.getRenderer();
			
			renderer.setBarPainter(new StandardBarPainter());
			
			renderer.setSeriesPaint(0, Color.blue);

			clearAllVariables();
		 
		
	}
	
	public static void createPieWR(ArrayList<String> in, ArrayList<String> KW){
		
		createData(in, KW);
		
		DefaultPieDataset data = new DefaultPieDataset();
		 
		 for (int i = 1; i < KW.size(); i++) {
		 	  data.setValue(KW.get(i),nVezesW.get(i));   
		    }
		
		 JFreeChart chart = ChartFactory.createPieChart(
		 "", //title
		 data,
		 true, // legend?
		 true, // tooltips?
		 false // URLs?
		 );

		 PiePlot plot = (PiePlot) chart.getPlot();
		 PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator("{0} = {2}",new DecimalFormat("0"), new DecimalFormat("0.00%"));
		 plot.setLabelGenerator(generator);
			
		 ChartFrame frame = new ChartFrame("Grafico de Pizza - Relevância de Palavras", chart);
		 frame.pack();
		 frame.setVisible(true);
		 chart.removeLegend();
		 
		 
		
	}

	public static void createLineWR(ArrayList<String> in, ArrayList<String> KW){
		
		
		double tempo;
		
		for(int i=0; i< in.size() ; i++) {
			if(in.get(i).indexOf("|")>-1) {
				int pos = in.get(i).indexOf("|"); //pega a posição que aparece "|"
				tempo = Double.parseDouble(in.get(i).substring(pos+1));
				System.out.println(tempo);
				}
			}
			
		
		//Time.AdjustTime();
		
		
		//int[][] nVezes = new int[][KW.size()]; //vetor que contém a quantidade que as # aparece
		
//		
//		for (int i = 0; i < KW.size(); i++) {
//			
//		
//		}
//		
//			
//		XYSeries series1 = new XYSeries("Second");
//		series1.add(1.0, 5.0);
//		
//		
//		
//		XYSeriesCollection dataset = new XYSeriesCollection();
//		dataset.addSeries(series1);
//		
		
		
		
		
		
		
	}
	
	
	public static void clearAllVariables() {
		
		nVezesW.clear();
		
	}
	
}
