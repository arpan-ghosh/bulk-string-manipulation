import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class insertTags {

	private static FileWriter writer;

	public static String insert() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("tags.csv"));
		writer = new FileWriter("insertTags.txt");
		
		String line = br.readLine();
		int length = 0;
		
		// writer.append(line + "\n");
		
		while (line != null) {
			writer.append("insert into Tags values (" + line + ");" + "\n");
			line = br.readLine();
			
		}
		writer.close();
		return null;	
	}
	
	public static void main(String[] args) throws IOException {
		insert();
	}
}