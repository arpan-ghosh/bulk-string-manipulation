import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The RLE of a string.
**/
public final class RLEDecoder {

    private RLEDecoder() { }

    /** RLE an input string

        @param input string to be RLE'd
        @return RLE
        @throws IOException if file not proper
    */
    public static String runLengthDecode(String input) throws IOException {
        StringBuilder out = new StringBuilder();
                        
        for (int i = 0; i < input.length()-1; i++) {
        	if (input.charAt(i) == input.charAt(i+1)) {
        		System.out.print("yes");
        	}
        	else {
    		    i++;
        	}
        }
                    
        
        int i = 0;
        while (i < input.length()) {
            char symbol = input.charAt(i);
            int j;
            for (j = i + 1; j < input.length()
                && Character.isDigit(input.charAt(j)); j++);
            String str = input.substring(i + 1, j);
            int numSymbols = str.isEmpty() ? 1 : Integer.parseInt(str);
            for (int k = 0; k < numSymbols; k++) {
                out.append(symbol);
            }
            i = j;
        }
        return out.toString();
    }

    /** Stdin read
        @return no new lines
        @throws IOException file corrupt
    */
    public static String readInput() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        input.close();

        return sb.toString();
    }

    /** Main method calling proper helpers for RLE Decode
        @param args not used
    */
    public static void main(String[] args) {
        String text = "";

        try {
            text = readInput();
        } catch (IOException e) {
            System.err.println("Cant read input");
            System.exit(1);
        }

        try {
            System.out.println(runLengthDecode(text));
        } catch (IOException e) {
            System.err.println("Invalid Input");
            System.exit(1);
        }
    }
}
