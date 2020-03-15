package lucastorie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class DataEntry {
		
	static JFileChooser fileChooser = new JFileChooser();
	static StringBuilder sb = new StringBuilder();
	static String FinalName = new String();
	static String nameWords = new String();
	
	//dataEntry
	static String fileCname = new String();
	static String fileName = new String();

	//opinion
	static String wordsPro = new String();
	static String wordsAgainst = new String();
	static String wordsImparcial = new String();

	//MÉTODO QUE RETORNA A FILE JÁ LIDA
	public static ArrayList<String> dataEntry(String FileName) {
		
		File cam0 = new File(FileName);
		
		System.out.println(cam0);
		
		ArrayList<String> tweets = DataEntry.read_file(cam0);
		
		return tweets; //RETORNO O ARQUIVO EXTRAÍDO DO PC, JÁ LIDO.
	}
	
	
	//MÉTODO PARA LEITURA DE ARQUIVOS
	public static ArrayList<String> read_file(File file) {
	  	
		
		ArrayList<String> links = new ArrayList<String>();
		try{   
			String linha = "";
	  		
	  		InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");  
	  		BufferedReader br = new BufferedReader(reader);  
	  		
	  		while(br.ready()){  
	  			linha = br.readLine(); 
	  			
	  		  			if (linha.trim().length() == 0)
	  				continue;
	  			links.add(linha);
	  			}  
	  		br.close();  
	  		reader.close();
	  	}
	  	catch(IOException ioe) {ioe.printStackTrace();}
		return links;
	}
	

	public static String PickMe() {
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//Get the file
			File file = fileChooser.getSelectedFile();
			FinalName = file.getName();
		
			//System.out.println(name);
			
		}else {
			sb.append("Nenhum arquivo foi escolhido");
		}
		
		return FinalName;
	}
	
	public static String PickMeWords() {
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//Get the file
			File file = fileChooser.getSelectedFile();
			nameWords = file.getName();
		
			//System.out.println(name);
			
		}else {
			sb.append("Nenhum arquivo foi escolhido");
		}
		
		return nameWords;
	}

	public static String PickMePro() {
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//Get the file
			File file = fileChooser.getSelectedFile();
			wordsPro = file.getName();
		
			//System.out.println(name);
			
		}else {
			sb.append("Nenhum arquivo foi escolhido");
		}
		
		return wordsPro;
	}
	
	public static String PickMeAgainst() {
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//Get the file
			File file = fileChooser.getSelectedFile();
			wordsAgainst = file.getName();
		
			//System.out.println(name);
			
		}else {
			sb.append("Nenhum arquivo foi escolhido");
		}
		
		return wordsAgainst;
	}
	
	public static String PickMeImparcial() {
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//Get the file
			File file = fileChooser.getSelectedFile();
			wordsImparcial = file.getName();
		
			//System.out.println(name);
			
		}else {
			sb.append("Nenhum arquivo foi escolhido");
		}
		
		return wordsImparcial;
	}
	
	
	public static int nTweets(ArrayList<String> in) {
		
		int n = in.size();
		
		return n;
	}
	
	
	
	
}
