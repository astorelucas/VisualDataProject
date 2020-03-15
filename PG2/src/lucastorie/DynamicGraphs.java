package lucastorie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSourceDGS;
import org.graphstream.stream.file.FileSinkImages.LayoutPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputType;
import org.graphstream.stream.file.FileSinkImages.Quality;
import org.graphstream.stream.file.FileSinkImages.RendererType;
import org.graphstream.stream.file.FileSinkImages.Resolution;
import org.graphstream.stream.file.FileSinkImages.Resolutions;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

public class DynamicGraphs {
	

	
	public static void ImageGraph(String thefile, ArrayList<String> tweet, int setpoint) throws InterruptedException, IOException {
		

//		OutputPolicy outputPolicy = OutputPolicy.BY_STEP;
//		String prefix = "prefix";
//		OutputType type = OutputType.JPG;
//		Resolution resolution = Resolutions.HD720;
//		FileSinkImages fsi = new FileSinkImages(prefix, type, resolution, outputPolicy);
//		
//		FileSourceDGS dgs = new FileSourceDGS();

		
		ArrayList<String> users = new ArrayList<String>(); //Usuários 
		ArrayList<String> idfotos = new ArrayList<String>(); //Numero da foto
		
		for(int i=0; i< tweet.size() ; i++) {
			if(tweet.get(i).indexOf("|")>-1) {
				int end = tweet.get(i).lastIndexOf("|");
				users.add(tweet.get(i).substring(0,end)); 
				
				idfotos.add(tweet.get(i).substring(end+1));
				}
			}
			
		
		Set<String> Users2 = new HashSet<>();
		for(String a: users) {
			Users2.add(a);
		}
		
		ArrayList<String> uniqueUsers = new ArrayList<String>();  //***********
		uniqueUsers.addAll(Users2);	
		
		//System.out.println(idfotos);
		
		Set<String> Idfotos2 = new HashSet<>();
		for(String a: idfotos) {
			Idfotos2.add(a);
		}
		
		ArrayList<String> uniqueIdfotos = new ArrayList<String>();  //***********
		uniqueIdfotos.addAll(Idfotos2);	
				
		//System.out.println(usersfotos);
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Graph graph = new SingleGraph("Image Relevance");

		Viewer viewer = graph.display();
		ViewPanel view = viewer.getDefaultView();
		
//		if (gerar=true) {
//		graph.addSink(fsi);
//		fsi.setOutputPolicy(OutputPolicy.BY_STEP);
//		fsi.setLayoutPolicy(LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
//		fsi.setQuality(Quality.HIGH);
//		fsi.setRenderer(RendererType.SCALA);
//		}
		
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");
		graph.addAttribute("stylesheet", "node {size:5px;}");
		graph.addAttribute("stylesheet", "graph {padding : 100px;}");
		
		//NÓS DOS USERS
//		for(int i=0; i< uniqueUsers.size() ; i++) {
//		
//			graph.addNode(uniqueUsers.get(i));
//			Node n = graph.getNode(uniqueUsers.get(i)); 
//			//n.addAttribute("ui.label", uniqueUsers.get(i));
//			n.addAttribute("ui.style", "fill-color: rgb(18,10,143);");
//			n.addAttribute("ui.style", "size-mode: dyn-size;");
//			n.addAttribute( "ui.hide" );
//			n.addAttribute("ui.size",5);
//			n.setAttribute("foo", uniqueUsers.get(i)); 
//					
//		}
		
		//System.out.println(uniqueIdfotos);
		//String filePath0 = "fill-image: url('C:\\Users\\Lucas Astore\\Documents\\TCC\\Dados teste\\images\\000');";
		//String thefile = "C:\\\\Users\\\\Lucas Astore\\\\Documents\\\\TCC\\\\Dados teste\\\\images\\\\000";
		String filePath0 = "fill-image: url('" + thefile + "\\000');";
		String filePath = filePath0.replace("000", uniqueIdfotos.get(0)); //fiz isso para começar do primeira imagem
		

		
		int vezes =0;
		int ant=0;
		int t=0;
		
		//NÓS DAS IMAGENS - aqui eu fiz um algoritmo para que apenas aparecer o nó se o numero de vezes for igual ao setpoint
		for(int i=0; i<uniqueIdfotos.size() ; i++) {
			int contador=0;
		
						for(t=0; t<idfotos.size(); t++) {
				
								if(uniqueIdfotos.get(i).equals(idfotos.get(t))) {
										contador++;
															}
															}
		
		if(contador>setpoint) {
		
		System.out.println(uniqueIdfotos.get(i) + " " + contador);
		//System.out.println(i);
		//
		graph.addNode(uniqueIdfotos.get(i));
		Node ni = graph.getNode(uniqueIdfotos.get(i)); 

		//na primeira vez entrando fazendo o nó, é necessário trocar o i=0 com o novo
		if (vezes==0){
			filePath = filePath.replace(uniqueIdfotos.get(0), uniqueIdfotos.get(i));
			ni.addAttribute("ui.style", "fill-mode: image-scaled;");
			ni.addAttribute("ui.style", filePath);
			vezes++;
		}
			else {
				
				filePath = filePath.replace(uniqueIdfotos.get(ant), uniqueIdfotos.get(i));
				ni.addAttribute("ui.style", "fill-mode: image-scaled;");
				ni.addAttribute("ui.style", filePath);
				}
		ant = i; //para trocar a id anterior usada com a nova i
		}
		
		else {Thread.sleep(10);
		
		}
		
		}

		
		
		//LABEL PARA NOMEAR OS EDGES
		ArrayList<String> label = new ArrayList<String>();
		for(int i=0; i< tweet.size() ; i++) {
			label.add(Integer.toString(i));
					
		}
		
		//CRIAÇÃO DOS EDGES 
		for(int i=0; i<tweet.size(); i++) {
			//System.out.println(i);
			int j = 10;
			int count = 1;
			int contador =0;
			
//			if(gerar=true) {
//			graph.stepBegins(i);
//			fsi.begin(prefix);
//			}
						for(int te=0; te<tweet.size(); te++) {
				
								if(idfotos.get(i).equals(idfotos.get(te))) {
										contador++;
																			}
															}
			if(contador>setpoint) {
			//try {
//			Edge e = graph.addEdge(label.get(i), users.get(i), idfotos.get(i));
//			e.addAttribute( "ui.hide" );
//			} catch(Exception e) {}
			
			for(int u=0; u < i ; u++) {
				if(idfotos.get(u).contains(idfotos.get(i))) count++;
			}
			
				Node w = graph.getNode(idfotos.get(i));
				w.addAttribute("ui.style", "size-mode: dyn-size;");
				
				if(count < setpoint + 50) {
					w.addAttribute("ui.size",(j)*(15));
					w.addAttribute("ui.style", "text-background-mode: rounded-box;");
					w.addAttribute("ui.style", "text-background-color: #ffff00;");
					w.addAttribute("ui.style","shadow-mode: plain;");
					w.addAttribute("ui.style","shadow-color: #ffff00;");
					w.addAttribute("ui.label", count);
					w.addAttribute("ui.style", "text-size: 15;");
				
				}
				
				if((count < setpoint + 100)&&(count>setpoint + 50)) { 
						w.addAttribute("ui.size",(j)*(20));
						w.addAttribute("ui.style", "text-background-mode: rounded-box;");
						w.addAttribute("ui.style", "text-background-color: #ff9933;");
						w.addAttribute("ui.style","shadow-mode: plain;");
						w.addAttribute("ui.style","shadow-color: #ff9933;");
						w.addAttribute("ui.label", count);
						w.addAttribute("ui.style", "text-size: 15;");
						
					}
				
				if((count < setpoint + 150)&&(count>setpoint + 100)) { 
					w.addAttribute("ui.size",(j)*(25));
					w.addAttribute("ui.style", "text-background-mode: rounded-box;");
					w.addAttribute("ui.style", "text-background-color: #ff6600;");
					w.addAttribute("ui.style","shadow-mode: plain;");
					w.addAttribute("ui.style","shadow-color: #ff6600;");
					w.addAttribute("ui.label", count);
					w.addAttribute("ui.style", "text-size: 17;");
					
				}
				
				if((count < setpoint + 200)&&(count>setpoint + 150)) { 
					w.addAttribute("ui.size",(j)*(30));
					w.addAttribute("ui.style", "text-background-mode: rounded-box;");
					w.addAttribute("ui.style", "text-background-color: #ff3300;");
					w.addAttribute("ui.style","shadow-mode: plain;");
					w.addAttribute("ui.style","shadow-color: #ff3300;");
					w.addAttribute("ui.label", count);
					w.addAttribute("ui.style", "text-size: 18;");
					
				}
				
				if((count > setpoint + 200)) { 
					w.addAttribute("ui.size",(j)*(35));
					w.addAttribute("ui.style", "text-background-mode: rounded-box;");
					w.addAttribute("ui.style", "text-background-color: #ff0000;");
					w.addAttribute("ui.style","shadow-mode: plain;");
					w.addAttribute("ui.style","shadow-color: #ff0000;");
					w.addAttribute("ui.label", count);
					w.addAttribute("ui.style", "text-size: 18;");
					w.addAttribute("ui.style", "text-color: #FFFFFF;");
					
				}
					
//					
//				if(count<20) {
//				w.addAttribute("ui.size",j*(count));
//				}
		     	//e.addAttribute("layout.weight",10);
				//Thread.sleep(50);
			}
			else {
				Thread.sleep(10);
			}
			Thread.sleep(50);
		}
		

	}

	
	public static void RTGraph(ArrayList<String> tweet, int setup) throws InterruptedException {
		
		//int setup = 2;

		ArrayList<String> usersRTotal = new ArrayList<String>(); //Usuários que receberam RT
		ArrayList<String> usersRTUnique = new ArrayList<String>(); //Usuários que derem RT
		ArrayList<Integer> contagem= new ArrayList<Integer> ();
		ArrayList<String> fromUser = new ArrayList<String> (); //usuário que deu RT
		ArrayList<String> uniquefromUser = new ArrayList<String> ();
		
		for(int i=0; i< tweet.size() ; i++) {
			if(tweet.get(i).indexOf("RT @")>-1) {
				int c = tweet.get(i).indexOf("RT @");;
				int start = tweet.get(i).indexOf("@",c);
				int end = tweet.get(i).indexOf(": ",c);
				if(end>-1) {
					usersRTotal.add(tweet.get(i).substring(start,end)); //adiciona em usersRT o usuário que receberam RT
					if(tweet.get(i).indexOf("|")>-1) {
						int start2 = tweet.get(i).lastIndexOf("|");
						fromUser.add(tweet.get(i).substring(start2));
					}
				}
				}
			
			
			
			}

		usersRTUnique.add(usersRTotal.get(0));
		contagem.add(0);
		uniquefromUser.add(fromUser.get(0));
		
		for(String c0: usersRTotal){ 
		            boolean found = false;
		            
		            for(String c: usersRTUnique){
		               
		            	if(c0.equals(c)) { 
		                    found = true;
		                	}
		            }
	                if(found==false) {
	                	usersRTUnique.add(c0);
	                	contagem.add(0);
	                }
		    }
		

		for(int i =0; i<usersRTUnique.size(); i++) {
			
			 for(String c: usersRTotal){
				
				 if(usersRTUnique.get(i).equals(c)) {
					 int count = contagem.get(i) +1;
					 contagem.set(i,count);
				 }
			}
		}
		
		for(String c0: fromUser){ 
	        boolean found = false;
	        
	        for(String c: uniquefromUser){
	           
	        	if(c0.equals(c)) { 
	                found = true;
	            	}
	        }
	        if(found==false) {
	        	uniquefromUser.add(c0);
	        }
	}
		
		System.setProperty("org.graphstream.ui.renderer",
				"org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Graph graph = new SingleGraph("RT Relevance");
		
		graph.display();
		
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");
		graph.addAttribute("stylesheet", "node {size:10px;}");
		//graph.addAttribute("stylesheet", "edge {arrow-shape: arrow; arrow-size: 15px, 10px;}");
		
		for(int i=0; i< usersRTUnique.size() ; i++) {
			if(contagem.get(i)>setup) {
			graph.addNode(usersRTUnique.get(i));
			Node n = graph.getNode(usersRTUnique.get(i)); //nomeei o nó A como n
			n.addAttribute("ui.label", usersRTUnique.get(i));
			n.addAttribute("ui.style", "fill-color: rgb(0,100,255);");
			n.setAttribute("foo", usersRTUnique.get(i)); //armazenei a string ''bar'' nele, ''foo'' é uma chave
			}else {
				graph.addNode(usersRTUnique.get(i));
				Node n = graph.getNode(usersRTUnique.get(i)); //nomeei o nó A como n
				n.addAttribute("ui.label", usersRTUnique.get(i));
				//n.setAttribute("foo", usersUnique.get(i)); //armazenei a string ''bar'' nele, ''foo'' é uma chave
				n.addAttribute( "ui.hide" );
			}
		}
		
		ArrayList<String> label = new ArrayList<String>();
		for(int i=0; i< tweet.size() ; i++) {
			label.add(Integer.toString(i));
					
		}
		
		for(int i=0; i< uniquefromUser.size() ; i++) {
		
			graph.addNode(uniquefromUser.get(i));
			Node n = graph.getNode(uniquefromUser.get(i)); //nomeei o nó A como n
			n.addAttribute("ui.label", uniquefromUser.get(i));
			n.addAttribute("ui.style", "fill-color: rgb(100,100,255);");
			n.setAttribute("foo", uniquefromUser.get(i)); //armazenei a string ''bar'' nele, ''foo'' é uma chave
			n.addAttribute( "ui.hide" );
		}
		
		for(int i=0; i<usersRTotal.size(); i++) {
			int j = 10;
			int count = 1;
			int colorid = 100;
			Edge e = graph.addEdge(label.get(i), fromUser.get(i), usersRTotal.get(i));
			e.addAttribute("ui.hide");
			
			for(int u=0; u < i ; u++) {
				if(usersRTotal.get(u).equals(usersRTotal.get(i))) count++;
			}
			
				Node w = graph.getNode(usersRTotal.get(i));
				w.addAttribute("ui.style", "size-mode: dyn-size;");
				w.addAttribute("ui.size",j+10*(1+count));
				//w.addAttribute("ui.size",j+Math.log10(1+count));
				w.addAttribute("ui.style", "fill-color: rgb(255,200,16);");
			
				colorid=colorid*count;
				if (colorid >255) {colorid=255;}
				String color = "fill-color: rgb(255,150,"+colorid+");";
				w.addAttribute("ui.style", color);

				Thread.sleep(200);
		}
		
		System.out.println("Fim.");
	}

	public static void RTGraphAll(ArrayList<String> tweet, int setpoint) throws InterruptedException {
		
		//int setpoint = 1;

		ArrayList<String> usersRTotal = new ArrayList<String>(); //Usuários que receberam RT
		ArrayList<String> usersRTUnique = new ArrayList<String>(); //Usuários que derem RT
		ArrayList<Integer> contagem= new ArrayList<Integer> ();
		ArrayList<String> removed = new ArrayList<String> (); //usuário que deu RT
//		ArrayList<String> uniquefromUser = new ArrayList<String> ();
		
		for(int i=0; i< tweet.size() ; i++) {
			if(tweet.get(i).indexOf("RT @")>-1) {
				int c = tweet.get(i).indexOf("RT @");;
				int start = tweet.get(i).indexOf("@",c);
				int end = tweet.get(i).indexOf(": ",c);
				if(end>-1) {
					usersRTotal.add(tweet.get(i).substring(start,end)); //adiciona em usersRT o usuário que receberam RT
//					if(tweet.get(i).indexOf("|")>-1) {
//						int start2 = tweet.get(i).lastIndexOf("|");
//						fromUser.add(tweet.get(i).substring(start2));
//					}
				}
				}
			
			
			
			}

		usersRTUnique.add(usersRTotal.get(0));
		contagem.add(0);
		//uniquefromUser.add(fromUser.get(0));
		
		for(String c0: usersRTotal){ 
		            boolean found = false;
		            
		            for(String c: usersRTUnique){
		               
		            	if(c0.equals(c)) { 
		                    found = true;
		                	}
		            }
	                if(found==false) {
	                	usersRTUnique.add(c0);
	                	contagem.add(0);
	                }
		    }
		

		for(int i =0; i<usersRTUnique.size(); i++) {
			
			 for(String c: usersRTotal){
				
				 if(usersRTUnique.get(i).equals(c)) {
					 int count = contagem.get(i)+1;
					 contagem.set(i,count);
				 }
			}
		}
//		System.out.println(usersRTUnique);
//		System.out.println(contagem);
		
		for(int i =0; i<usersRTUnique.size(); i++) {
			
			if(contagem.get(i)<setpoint) {
				removed.add(usersRTUnique.get(i));		
			}
		}
//		System.out.println(removed);
//		System.out.println("    --    ");
//		System.out.println(usersRTUnique);
	//	
		
		for(int i =0; i<usersRTotal.size(); i++) {
		
			for(int j =0; j<removed.size(); j++) {
			
				if(usersRTotal.get(i).equals(removed.get(j))) {

					usersRTotal.remove(i);
				
			}
		}
	}
		
		for(int i =0; i<usersRTUnique.size(); i++) {
			
			for(int j =0; j<removed.size(); j++) {
			
				if(usersRTUnique.get(i).equals(removed.get(j))) {

					usersRTUnique.remove(i);
				
			}
		}
			
	}
		
//		System.out.println(removed);
//		System.out.println("    --    ");
//		System.out.println(usersRTUnique);
		
	//	
		System.setProperty("org.graphstream.ui.renderer",
				"org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Graph graph = new SingleGraph("RT Relevance");
		
		graph.display();
		
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");
		graph.addAttribute("stylesheet", "node {size:10px;}");
		//graph.addAttribute("stylesheet", "edge {arrow-shape: arrow; arrow-size: 15px, 10px;}");
		
		for(int i=0; i< usersRTUnique.size() ; i++) {

			graph.addNode(usersRTUnique.get(i));
			Node n = graph.getNode(usersRTUnique.get(i)); //nomeei o nó A como n
			n.addAttribute("ui.label", usersRTUnique.get(i));
			n.addAttribute("ui.style", "fill-color: rgb(0,100,255);");
			n.setAttribute("foo", usersRTUnique.get(i)); //armazenei a string ''bar'' nele, ''foo'' é uma chave
			
		}
		
		ArrayList<String> label = new ArrayList<String>();
		for(int i=0; i< tweet.size() ; i++) {
			label.add(Integer.toString(i));
					
		}
		
//		for(int i=0; i< uniquefromUser.size() ; i++) {
	//	
//			graph.addNode(uniquefromUser.get(i));
//			Node n = graph.getNode(uniquefromUser.get(i)); //nomeei o nó A como n
//			n.addAttribute("ui.label", uniquefromUser.get(i));
//			n.addAttribute("ui.style", "fill-color: rgb(100,100,255);");
//			n.setAttribute("foo", uniquefromUser.get(i)); //armazenei a string ''bar'' nele, ''foo'' é uma chave
//			n.addAttribute( "ui.hide" );
//		}
	//	
		for(int i=0; i<usersRTotal.size(); i++) {
			int j = 10;
			int count = 1;
			int colorid = 255;
//			Edge e = graph.addEdge(label.get(i), fromUser.get(i), usersRTotal.get(i));
//			e.addAttribute("ui.hide");
			
			for(int u=0; u < i ; u++) {
				if(usersRTotal.get(u).equals(usersRTotal.get(i))) count++;
			}
			
				Node w = graph.getNode(usersRTotal.get(i));
				w.addAttribute("ui.style", "size-mode: dyn-size;");
				w.addAttribute("ui.size",j+10*(1+count));
				//w.addAttribute("ui.size",j+Math.log10(1+count));
				w.addAttribute("ui.style", "fill-color: rgb(255,200,16);");
				w.addAttribute("ui.style","shadow-mode: gradient-vertical;");
				//w.addAttribute("ui.style","shadow-color: #FF0000;");
				w.addAttribute("ui.style","shadow-width: 0;");
				w.addAttribute("ui.style","shadow-offset: 1;");
			
				if(count == setpoint) {
				
					String color = "fill-color: rgb(255,200,16);";
					w.addAttribute("ui.style", color);
					
				}
				
				if(count > setpoint && count < setpoint*1.5) {
					
					String color = "fill-color: rgb(255,"+(colorid-5*count)+", 230);";
					w.addAttribute("ui.style", color);
					
				}
				
				if(count > setpoint*1.5 && count < setpoint*2) {
					
					String color = "fill-color: rgb(255,"+(colorid-15*count)+", 30);";
					w.addAttribute("ui.style", color);
					
				}
				
				if(count > setpoint*2) {
					
					String color = "fill-color: rgb(255,"+(colorid-20*count)+",0);";
					if(colorid-20*count < 0) {color = "fill-color: rgb(255,0,0);";}
					w.addAttribute("ui.style", color);
					
				}
				

				Thread.sleep(200);
		}
		
		System.out.println("Fim.");
	}	

	
	
}
