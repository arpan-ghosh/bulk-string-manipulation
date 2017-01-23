/**
 * This program removes adjacent duplicate characters from a user
 * inputted string and returns the string collapsed.
 */
import java.util.Scanner;

public class CollapseAdjacent {
    
    /**
     * Main method to collect user input for collapse of adjacent repeat characters.
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a line, and I'll collapse the adjacent "
                + "repeated characters in it: ");
        
        String entry = keyboard.nextLine();
        collapse(entry);
        System.out.println("Without repeats: " + "\n" + collapse(entry));
        
    }
    
    /**
     * Recursively remove the adjacent duplicate characters in a String.
     * @param original the String from which duplicates will be removed
     * @return collapsed word with adjacent duplicates removed
     */
    public static String collapse(String original) {
        if (original.length() <= 1) {
            return original;
        }    
        
        if (original.substring(1,2).equals(original.substring(0,1))) {
            return collapse(original.substring(1));
        } else { 
            return original.substring(0,1) + collapse(original.substring(1));
        }
    }

}