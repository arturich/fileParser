package statistics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class FileStatistics implements Statistics {

    ArrayList<String> elements;
    Hashtable <String,Long> occur = new Hashtable<String,Long>();

    public void setParsingElements(ArrayList<String> elements){

        this.elements = elements;

    }

    public void processElements(){

        System.out.println("Number of words:" + elements.size());

        //Number of dots

        long dots = 0;

        for (String word : elements) {
            dots += word.chars().filter(ch -> ch == '.').count();   

            if(occur.containsKey(word)){
                long val = occur.get(word);
                occur.put(word, ++val);
            }else{
                occur.put(word,1L);
            }
        }

        System.out.println("Number of dots:" + dots);
        

        //most used word
        long max = 0; 
        String maxWord = "";
        Set<String> keys = occur.keySet();
        for (String word : keys) {
            if(max < occur.get(word)){
                max = occur.get(word);
                maxWord = word;
            }   
        }
        System.out.println("Most used word :'" + maxWord + "' with: " + max + " occurencies");

    }

    
}
