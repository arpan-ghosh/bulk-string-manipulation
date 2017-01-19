//Bulk string manipulation 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParseFile {

	private static FileWriter writer;

	public static String change() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("title.txt"));
		writer = new FileWriter("output.txt");
		
		String line = br.readLine();
		int length = 0;
				
		while (line != null) {
			if (line.contains("The")) {
				line = line.replace("The", "");
				line = "The " + line;
				writer.append(line + "\n");
			}
			else {
			writer.append(line + "\n");
			}
			line = br.readLine();
			
		}
		writer.close();
		return null;	
	}
	
	public static void main(String[] args) throws IOException {
		change();
	}
}
