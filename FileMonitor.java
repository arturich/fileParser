import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;

import extensions.TxtFile;
import statistics.FileStatistics;

import java.io.File;

public class FileMonitor extends Thread {

File files[], folder;
int numFiles = 0;
long size = 0;
Hashtable<String,Long> currFiles;
ArrayList<String> supExt ;


//Contructor set the current supported extensions and folder
public FileMonitor (File folder){
    this.folder = folder;
    supExt = new ArrayList<String>();
    supExt.add("txt");
}

public void run(){
    System.out.println("Starting to monitor");
    System.out.println("-------------------");
    currFiles = new Hashtable<String,Long>();

    for(;;) {
    
        File[] allFiles = folder.listFiles();

        

        //newFile was added probably, the size will not work, but this can be enhanced.
        if(numFiles != allFiles.length || size != folder.getTotalSpace())
        {
            if(numFiles < allFiles.length) {
                for (File file : allFiles) {
                    String nameFile = file.getName();
                    ArrayList<String> words;
                    FileStatistics fileEstadistics = new FileStatistics();
                    if(!currFiles.containsKey(nameFile))
                    {
                        currFiles.put(nameFile,file.getTotalSpace());                        
                        //logic to check if supported extension
                        int indExt = nameFile.lastIndexOf('.');
                        String fileExt = nameFile.substring(indExt+1);
                        if(supExt.contains(fileExt))
                        {
                            System.out.println("File Name: " + nameFile);
                            //call to the correct parser                            
                            //process txt files.
                            if(fileExt.equalsIgnoreCase("txt")){
                                TxtFile txtf = new TxtFile(file);
                                if(txtf.openFile()){
                                    words = txtf.parse();
                                    fileEstadistics.setParsingElements(words);
                                    fileEstadistics.processElements();

                                }
                            }

                            //move the file to 'proccssed directory'
                            //check if exists
                            File processedFolder = new File(folder.getAbsolutePath()+"\\processed\\");
                            if(!processedFolder.exists()){
                                //create the folder and move the file                                
                                processedFolder.mkdirs();
                            } 
                                
                            String newPath = processedFolder.getAbsolutePath()+"\\"+file.getName();
                            
                            file.renameTo(new File(newPath));
                            System.out.println("-------------------");
                            
                        }
                        
                        
                    }else if(currFiles.get(nameFile) != file.getTotalSpace() ) {
                        //changed the size
                    } 

                }
            }

        }       

    }
   	
 }

    
}
