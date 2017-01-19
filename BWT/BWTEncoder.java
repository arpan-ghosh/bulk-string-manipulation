import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;


/**
 * Encodes the bwt of a string
**/
public class BWTEncoder {

    static class CompareSuffixes {
        // Compare two suffixes of text starting at s1 and s2
        // Return -1 if s1 is smaller, +1 if s2 is smaller, 0 same
        public static int cmpSuffixes(String text, int s1, int s2) {
            if (s1 == s2) {
                return 0;
            }
            int d = 0;
            while ((s1 + d < text.length()) && (s2 + d < text.length())) {
                char c1 = text.charAt(s1 + d);
                char c2 = text.charAt(s2 + d);
                if (c1 < c2) {
                    return -1;
                } else if (c2 < c1) {
                    return +1;
                }
                // else they are the same, keep going
                d++;
            }
            // no differences through end of string
            // return shorter one, meaning having a bigger offset
            if (s1 < s2) {
                return +1;
            }
            return -1;
        }
    }

    // You may want to use this ;-)
    private final class CyclicPermutation
        implements Comparable<CyclicPermutation> {

        int offset;

        CyclicPermutation(int offset) {
            this.offset = offset;
        }

        @Override
        public int compareTo(CyclicPermutation o) {
            return CompareSuffixes.cmpSuffixes(text, offset, o.offset);
        }
    }

    String text;

    /** Silence checkstyle. */
    public BWTEncoder() { }
    
    /** Checks if ASCII

    @param input The input String
    @return The string if valid
    @throws IOException if not valid
    */
    private static boolean isASCII(String input) {
        boolean valid = true;
        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if (c <= 0x24) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    /** BWT encode of a string

        @param input The input String
        @return The BWT of the input string
        @throws IOException On invalid input
    */
    public String createBWT(String input) throws IOException {
    	
    	if (!isASCII(input)) {
    		throw new IOException();
    	}
    	
        this.text = input + "$";

        StringBuilder bwt = new StringBuilder();

        this.text = input + "$";

        CyclicPermutation[] arr = new CyclicPermutation[text.length()];
        String permutation = this.text;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new CyclicPermutation(i);
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            bwt.append(this.text.charAt((arr[i].offset + arr.length - 1)
                % arr.length));
        }

        return bwt.toString();
    }

    /** Reads from STDIN.
        @return Returns data no new lines
        @throws IOException error with file 
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

    /** Computation of BWT in main function calling helpers
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

        BWTEncoder bwt = new BWTEncoder();
        try {
            System.out.println(bwt.createBWT(text));
        } catch (IOException e) {
            System.err.println("Invalid Input");
            System.exit(1);
        }
    }
}
