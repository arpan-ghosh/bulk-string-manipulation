import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/** To decode a BWT back to its original. */
public final class BWTDecoder {

    private BWTDecoder() { }
    
    /** Checks if ASCII

    @param input the string to be ASCII'd
    @return valid if valid, the string
    @throws IOException 
    */
    private static boolean isASCII(String input) {
        boolean valid = true;
        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if (c < 0x24) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    /** BWT Decode
        @param bwt input
        @return original 
        @throws IOException if invalid BWT input
    */
    public static String decodeBWT(String bwt) throws IOException {
    	
    	
    	
    	if (!isASCII(bwt)) {
    		throw new IOException();
    	}

        char[] bwtarr = bwt.toCharArray();
        Arrays.sort(bwtarr);
        String firstCol = new String(bwtarr);

        StringBuilder text = new StringBuilder();

        int[] rankCharsBWT = new int[256]; // current rank of character
        int[] rankCharsFirstCol = new int[256];
        int[] bwtRank = new int[bwt.length()];

        // (Character in bwt, rank of character in bwt) -> index
        // (Character, Integer) -> Integer
        // rank is the index into the ArrayList
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < bwt.length(); i++) {
            bwtRank[i] = rankCharsBWT[bwt.charAt(i)]++;

            if (!map.containsKey(firstCol.charAt(i))) {
                map.put(firstCol.charAt(i), new ArrayList<Integer>());
            }

            map.get(firstCol.charAt(i)).add(i);
        }

        int row = 0;
        while (bwt.charAt(row) != '$') {
            text.append(bwt.charAt(row));
            row = map.get(bwt.charAt(row)).get(bwtRank[row]);
        }

        return text.reverse().toString();
    }

    /** Input data read
        @return lines removed, return new string
        @throws IOException if error in reading
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

    /** BWT string to proper input.
        @param args not used
    */
    public static void main(String[] args) {
        String bwt = "";

        try {
            bwt = readInput();
        } catch (IOException e) {
            System.err.println("Cant read input");
            System.exit(1);
        }

        try {
            System.out.println(BWTDecoder.decodeBWT(bwt));
        } catch (IOException e) {
            System.err.println("Invalid input");
            System.exit(1);
        }
    }
}
