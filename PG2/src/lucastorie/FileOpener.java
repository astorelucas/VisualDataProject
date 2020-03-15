package lucastorie;

import java.io.File;

import javax.swing.JFileChooser;

public class FileOpener {
	
	static JFileChooser fileChooser = new JFileChooser();
	static String fileName = new String();
	static StringBuilder sb = new StringBuilder();
	
	static JFileChooser fileChooserCat = new JFileChooser();
	static String fileNameCat = new String();
	static StringBuilder sbCat = new StringBuilder();
	
	public static String pickTheTweetsFile() {
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//Get the file
			File file = fileChooser.getSelectedFile();
		
			fileName = file.getPath();
					
		//	System.out.println(f);
			
			}else {
				sb.append("Nenhum arquivo foi escolhido");
				}
		
	return fileName;
	}
	
	public static String pickTheCatFile() {
		
		if(fileChooserCat.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//Get the file
			File file = fileChooserCat.getSelectedFile();
			
			fileNameCat = file.getPath();
					
			}else {
				sbCat.append("Nenhum arquivo foi escolhido");
				}
		
	return fileNameCat;
	}
	

	

}
