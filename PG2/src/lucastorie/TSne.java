package lucastorie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

import com.jujutsu.tsne.TSneConfiguration;
import com.jujutsu.tsne.barneshut.BHTSne;
import com.jujutsu.tsne.barneshut.BarnesHutTSne;
import com.jujutsu.tsne.barneshut.ParallelBHTsne;
import com.jujutsu.utils.MatrixOps;
import com.jujutsu.utils.MatrixUtils;
import com.jujutsu.utils.TSneUtils;

import glove.objects.Vocabulary;

public class TSne{
	
@SuppressWarnings("deprecation")

public static void Lets(double [][] M,Vocabulary vocab, ArrayList<String> termoQueroinput){
	
	int initial_dims = 55;
    double perplexity = 6.0;
  //  double [][] X = MatrixUtils.simpleRead2DMatrix(new File("src/main/resources/datasets/mnist2500_X.txt"), "   ");
   // System.out.println(MatrixOps.doubleArrayToPrintString(M, 2,3, 50));
    BarnesHutTSne tsne;
    boolean parallel = false;
	if(parallel) {			
		tsne = new ParallelBHTsne();
	} else {
		tsne = new BHTSne();
	}
        TSneConfiguration config = TSneUtils.buildConfig(M, 2, initial_dims, perplexity, 1000);
	double[][] Y = tsne.tsne(config);
	
	/*for(int i =0; i< Y.length; i++) {
		
		for( int j=0; j<Y[0].length;j++) {
	
			System.out.println("coordenada = (" + i + ","+ j + ")=" + Y[i][j]);}
		
	}*/
	
	
	ArrayList<String> TQ = new ArrayList<String>();

	ArrayList<Integer> id = new ArrayList<Integer>();
	
	 //Filtro as palavras que quero!!!!
    for(int i=0;i<vocab.getSize();i++) {
    	
    	for(int j=0;j<termoQueroinput.size();j++) {
    		
    		int word_id = vocab.getWordId(vocab.getWord(i));
    		
    		if(vocab.getWord(i).toLowerCase().equals(termoQueroinput.get(j).toLowerCase())) {
    			id.add(word_id);
    			TQ.add(vocab.getWord(i));
    			System.out.println(word_id + ":" + vocab.getWord(i));
    			
    		}else {
    			
    		}
    		
    }}
    
	// Plot Y or save Y to file and plot with some other tool such as for instance R
  
	
	XYSeriesCollection dataset = new XYSeriesCollection();
	
	for (int i = 0; i < TQ.size() ; i++) {
		XYSeries series = new XYSeries(TQ.get(i));
	  	 series.add(Y[id.get(i)][0],Y[id.get(i)][1]);   
		 dataset.addSeries(series);
	}
	
	 @SuppressWarnings("unused")
	 JFreeChart chart = ChartFactory.createScatterPlot(
		        "", 
		        " ", 
		        " ", 
		        dataset);
	 
	 chart.removeLegend();
	 XYPlot plot = (XYPlot) chart.getPlot();
	 XYItemRenderer renderer = plot.getRenderer();

	 XYItemLabelGenerator generator = new StandardXYItemLabelGenerator(
	 "{0}", new DecimalFormat("0.00"), new DecimalFormat("0.00")
	 );
	 renderer.setItemLabelGenerator(generator);
	 renderer.setItemLabelFont(new Font("Arial", Font.PLAIN, 22));
	 renderer.setItemLabelsVisible(true);

	 
	 for (int i = 0; i < Y.length ; i++) {
	  renderer.setSeriesPaint(i, Color.RED);
	  renderer.setSeriesShape(i, new Ellipse2D.Double(0, 0, 3, 3));
	  
	 }
	 
	 plot.setBackgroundPaint(Color.white);
	 
	 ChartFrame frame = new ChartFrame("Glove", chart);
	 frame.pack();
	 frame.setVisible(true);
	 
	 

}
}