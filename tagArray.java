import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class tagArray {
	private static FileWriter writer;

    static List<String> unorderedTags = new ArrayList<String>();
    static List<String> tags = new ArrayList<String>();


	
	public static List<String> readUnorderedTags() throws Exception {
	      
	      BufferedReader reader = new BufferedReader(new FileReader("tagFromtags.txt"));
	      String line = reader.readLine();
	      while (line != null) {
	    	  unorderedTags.add(line);
	          line = reader.readLine();
	      }
	      return unorderedTags;
	  }
	
	public static List<String> readOrderedTags() throws Exception {
	      
	      BufferedReader reader = new BufferedReader(new FileReader("tagsOrdered.txt"));
	      String line = reader.readLine();
	      while (line != null) {
	    	  tags.add(line);
	          line = reader.readLine();
	      }
	      return tags;
	  }
	
	public static void main(String args[]) throws Exception {		
		readUnorderedTags();
		System.out.print(unorderedTags.get(0));
		readOrderedTags();
		System.out.print(tags.get(0));
		writer = new FileWriter("tagNumbers.txt");
		int length = tags.size();
		System.out.println(length);

//		for (int i = 0; i < tags.size(); i++) {
//			writer.append(i + "\n");
//		}
		
		for (int i = 0; i < unorderedTags.size(); i++) {
			writer.append(String.valueOf(tags.indexOf(unorderedTags.get(i)) + "\n"));
		}
		
		writer.close();

	}
}
