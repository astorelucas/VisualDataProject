package lucastorie;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class LineChart {
	
	public static String AdjustTime(long millis) {
		Date date = new Date(millis); 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-YYYY"); // the format of your date
		String formattedDate = sdf.format(date);
		return formattedDate;
		}
	
	public static boolean checkTweet(String in,String key) {
		
		if(in.toLowerCase().contains(key.toLowerCase())){
			//System.out.println("ACHOU EM  " + in + " A KEY >>> " + key );
			return true;
			}else {
			//System.out.println("NÃO ACHOU EM  " + in + " A KEY >>> " + key);
		return false; }
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<TimeSeries> countMinuteDB(ArrayList<String> in, ArrayList<String> key, long[] time, int setMinutes, int inicial,int[] days,int[] months) {

		ArrayList<TimeSeries> series = new ArrayList<TimeSeries>();
		
		int timeset = setMinutes*60000;
		
		int att = 1; //Referente às linhas da matriz nVezes = Grupos dos tempos
		
//		double inteira = -(time[0] - time[time.length-2]) / timeset; //Os tweets precisam estar em ordem CRESCENTE cronologicamente falando
//		
//		int value = (int)inteira;
//
//		int linhas = value + 1;
		
		ArrayList<ArrayList<Integer>> dados = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> grupos = new ArrayList<Integer>();
		
		grupos.add(0);
		dados.add(grupos);

		
		for(int j=1; j<key.size() ; j++) {
			dados.add(j-1,(ArrayList<Integer>) grupos.clone());
			dados.get(j-1).add(0);
		}
		
	//	int[][] nVezes = new int[linhas][key.size()]; //vetor que contém a quantidade que as # aparece

		for(int i=1; i<in.size() ; i++) {
			
			if(time[i-1]<=(time[0]+(att*timeset))) {
				//System.out.println(time[i] + " é menor que? " + (time[1]+(value2*timeset)));
				for(int j=1; j<key.size() ; j++) {
					
					if(checkTweet(in.get(i),key.get(j))) {
						//nVezes[att-1][j-1]++;
						int old = dados.get(j-1).get(att-1);
						dados.get(j-1).set(att-1,old+1);
					}
				}
				
			}else {
				att++;
				System.out.println(att);
				for(int j=1; j<key.size() ; j++) {
					dados.get(j-1).add(0);}
				
				i--; //para voltar no tweet da vez (i) e contar de novo com o value2 novo
			}
			
		}
		
	//	int day_1 = theDays[1];
		
	//	int month_1 = theMonth[1];
		
		//System.out.println(theDay[1]);

		int ini1 = inicial;
		System.out.println(ini1);
		int day = 1;
		//Método para formar as séries:
		for(int j = 0; j < key.size()-1; j++) {
			
			TimeSeries serieN = new TimeSeries(key.get(j+1));
			
				for (int i = 1; i < att; i++) {

					serieN.add(new Minute(ini1,day,days[0],months[0],2017), dados.get(j).get(i)); 
					if(inicial+86400<ini1) {
						day++;
					}
					ini1 = ini1 + setMinutes;
					//System.out.println(nVezes[i][j]);
	         
					}
				
				series.add(serieN);
				ini1 = inicial; //Após terminar de montar uma série, volta para o minuto inicial
		}
		
		
		
		return series;
	}
	
	public static void createLineMinute(ArrayList<String> in,ArrayList<String> key, int minuteWindow) throws ParseException {

		int[][] nVezes; //Vetor que contém a quantidade que as # aparece
		
		long[] time = new long[in.size()]; 		   // Vetor com os milliseconds dos tweets
		String[] timead = new String[in.size()];   // Vetor com as datas no formato dd-mm-aaaa
		String[] theHour = new String[in.size()];  // Vetor com as Horas dos tweets
		int[] theDay = new int[in.size()];   // Vetor com o dia dos tweets
		String[] day = new String[in.size()];   // Vetor com o dia dos tweets
		int[] theMonth = new int[in.size()]; 
		
		for(int i=1; i< in.size() ; i++) {
			if(in.get(i).indexOf("|")>-1) {
				int pos = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
				time[i-1] = Long.parseLong(in.get(i).substring(pos+1));
				timead[i-1] = AdjustTime(time[i-1]);
				theHour[i-1] =  timead[i-1].substring(0,2);
				theDay[i-1] =  Integer.parseInt(timead[i-1].substring(9,11));
				day[i-1] = timead[i-1].substring(9,19);
				theMonth[i-1] = Integer.parseInt(timead[i-1].substring(12,14));

			//	System.out.println(timead[i]);
				//System.out.println(time[i-1]);
//				System.out.println(theDay[i]);

				}
			}
		
			
		int inicial = Integer.parseInt(timead[0].substring(3,5)); //Pega os minutos do primeiro tweet
		int setMinutos = minuteWindow;                                      // Janela de tempo a ser analisada
		System.out.println(inicial);
		ArrayList<TimeSeries> series = new ArrayList<TimeSeries>(); // Array que contém as séries dos termos
		
		series = countMinuteDB(in,key,time,setMinutos,inicial,theDay,theMonth); 	//Matriz com os dados: Linhas -> Janela de tempo | Colunas -> Termos buscados
		

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		for (int i = 0; i < series.size(); i++) {
		  dataset.addSeries(series.get(i));
			}
		
		dataset.setDomainIsPointsInTime(true);
		
		String title = day[0] + " até " + day[day.length-2];
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				title, // title
				"", // x-axis label
				"", // y-axis label
				dataset, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		chart.setBackgroundPaint(Color.white);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
		//plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("hh:mm:ss aaa"));
		renderer.setSeriesPaint(3, Color.MAGENTA);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);


				ChartFrame demo = new ChartFrame("Gráfico de Linhas - Relevância de termos", chart);
				demo.pack();
				RefineryUtilities.centerFrameOnScreen(demo);
				demo.setVisible(true);

	}

	public static void createLineMonth(ArrayList<String> in,ArrayList<String> key) {
		

		ArrayList<TimeSeries> allData = new  ArrayList<TimeSeries>(); 

		//System.out.println(in.size());
		//System.out.println(key.size());	

		long[] time = new long[in.size()]; // VETOR QUE RETIRA OS MILLIS TO TWEET
		String[] timead = new String[in.size()]; // VETOR COM DATAS AJUSTADAS
		
		for(int i=1; i< in.size() ; i++) {
			if(in.get(i).indexOf("|")>-1) {
				int pos = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
				time[i-1] = Long.parseLong(in.get(i).substring(pos+1));
				timead[i-1] = AdjustTime(time[i-1]*1000);
				//System.out.println(timead[i]); 

				}
			}
		
		
		allData = countMonthDB(in,timead,key);
		
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		for(int i=0; i< allData.size() ; i++) {
		dataset.addSeries(allData.get(i));
		}
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"", // title
				"", // x-axis label
				"", // y-axis label
				dataset, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		
		chart.setBackgroundPaint(Color.white);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
		//plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MM.yyyy"));
		renderer.setSeriesPaint(3, Color.MAGENTA);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);
		ChartFrame demo = new ChartFrame("Gráfico de Linhas - Frequência de termos ", chart);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

		
	}
	
	public static ArrayList<TimeSeries> countMonthDB(ArrayList<String> in,String[] timead,ArrayList<String> key) {
		
		int[][] nVezesHT = new int[13][key.size()]; //vetor que contém a quantidade que as # aparece
		
		ArrayList<TimeSeries> d = new  ArrayList<TimeSeries>();  //Array que contém os objetos de cada Termo que se quer observar
		
		String firstTime = timead[0];
		System.out.println(firstTime);
		int pos1 = firstTime.indexOf("-");
		int pos2 = firstTime.lastIndexOf("-");
		int firstMonth = Integer.parseInt(firstTime.substring(pos1+1,pos2));
		int firstYear = Integer.parseInt(firstTime.substring(pos2+1));
		//System.out.println(firstMonth + " " + firstYear);
		
		String lastTime = timead[timead.length-2];
		System.out.println(lastTime);
		int pos11 = lastTime.indexOf("-");
		int pos22 = lastTime.lastIndexOf("-");
		int lastMonth = Integer.parseInt(lastTime.substring(pos11+1,pos22));
		int lastYear = Integer.parseInt(lastTime.substring(pos22+1));
			
		//OPÇÃO ESCOLHIDA SER MESES:
		//CONTAGEM DOS DADOS 
		for(int i=1; i< in.size() ; i++) {
			
			if(timead[i-1].indexOf("-")>-1) {
				
				int pos = timead[i-1].indexOf("-");
		
				switch(timead[i-1].substring(pos+1, pos+3)) {
										
				case "01": //JANEIRO
					for(int j=1;j<key.size();j++) {
		
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[1][j]++;
									}
							
					}
				break;
				case "02":
					for(int j=1;j<key.size();j++) {
									
					
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[2][j]++;
									}
							
					}
				break;
				case "03":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[3][j]++;
									}
							
					}
				break; 
				case "04":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[4][j]++;
									}
							
					}
				break;
				case "05":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[5][j]++;
									}
							
					}
				break;
				case "06":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[6][j]++;
									}
							
					}
				break;
				case "07":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[7][j]++;
									}
							
					}
				break;
				case "08":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[8][j]++;
									}
							
					}
				break;
				case "09":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[9][j]++;
									}
							
					}
				break;
				case "10":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[10][j]++;
									}
							
					}
				break;
				case "11":
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[11][j]++;
									}
							
					}
				break;
				case "12":
					
					for(int j=1;j<key.size();j++) {
						
						if(in.get(i).toLowerCase().contains(key.get(j).toLowerCase())){
							
							nVezesHT[12][j]++;
									}
							
					}
				break;
				
				default:
					System.out.println("acabou");
		
				
				
				}		
				
			}	
			
		}
		
	

		
		for(int i=1; i< key.size() ; i++) {
			
			@SuppressWarnings("deprecation")
			TimeSeries series = new TimeSeries(key.get(i), Month.class); 
			d.add(series);
		}	
		
		for(int i=1; i< key.size() ; i++) {
			
			for(int j=1; j<= 12 ; j++) {
				
				d.get(i-1).add(new Month(firstMonth, firstYear), nVezesHT[firstMonth][i]);
				if(firstMonth==12) {
					firstYear++;
					firstMonth=1;
				}
				if(firstMonth==lastMonth){
					j=13;
				}
				firstMonth++;
			}
			
			firstMonth = Integer.parseInt(firstTime.substring(pos1+1,pos2));
			firstYear = Integer.parseInt(firstTime.substring(pos2+1));
		}
		
		
