package lucastorie;

import java.io.File;

import RotularDados.MainRotulo;

public class TextualAnalysis {
	

	public static void nGrams(String in , String out, int N, int FC) {
		MainRotulo.ngrams(in,out,N,FC);
	}
	
	public static void AW(String in ,String cla, String out, float F) {
		float percentage;
		percentage = F/100;
		MainRotulo.abrangenciaWords(in,cla,out,percentage);
		System.out.println("acabou.");
	}

	public static void obterRegras(String in ,String cla) {
		MainRotulo.obterRegras(in,cla,5);
	}
	
	public static void obterRegrasCanonino(String in ,String cla){
		MainRotulo.obterRegrasCanonino(in,cla,2);
	}
	
	public static void obterRegrasCanoninoFiltro(String in ,String cla) {
		MainRotulo.obterRegrasCanoninoFiltro(in,cla,2);
	}
	
	public static void aplicarRegras(String in,String regras) {
		MainRotulo.aplicarRegras(in,regras);
	}
	
	public static void removeStopWords(String in, String stopList) {
		
		if(stopList!="") {
			MainRotulo.removeStopWords(new File(in),new File(stopList));}
		else {
			MainRotulo.removeStopWords(new File(in));
		}
		
	}
	
	//MainRotulo.removeStopWords(new File("textos.csv"),new File("stoplist.txt"));
	//MainRotulo.removeStopWords(new File("textos.csv"));
	//MainRotulo.removeStopWords(ArrayList<String> text,new File("stoplist.txt"));
	//MainRotulo.removeStopWords(ArrayList<String> text);
	
	//MainRotulo.canonico(new File("textos.csv"),false);
	//MainRotulo.canonico(ArrayList<String> lista,false);
	
	//MainRotulo.ngrams("textos.csv","ngram_2.txt",2,1); OK
	//MainRotulo.abrangenciaWords("textos.csv","classes.csv",0.3f);
	//MainRotulo.obterRegras("textos.csv","classes.csv",1);
	//MainRotulo.obterRegrasCanonino("textos.csv","classes.csv",2);
	//MainRotulo.obterRegrasCanoninoFiltro("textos.csv","classes.csv",2);
	//MainRotulo.aplicarRegras("textos.csv","Regras.csv");
	//MainRotulo.exato("textos.csv","RegrasManuaisExatas.csv","saidaExata_1.txt");
	
	
	
	
	//MainRotulo.misto("textos.csv","RegrasManuaisMistas.csv","saidaMista_1.txt");
	//MainRotulo.exatoCanonico("textos.csv","RegrasManuaisExatas.csv","saidaExata_2.txt");
	//MainRotulo.mistoCanonico("textos.csv","RegrasManuaisMistas.csv","saidaMista_2.txt");
	//MainRotulo.exatoCanonicoFiltro("textos.csv","RegrasManuaisExatas.csv","saidaExata_3.txt");
	//MainRotulo.mistoCanonicoFiltro("textos.csv","RegrasManuaisMistas.csv","saidaMista_3.txt");
	

}
