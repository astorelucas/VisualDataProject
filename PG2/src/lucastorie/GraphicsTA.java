package lucastorie;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class GraphicsTA {
	
	
public static void createBarNgram(ArrayList<String> in) throws IOException{
		
	ArrayList<Integer> frequenciaTermos = new ArrayList<Integer> ();
	ArrayList<String> termos = new ArrayList<String> ();
	
	for(int i=1; i< in.size() ; i++) {
		if(in.get(i).indexOf("|")>-1) {
			int pos = in.get(i).indexOf("|"); //pega a posição que aparece "|"
			int f = Integer.parseInt(in.get(i).substring(pos+1));
			frequenciaTermos.add(f);
			termos.add(in.get(i).substring(0,pos));
			//System.out.println(f);
			//System.out.println(termos.get(i));
			}
		}
		

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();


		 for (int i = 0; i < frequenciaTermos.size(); i++) {
		  	  dataset.addValue(frequenciaTermos.get(i),"Frequência",termos.get(i));   
		    }
		
		
		 @SuppressWarnings("unused")
			JFreeChart chart = ChartFactory.createBarChart(
			"", // chart title
			"", // domain axis label
			"", // range axis label
			dataset, // data
			PlotOrientation.HORIZONTAL, // orientation
			true, // include legend
			false, // tooltips?
			false // URLs?
			);
			
			ChartFrame demo = new ChartFrame("N-gram", chart);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
			
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			
			BarRenderer renderer = (BarRenderer) plot.getRenderer();
			
			renderer.setBarPainter(new StandardBarPainter());
			
			renderer.setSeriesPaint(0, Color.orange);

		
	}


public static void createBarRegras(ArrayList<String> in) throws IOException{
	
	ArrayList<Integer> contagem = new ArrayList<Integer> ();
	ArrayList<String> classesTweets = new ArrayList<String> ();
	ArrayList<String> uniqueClasses = new ArrayList<String> ();
	
	for(int i=1; i< in.size() ; i++) {
		if(in.get(i).indexOf("|")>-1) {
			int pos = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
			classesTweets.add(in.get(i).substring(pos+1));
			//System.out.println(f);
			//System.out.println(classesTweets.get(i-1));

			
			}
		}
	
	uniqueClasses.add(classesTweets.get(0));
	contagem.add(0);
	
	for(String c0: classesTweets){ 
	            boolean found = false;
	            
	            for(String c: uniqueClasses){
	               
	            	if(c0.equals(c)) { 
	                    found = true;
	                	}
	            }
                if(found==false) {
                	uniqueClasses.add(c0);
                	contagem.add(0);
                }
	          }
	
	
	
	for(int i =0; i<uniqueClasses.size(); i++) {
		
		 for(String c: classesTweets){
			
			 if(uniqueClasses.get(i).equals(c)) {
				 int count = contagem.get(i) +1;
				 contagem.set(i,count);
			 }
		}
	}
	//System.out.println(contagem);
	//System.out.println(uniqueClasses);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();


		 for (int i = 0; i < uniqueClasses.size(); i++) {
		  	  dataset.addValue(contagem.get(i),"Frequência",uniqueClasses.get(i));   
		    }
		
		
		 @SuppressWarnings("unused")
			JFreeChart chart = ChartFactory.createBarChart(
			"", // chart title
			"", // domain axis label
			"", // range axis label
			dataset, // data
			PlotOrientation.HORIZONTAL, // orientation
			true, // include legend
			false, // tooltips?
			false // URLs?
			);
			
			ChartFrame demo = new ChartFrame("Regras", chart);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
			
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			
			BarRenderer renderer = (BarRenderer) plot.getRenderer();
			
			renderer.setBarPainter(new StandardBarPainter());
			
			renderer.setSeriesPaint(0, Color.cyan);

		
	}



public static void createBarCA(ArrayList<String> in, int setcoint, int setabint) {
	
//	float pco;
//	pco = (float)setcoint/100;
//	
//	float pab;
//	pab= (float)setabint/100;
//	
	ArrayList<Integer> contagem = new ArrayList<Integer> ();
	ArrayList<String> classesTweets = new ArrayList<String> ();
	ArrayList<String> regras = new ArrayList<String> ();
	ArrayList<String> uniqueClasses = new ArrayList<String> ();
	
	ArrayList<Float> co = new ArrayList<Float> ();
	ArrayList<Float> a = new ArrayList<Float> ();
	
	for(int i=1; i< in.size() ; i++) {
		if(in.get(i).indexOf("|")>-1) {
			int pos0 = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
			String ab = in.get(i).substring(pos0+1);
			a.add(Float.parseFloat(ab));
			
			int pos1 = in.get(i).indexOf("|"); //pega a posição que aparece "|"
			String conf = in.get(i).substring(pos1+1,pos0);
			co.add(Float.parseFloat(conf));
						
			regras.add(in.get(i).substring(0,pos1));
			
		//	System.out.println("conf " + co.get(i-1));
	    //	System.out.println("ab " + a.get(i-1));
		//	System.out.println("regra " + regras.get(i-1));
			
			}
		}
	
//	uniqueClasses.add(classesTweets.get(0));
//	contagem.add(0);

	
//	for(String c0: classesTweets){ 
//	            boolean found = false;
//	            
//	            for(String c: uniqueClasses){
//	               
//	            	if(c0.equals(c)) { 
//	                    found = true;
//	                	}
//	            }
//                if(found==false) {
//                	uniqueClasses.add(c0);
//                	contagem.add(0);
//                }
//	          }
//	
//	
//	
//	for(int i =0; i<uniqueClasses.size(); i++) {
//		
//		for(int j =1; j<classesTweets.size(); j++) {
//			
//			 if(uniqueClasses.get(i).equals(classesTweets.get(j)) && co.get(j)>=pco && a.get(j) >=pab ) {
//				 int count = contagem.get(i) +1;
//				 contagem.set(i,count);
//			 }
//		}
//	}
//	//System.out.println(contagem);
//	//System.out.println(uniqueClasses);
//
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		

		 for (int i = 0; i < regras.size(); i++) {
			 if(a.get(i)>setabint && co.get(i)>setcoint) {
		  	  dataset.addValue(a.get(i),"Abrangência",regras.get(i)); 
		  	  dataset.addValue(co.get(i),"Confiança",regras.get(i)); 
			 }
		 }
		
		
		 @SuppressWarnings("unused")
			JFreeChart chart = ChartFactory.createBarChart(
			"", // chart title
			"", // domain axis label
			"", // range axis label
			dataset, // data
			PlotOrientation.HORIZONTAL, // orientation
			true, // include legend
			false, // tooltips?
			false // URLs?
			);
			
			ChartFrame demo = new ChartFrame("Confiança/Abrangência", chart);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
			
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			
			BarRenderer renderer = (BarRenderer) plot.getRenderer();
			
			renderer.setBarPainter(new StandardBarPainter());
			
			renderer.setSeriesPaint(0, Color.cyan);
	
	
	
}

}