//		for(int i=0; i< Categorias.size() ; i++) {
//			
//			TimeSeries series = new TimeSeries(Categorias.get(i), Month.class); 
//			d.add(series);
//		}	
//		
//		for(int i=0; i< Categorias.size() ; i++) {
//			
//			for(int j=1; j<= 12 ; j++) {
//				
//				d.get(i).add(new Month(firstMonth, firstYear), nVezesHT[firstMonth][i]);
//				if(firstMonth==12) {
//					firstYear++;
//					firstMonth=1;
//				}
//				if(firstMonth==lastMonth){
//					j=13;
//				}
//				firstMonth++;
//			}
//			
//			firstMonth = Integer.parseInt(firstTime.substring(pos1+1,pos2));
//			firstYear = Integer.parseInt(firstTime.substring(pos2+1));
//		}
		
		return d;
	}
	
	public static void createLineCatMinute(ArrayList<String> in,ArrayList<String> key,int minuteWindow) throws IOException {

		int qddTweets = in.size();
		int qddCat = key.size();
		ArrayList<String> Categorias = new ArrayList<String>(); // Vetor das categorias
		ArrayList<String> KeyWords = new ArrayList<String>(); // Vetor das categorias
		int[][] nVezesCat = new int[12][qddCat]; // Vetor onde tem a quantidade que a categoria aparece
		

		long[] time = new long[in.size()]; // VETOR QUE RETIRA OS MILLIS TO TWEET
		String[] timead = new String[in.size()]; // VETOR COM DATAS AJUSTADAS
		String[] theHour = new String[in.size()];
		String[] theDay = new String[in.size()];
		String[] day = new String[in.size()];

		
		for(int i=0; i< in.size() ; i++) {
			if(in.get(i).indexOf("|")>-1) {
				int pos = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
				time[i] = Long.parseLong(in.get(i).substring(pos+1));
				timead[i] = AdjustTime(time[i]*1000);
				theHour[i] =  timead[i].substring(0,2);
				theDay[i] =  timead[i].substring(9,11);
				day[i] = timead[i].substring(9,19);
			//	System.out.println(timead[i]);
//				System.out.println(theHour[i]);
//				System.out.println(theDay[i]);

				}
			}
			
		//Construção da Array de Categorias
		for(int i=1; i< key.size() ; i++) {
			
			if(key.get(i).indexOf("|")>-1) {
				
				int pos = key.get(i).indexOf("|"); //Pega a posição que aparece "|"
				Categorias.add(key.get(i).substring(0, pos)); //adiciona em Categorias a categoria
				KeyWords.add(key.get(i).substring(pos+1));	//Construção da Array das Keywords
				//System.out.println(Categorias.get(i));
				//System.out.println(KeyWords.get(i));
			}
		}
		
		nVezesCat = countCatLine(in,KeyWords,time,Categorias,minuteWindow);

		int inicial = Integer.parseInt(timead[1].substring(3,5));
		int setMinutos = minuteWindow;
		
		final ArrayList<TimeSeries> series = new ArrayList<TimeSeries>(); 
		
		for(int j = 0; j < Categorias.size(); j++) {
			
			TimeSeries serieN = new TimeSeries(Categorias.get(j));
			
				for (int i = 0; i < nVezesCat.length; i++) {
			
					serieN.add(new Minute(inicial,14,24,03,2019), nVezesCat[i][j]);  
					inicial = inicial + setMinutos;
				//	System.out.println(nVezesCat[i][j]);
	         
					}
				
				series.add(serieN);
				inicial = Integer.parseInt(timead[1].substring(3,5));
		}
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		for (int i = 0; i < series.size(); i++) {
		  dataset.addSeries(series.get(i));
			}
		
		dataset.setDomainIsPointsInTime(true);
		
		String title = day[1] + " até " + day[day.length-1];
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				title, // title
				"", // x-axis label
				"", // y-axis label
				dataset, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		chart.setBackgroundPaint(Color.white);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
		//plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
		
		renderer.setSeriesPaint(3, Color.MAGENTA);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("hh:mm:ss aaa"));
		
		ChartFrame demo = new ChartFrame("Gráfico de Linhas - Categorias ", chart);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
				

		
	}

	public static int[][] countCatLine(ArrayList<String> in, ArrayList<String> KeyWords, long[] time,ArrayList<String> Categorias, int minuteWindow) throws IOException{
		

		// CRIAÇÃO DE UM ARQUIVO SAÍDA CATEGORIZADO
		File arquivocopy = new File( "C:\\JavaIO\\Categorias [Linha]\\SaidaCategorizado.txt" );
		arquivocopy.createNewFile();
			
		FileWriter fw = new FileWriter(arquivocopy, true );
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		int timeset = minuteWindow*60;
		int value2 = 1; //Referente às linhas da matriz nVezes = Grupos dos tempos
		double inteira = -(time[1] - time[time.length-1]) / timeset; //Os tweets precisam estar em ordem CRESCENTE cronologicamente falando
		int value = (int)inteira;
		int linhas = value + 1;
		
		int[][] nVezes = new int[linhas][KeyWords.size()]; //vetor que contém a quantidade que as # aparece
		
		for(int i=1; i<in.size() ; i++) {
			
			if(time[i]<(time[1]+(value2*timeset))) {
				//System.out.println(time[i] + " é menor que? " + (time[1]+(value2*timeset)));
				for(int j=0; j<Categorias.size() ; j++) {
					
					if(checkTweetCat(in.get(i),KeyWords.get(j))) {
					 	nVezes[value2-1][j]++;
						//bw.write( in.get(i) + "|" + Categorias.get(j));
					 //	System.out.println(in.get(i) +" | FOI CATEGORIZADO COMO : " + Categorias.get(j));
						//bw.newLine();
					}
				}
				
			}else {
				value2++;
				//System.out.println(value2);
				i--; //para voltar no tweet da vez (i) e contar de novo com o value2 novo
			}
		}
		//bw.close();
		//fw.close();
		
		return nVezes;
	}

	public static boolean checkTweetCat(String in, String KeyWords) throws IOException {
		
		ArrayList<String> theKey = new ArrayList<String>();
		
		for(int i=0; i< KeyWords.length(); i++) {
				int indexPos=0;
				int pos=0;

				int lastOcu = KeyWords.lastIndexOf(";");
				
				//While não chegar no fim das keywords, continua pegando-as
					while(indexPos!=(lastOcu+1)) {
					pos = KeyWords.indexOf(";",indexPos);
					theKey.add(KeyWords.substring(indexPos,pos));
					indexPos = pos+1;
													
				}
					
				//theKey contém em forma de Array, todas as keywords que são usadas para classificar uma categoria X
					
						for(int a=0; a< theKey.size(); a++) {
							if(in.toLowerCase().contains(theKey.get(a).toLowerCase())) {
							
								return true;
							}
						}
				theKey.clear();
				
				}
		
		return false;
		
	}

	@SuppressWarnings("deprecation")
	public static void createLineDayCat(ArrayList<String> in,ArrayList<String> key) throws IOException {


		TimeSeriesCollection dataset = new TimeSeriesCollection();
		ArrayList<TimeSeries> series = new ArrayList<TimeSeries>(); 
		
		int qddTweets = in.size();
		int qddCat = key.size();
		ArrayList<String> Categorias = new ArrayList<String>(); // Vetor das categorias
		ArrayList<String> KeyWords = new ArrayList<String>(); // Vetor das categorias
		int[][] nVezesCat = new int[12][qddCat]; // Vetor onde tem a quantidade que a categoria aparece
		

		long[] time = new long[in.size()]; // VETOR QUE RETIRA OS MILLIS TO TWEET
		String[] timead = new String[in.size()]; // VETOR COM DATAS AJUSTADAS
		int[] theHour = new int[in.size()];
		int[] theDay = new int[in.size()];
		int[] theMonth = new int[in.size()];
		String[] day = new String[in.size()];

		for(int i=1; i< in.size() ; i++) {
			if(in.get(i).indexOf("|")>-1) {
				int pos = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
				time[i-1] = Long.parseLong(in.get(i).substring(pos+1));
				timead[i-1] = AdjustTime(time[i-1]*1000);
				theDay[i-1] =  Integer.parseInt(timead[i-1].substring(9,11));
				theMonth[i-1] = Integer.parseInt(timead[i-1].substring(12,14));
				System.out.println(timead[i-1]);
				day[i-1] = timead[i-1].substring(9,19);
				}
			}
		
		int year = Integer.parseInt(timead[0].substring(15));
		//Construção da Array de Categorias
		for(int i=0; i< key.size() ; i++) {
			
			if(key.get(i).indexOf("|")>-1) {
				
				int pos = key.get(i).indexOf("|"); //Pega a posição que aparece "|"
				Categorias.add(key.get(i).substring(0, pos)); //adiciona em Categorias a categoria
				KeyWords.add(key.get(i).substring(pos+1));	//Construção da Array das Keywords
				//System.out.println(Categorias.get(i));
				//System.out.println(KeyWords.get(i));
			}
		}
		//System.out.println(Categorias);
		
		series = countDayDBCat(in,KeyWords,Categorias,theDay,theMonth,year);
		

	
		for (int i = 0; i < series.size(); i++) {
		  dataset.addSeries(series.get(i));
			}
		
		dataset.setDomainIsPointsInTime(true);
		System.out.println(day[0] +"---->"+ day[in.size()-1]);
		String title = day[0] + " até " + day[day.length-2];
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				title, // title
				"", // x-axis label
				"", // y-axis label
				dataset, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		chart.setBackgroundPaint(Color.white);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
		//plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
		
		renderer.setSeriesPaint(3, Color.MAGENTA);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("d MMM yyyy"));

		ChartFrame demo = new ChartFrame("Gráfico de Linhas - Categorias ", chart);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	//
		}

	public static int[][] countDayDBCatold(ArrayList<String> in, ArrayList<String> key, int[] theDays,ArrayList<String> Categorias) throws IOException {
		
		int max = 1;
		
		int value2 = 0;
		
		for (int i = 1; i < theDays.length; i++) {//aqui a iteração irá ocorrer  
	        if (theDays[i] > max){ //caso o valor da posição i seja maior que o valor de max, max será substituído pelo valor da i-ésima posição.  
	            max = theDays[i]; 
	        }
		}
		//System.out.println((max-theDays[0]));
		
		int[][] nVezes = new int[(max-theDays[1]+1)][key.size()]; //vetor que contém a quantidade que as # aparece
		
		for(int i=1; i<in.size() ; i++) {
			
			if(theDays[i]==(theDays[1]+(value2))){
				
				//System.out.println(theDays[i] + " é igual que? " + (theDays[1]+(value2)));
				
				for(int j=0; j<Categorias.size() ; j++) {
					//System.out.println(in.get(i));
					if(checkTweetCat(in.get(i),key.get(j))) {
						nVezes[value2][j]++;
						//System.out.println(in.get(i) +" | FOI CATEGORIZADO COMO : " + Categorias.get(j));
					}
				}
				
			}else {
				//value=value2+1;
				value2++;
			//	System.out.println(value2);
				i--; //para voltar no tweet da vez (i) e contar de novo com o value2 novo
			}
			
		}
		
		
		return nVezes;
	}

	public static void createLineMonthCat(ArrayList<String> in, ArrayList<String> key) throws IOException {

		int qddTweets = in.size();
		int qddCat = key.size();
		ArrayList<String> Categorias = new ArrayList<String>(); // Vetor das categorias
		ArrayList<String> KeyWords = new ArrayList<String>(); // Vetor das categorias
		//int[][] nVezesCat = new int[12][qddCat]; // Vetor onde tem a quantidade que a categoria aparece
		int[][] nVezesCat = new int[12][Categorias.size()];
		ArrayList<TimeSeries> allData = new  ArrayList<TimeSeries>(); 

		
		long[] time = new long[in.size()]; // VETOR QUE RETIRA OS MILLIS TO TWEET
		String[] timead = new String[in.size()]; // VETOR COM DATAS AJUSTADAS
		int[] theHour = new int[in.size()];
		int[] theDay = new int[in.size()];
		int[] theMonth = new int[in.size()];

		
		for(int i=1; i< in.size() ; i++) {
			if(in.get(i).indexOf("|")>-1) {
				int pos = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
				time[i-1] = Long.parseLong(in.get(i).substring(pos+1));
				timead[i-1] = AdjustTime(time[i-1]*1000);
				theDay[i-1] =  Integer.parseInt(timead[i-1].substring(9,11));
				theMonth[i-1] = Integer.parseInt(timead[i-1].substring(12,14));
			//System.out.println(timead[i-1]);
			//	System.out.println(i + "-->" + theMonth[i]);
			//	System.out.println(theDay[i]);

				}
			}
		
		
		//Construção da Array de Categorias
		for(int i=1; i< key.size() ; i++) {
			
			if(key.get(i).indexOf("|")>-1) {
				
				int pos = key.get(i).indexOf("|"); //Pega a posição que aparece "|"
				Categorias.add(key.get(i).substring(0, pos)); //adiciona em Categorias a categoria
				KeyWords.add(key.get(i).substring(pos+1));	//Construção da Array das Keywords
				//System.out.println(Categorias.get(i));
				//System.out.println(KeyWords.get(i));
			}
		}
		//System.out.println(Categorias);
		//System.out.println(KeyWords);
		
		allData = createMonthDBLine(in,KeyWords,timead,Categorias);
		
//		for(int i=0; i<12 ; i++) {
//			for(int j=0; j<Categorias.size() ; j++) {
//			//	System.out.println("linha: " + i + " coluna: "+ j  + " tem esse valor: " + nVezesCat[i][j] );
//			}
//		}
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();

		
		for(int i=0; i< allData.size() ; i++) {
		dataset.addSeries(allData.get(i));
		}
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"", // title
				"", // x-axis label
				"", // y-axis label
				dataset, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		
		chart.setBackgroundPaint(Color.white);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
		//plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
		
		renderer.setSeriesPaint(3, Color.MAGENTA);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MM.yyyy"));
		ChartFrame demo = new ChartFrame("Gráfico de Linhas - Categorias", chart);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		
	}
	
	public static int[][] createMonthDBLine_old(ArrayList<String> in, ArrayList<String> key, int[] theMonth,ArrayList<String> Categorias) throws IOException{

		
		int[][] nVezesCat = new int[12][Categorias.size()];
		
		ArrayList<Integer> dados = new ArrayList<Integer>();
		
		int month_1 = theMonth[1];
		
		int attMonth = 0;
		
		//Conferir cada tweey
		for(int i=1; i< in.size() ; i++) {
			
			int count = 0;
			
			if(theMonth[i] == month_1 + (attMonth)){
			//	System.out.println(theMonth[i] + " é igual " + month_1+ "   ?? ");
					for(int j=0; j< Categorias.size() ; j++) {
				
						if(checkTweetCat(in.get(i),key.get(j))) {
							nVezesCat[attMonth][j]++;
							}
						
					}
							
			}else {
				attMonth++;
				i--;
				}
			
		}
				

				
		
		return nVezesCat;
	}
	
	public static ArrayList<TimeSeries> createMonthDBLine(ArrayList<String> in,ArrayList<String> key,String[] timead,ArrayList<String> Categorias) throws IOException {
		
		int[][] nVezesHT = new int[13][Categorias.size()]; //vetor que contém a quantidade que as # aparece
		
		ArrayList<TimeSeries> d = new  ArrayList<TimeSeries>();  //Array que contém os objetos de cada Termo que se quer observar

		String firstTime = timead[0];
		System.out.println(firstTime);
		int pos1 = firstTime.indexOf("-");
		int pos2 = firstTime.lastIndexOf("-");
		int firstMonth = Integer.parseInt(firstTime.substring(pos1+1,pos2));
		int firstYear = Integer.parseInt(firstTime.substring(pos2+1));
		//System.out.println(firstMonth + " " + firstYear);
		
		String lastTime = timead[timead.length-2];
		System.out.println(lastTime);
		int pos11 = lastTime.indexOf("-");
		int pos22 = lastTime.lastIndexOf("-");
		int lastMonth = Integer.parseInt(lastTime.substring(pos11+1,pos22));
		int lastYear = Integer.parseInt(lastTime.substring(pos22+1));
		
		
		for(int i=1; i< in.size() ; i++) {
			
			if(timead[i-1].indexOf("-")>-1) {
				
				int pos = timead[i-1].indexOf("-");
		
				switch(timead[i-1].substring(pos+1, pos+3)) {
										
				case "01": //JANEIRO
					for(int j=0;j<Categorias.size();j++) {
		
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[1][j]++;
									}
							
					}
				break;
				case "02":
					for(int j=0;j<Categorias.size();j++) {
									
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[2][j]++;
									}
							
					}
				break;
				case "03":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[3][j]++;
									}
							
					}
				break; 
				case "04":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[4][j]++;
									}
							
					}
				break;
				case "05":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[5][j]++;
									}
							
					}
				break;
				case "06":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[6][j]++;
									}
							
					}
				break;
				case "07":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[7][j]++;
									}
							
					}
				break;
				case "08":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[8][j]++;
									}
							
					}
				break;
				case "09":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[9][j]++;
									}
							
					}
				break;
				case "10":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[10][j]++;
									}
							
					}
				break;
				case "11":
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[11][j]++;
									}
							
					}
				break;
				case "12":
					
					for(int j=0;j<Categorias.size();j++) {
						
						if(checkTweetCat(in.get(i),key.get(j))){
							
							nVezesHT[12][j]++;
									}
							
					}
				break;
				
				default:
					System.out.println("acabou");
		
				
				
				}		
				
			}	
			
		}
		
		
		for(int i=0; i< Categorias.size() ; i++) {
			
			TimeSeries series = new TimeSeries(Categorias.get(i), Month.class); 
			d.add(series);
		}	
		
		for(int i=0; i< Categorias.size() ; i++) {
			
			for(int j=1; j<= 12 ; j++) {
				
				d.get(i).add(new Month(firstMonth, firstYear), nVezesHT[firstMonth][i]);
				if(firstMonth==12) {
					firstYear++;
					firstMonth=1;
				}else if(firstMonth==lastMonth) {
					j=13;
					}else{
				firstMonth++;}
			}
			
			firstMonth = Integer.parseInt(firstTime.substring(pos1+1,pos2));
			firstYear = Integer.parseInt(firstTime.substring(pos2+1));
		}

		
		return d;
	}

	public static void createLineDay(ArrayList<String> in,ArrayList<String> key) {
	

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		ArrayList<TimeSeries> series = new ArrayList<TimeSeries>(); 
	int[][] nVezes; //vetor que contém a quantidade que as # aparece
	
//	ArrayList<XYSeries> d = new  ArrayList<XYSeries>();  //Array que contém os objetos de cada Termo que se quer observar
//		
	ArrayList<XYSeries> allData = new  ArrayList<XYSeries>(); 

	long[] time = new long[in.size()]; // VETOR QUE RETIRA OS MILLIS TO TWEET
	String[] timead = new String[in.size()]; // VETOR COM DATAS AJUSTADAS
	int[] theDay = new int[in.size()];
	int[] theMonth = new int[in.size()];
	int year = 0;
	
	
	
	for(int i=1; i< in.size() ; i++) {
		if(in.get(i).indexOf("|")>-1) {
			int pos = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
			time[i-1] = Long.parseLong(in.get(i).substring(pos+1));
			timead[i-1] = AdjustTime(time[i-1]);
			theDay[i-1] =  Integer.parseInt(timead[i-1].substring(9,11));
			theMonth[i-1] = Integer.parseInt(timead[i-1].substring(12,14));
			//System.out.println(theDay[i-1]);
			}
		}
	
	year = Integer.parseInt(timead[0].substring(15));
	//nVezes = countDayDB(in,key,theDay);
	
	ArrayList<ArrayList<Integer>> todosDias = new ArrayList<ArrayList<Integer>>();
	
	series = countDayDB(in,key,theDay,theMonth,year);

	
	for (int i = 0; i < series.size(); i++) {
	  dataset.addSeries(series.get(i));
		}
	
	dataset.setDomainIsPointsInTime(true);
	
	//String title = "Tweets: " + (in.size()-1);
	
	JFreeChart chart = ChartFactory.createTimeSeriesChart(
			"", // title
			"", // x-axis label
			"", // y-axis label
			dataset, // data
			true, // create legend?
			true, // generate tooltips?
			false // generate URLs?
			);
			chart.setBackgroundPaint(Color.white);
			XYPlot plot = (XYPlot) chart.getPlot();
			plot.setBackgroundPaint(Color.white);
			plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
			plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
			//plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
			plot.setDomainCrosshairVisible(true);
			plot.setRangeCrosshairVisible(true);
			XYItemRenderer r = plot.getRenderer();
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			
			renderer.setSeriesPaint(3, Color.MAGENTA);
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);

			DateAxis axis = (DateAxis) plot.getDomainAxis();
			axis.setDateFormatOverride(new SimpleDateFormat("d MMM yyyy"));

			ChartFrame demo = new ChartFrame("Gráfico de Linhas - Categorias ", chart);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
	
}

	@SuppressWarnings("unchecked")
	public static ArrayList<TimeSeries> countDayDB(ArrayList<String> in, ArrayList<String> key, int[] theDays,int[] theMonth, int year) {
	
	ArrayList<TimeSeries> series = new ArrayList<TimeSeries>(); 
	
	int novodia = 0;
		
	ArrayList<Integer> grupoDias = new ArrayList<Integer>();
	
	ArrayList<ArrayList<Integer>> todosDias = new ArrayList<ArrayList<Integer>>();
	
	grupoDias.add(0);
	todosDias.add(grupoDias);

	
	for(int j=0; j<key.size()-1 ; j++) {
		todosDias.add(j,(ArrayList<Integer>) grupoDias.clone());
		todosDias.get(j).add(0);
	}
	//int[][] nVezes = new int[(max-theDays[1]+1)][key.size()]; //vetor que contém a quantidade que as # aparece

	
	for(int i=1; i<in.size() ; i++) {
		
		
		
		if(theDays[i-1]==(theDays[0]+(novodia))){
			
			//System.out.println(theDays[i] + " é igual que? " + (theDays[1]+(novodia)));
			
			for(int j=1; j<key.size() ; j++){
			
				if(checkTweet(in.get(i),key.get(j))){
					//nVezes[value2][j-1]++;
					//System.out.println(j-1);
					int old = todosDias.get(j-1).get(novodia);
				//	System.out.println("old: "+old);
					todosDias.get(j-1).set(novodia,old+1);
				//	System.out.println("linha: " + novodia +" coluna: "+ (j-1) + " = "+todosDias.get(j-1).set(novodia,old+1));
				}
				
			}	
			
		}else{

			novodia++;
		
			for(int j=0; j<key.size()-1 ; j++) {
			todosDias.get(j).add(0);}
			i--; //para voltar no tweet da vez (i) e contar de novo com o value2 novo
		}
		
		
	}
	

	int day_1 = theDays[1];
	
	int month_1 = theMonth[1];
	
	//System.out.println(theDay[1]);

	
	for(int j = 0; j < key.size()-1; j++) {
		
		TimeSeries serieN = new TimeSeries(key.get(j+1));
		
			for (int i = 0; i <= novodia ; i++) {
				
				serieN.add(new Day(day_1,month_1,year), todosDias.get(j).get(i));
				day_1++;
				
			System.out.println(key.get(j+1)+ i +","+ j + "->" + todosDias.get(j).get(i));
				if(day_1 == 01) {month_1++;}
				if(day_1 == 32) {day_1 = 1;}
				}
			
				series.add(serieN);
				day_1 = theDays[1];
				month_1 = theMonth[1];
	}
	
	
	return series;
}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<TimeSeries> countDayDBCat(ArrayList<String> in,ArrayList<String> KeyWords, ArrayList<String> Categorias, int[] theDays,int[] theMonth, int year) throws IOException {
		
		ArrayList<TimeSeries> series = new ArrayList<TimeSeries>(); 
		
		int novodia = 0;
			
		ArrayList<Integer> grupoDias = new ArrayList<Integer>();
		
		ArrayList<ArrayList<Integer>> todosDias = new ArrayList<ArrayList<Integer>>();
		
		grupoDias.add(0);
		todosDias.add(grupoDias);

		
		for(int j=0; j<Categorias.size()-1 ; j++) {
			todosDias.add(j,(ArrayList<Integer>) grupoDias.clone());
			todosDias.get(j).add(0);
		}
		//int[][] nVezes = new int[(max-theDays[1]+1)][key.size()]; //vetor que contém a quantidade que as # aparece

		
		for(int i=1; i<in.size() ; i++) {
			
			
			//System.out.println(theDays[i] + " é igual que? " + (theDays[0]+(novodia)));
			
			if(theDays[i-1]==(theDays[0]+(novodia))){
				
				//System.out.println(theDays[i] + " é igual que? " + (theDays[1]+(novodia)));
				
				for(int j=1; j<Categorias.size() ; j++){
				
					if(checkTweetCat(in.get(i),KeyWords.get(j))){
						//nVezes[value2][j-1]++;
						//System.out.println(j-1);
						int old = todosDias.get(j-1).get(novodia);
					//	System.out.println("old: "+old);
						todosDias.get(j-1).set(novodia,old+1);
					//	System.out.println("linha: " + novodia +" coluna: "+ (j-1) + " = "+todosDias.get(j-1).set(novodia,old+1));
					}
					
				}	
				
			}else if(theDays[0]!=01 && theDays[i-1]==01){
				theDays[0]=1;
			//	System.out.println(theDays[0]);
				for(int j=0; j<Categorias.size()-1 ; j++) {
				todosDias.get(j).add(0);}
				i--; //para voltar no tweet da vez (i) e contar de novo com o value2 novo
			
			}else{
				novodia++;
				//System.out.println(novodia);
				for(int j=0; j<Categorias.size()-1 ; j++) {
				todosDias.get(j).add(0);}
				i--; //para voltar no tweet da vez (i) e contar de novo com o value2 novo
			}
			
			
		}
		

		int day_1 = theDays[1];
		
		int month_1 = theMonth[1];
		
		System.out.println(month_1);

		
		for(int j = 0; j < Categorias.size()-1; j++) {
			
			TimeSeries serieN = new TimeSeries(Categorias.get(j+1));
			
				for (int i = 0; i <= novodia ; i++) {
					
					serieN.add(new Day(day_1,month_1,year), todosDias.get(j).get(i));
					day_1++;
					
				//System.out.println(Categorias.get(j+1)+ i +","+ j + "->" + todosDias.get(j).get(i));
					//if(day_1 == 1) {month_1++;}
					if(day_1 == 32) {
						day_1 = 1;
						month_1++;}
					}
				
					series.add(serieN);
					day_1 = theDays[1];
					month_1 = theMonth[1];
		}
		
		
		return series;
	}
	
}
