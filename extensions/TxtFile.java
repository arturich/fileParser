package extensions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TxtFile implements FileParser{

	File file;

	public TxtFile(File file){
		this.file = file;
	}
	
	public boolean openFile() {		
		
		//paranoic check if exist
		if(file.exists())
			return true;
		else
			return false;
	}
	
	
	public ArrayList<String>parse(){
		ArrayList<String> words = new ArrayList<String>();

		try {
		Scanner reader = new Scanner(file);

		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			words.addAll(Arrays.asList(data.split(" ")));			
		  }
		  reader.close();
		
		} catch(FileNotFoundException e){
			System.out.println("File was not found: " + file.getName());	
		}
		return words;		
	}

}
