import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class wordFrequency {
	
	public static HashMap<String, Integer> readFile(HashMap<String, Integer> wordMap, String filenames[]) {
		int i, j;
		String line = "", newline = "";
		int frequency;
		String threeWords = "";
		try{
			FileWriter writer = new FileWriter("C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\output.csv");
		   
		    writer.append("\n");
			for(i = 0; i < filenames.length; ++i) {		
				BufferedReader reader = new BufferedReader(new FileReader(filenames[i]));
				while ((line = reader.readLine()) != null) {
					
						line = line.trim();
						line = line.toLowerCase();
					//	writer.append("old line: " + line+"\n");
						System.out.println("old line: " + line+"\n");
						
					//	line = line.replaceAll("(.*)\\<(.*)\\>(.*)", "");
					//	line = line.replaceAll("[^a-zA-Z\\s']", "");
					//	line = line.replaceAll("[^a-zA-Z\\s]", "");
						line = line.replace("?", "");
						line = line.replace("!", "");
						line = line.replace(",", "");
						line = line.replace(".", "");
						line = line.replace(":", "");
						line = line.replace(";", "");
						line = line.replace("-", "");
						line = line.replace("'", ""); 
						
						System.out.println("new line: " + line+"\n");
						
						String words[] = line.split("\\s");
						
						for(j = 0; j < words.length - 2; ++j) {
							threeWords = (words[j] + " " +  words[j+1] + " " + words[j + 2]).trim();
							
							if(wordMap.get(threeWords) == null) { 
								frequency = 1;
							}
							else {
								frequency = wordMap.get(threeWords);
								frequency++;
							}
							wordMap.put(threeWords, frequency);	
						}	
							
				}
				reader.close();
				
			}
			writer.close();
		}	
		catch(Exception e) {
			System.out.println(e);
		}

	    
	 return wordMap;
	}
	
	public static void outputToCSV(List<Map.Entry<String, Integer>> sorted_map) {
		int top_50_words  = 50;
		int count = 0;
		try
		{
		    FileWriter writer = new FileWriter("C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\output.csv");
		    
		    writer.append("Trigram");
		    writer.append(",");
		    writer.append("Frequency");
		    writer.append("\n");
		    @SuppressWarnings("unchecked")
			Iterator<Map.Entry<String,Integer>> iterator = sorted_map.iterator();
			 
			while (iterator.hasNext() && count < 50) {
				Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) iterator.next();
				writer.append(pair.getKey() + ",");				
				writer.append(pair.getValue() + ",");
				writer.append("\n");
				count++;
			 }
			System.out.println("The output.csv file is generated");
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
	    
	}
	
	public static void main (String args[]) {
		int num_of_files;
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		 //  open up standard input
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  //  String [] filenames = {};
	 
	      
		System.out.println("Enter the number of input files: ");
		
	/*	 try {
	         num_of_files = Integer.parseInt(br.readLine());
	      
	        filenames = new String[num_of_files];
			System.out.println(num_of_files);
			System.out.println("Please enter the path of the input files below: ");
			for(int i = 0; i < num_of_files; ++i) {
				System.out.println("Absolute path to " + (i + 1) + " file: ");
				filenames[i] = br.readLine();	
			}
		} catch (IOException e) {
	         System.out.println(e);
	         System.exit(1);
	      } */
		
		String filenames[] = {"C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Anthony and Cleopatra.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\As You Like It.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Hamlet, Prince of Denmark.txt", 
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Julius Caesar.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\King Lear.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Love's Labour's Lost.txt", 
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Measure for Measure.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Othello, the Moor of Venice.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Romeo And Juliet.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\The Comedy of Errors.txt", 
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\The Famous History of the Life of King Henry VIII.txt", 
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\The Taming of the Shrew.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\The Two Gentlemen of Verona.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Timon of Athens.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Titus Andronicus.txt",
							  "C:\\Users\\DeepakBitragunta\\SkyDrive\\Documents\\Resume\\Programs\\CCI\\files\\Twelfth-Night_ or What You Will.txt"};
		
		wordMap = readFile(wordMap, filenames);
		
		List<Map.Entry<String, Integer>> sorted_map =  sortByValues(wordMap);
		
		outputToCSV(sorted_map);
	}
	
	/*
     * Java method to sort Map in Java by value e.g. HashMap or Hashtable
     * throw NullPointerException if Map contains null values
     * It also sort values even if they are duplicates
     */
    public static <String extends Comparable,Integer extends Comparable> List sortByValues(HashMap<String,Integer> map){
        List<Map.Entry<String,Integer>> entries = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
      
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
		return entries;
    }  
}

	


