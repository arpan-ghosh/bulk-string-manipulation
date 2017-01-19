import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Encodes a string to RLE
**/
public final class RLEEncoder {

    private RLEEncoder() { }
    
    /** RLE

        @param input string input
        @return rle of the input string
        @throws IOException if string corrupt/not RLE possible
    */
    public static String runLengthEncode(String input) throws IOException {
        StringBuilder out = new StringBuilder();
             
        for (int i = 0; i < input.length(); i++) {
        	if (Character.isDigit(input.charAt(i))) {
        		throw new IOException();
        	}
        	i++;
        }
               
        for (int i = 0; i < input.length(); i++) {
            int run = 1;
            while (i + 1 < input.length()
                && input.charAt(i) == input.charAt(i + 1)) {
            	run++;
                i++;
            }
            out.append(input.charAt(i));
            if (run > 1) {
                out.append(run);
            }
        }
        return out.toString();
    }

    /** STDIN read
        @return no lines return RLE
        @throws IOException if file corrupt
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

    /** main calls helpers for RLE process
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
            System.out.println(runLengthEncode(text));
        } catch (IOException e) {
            System.err.println("Invalid Input");
            System.exit(1);
        }
    }
}
