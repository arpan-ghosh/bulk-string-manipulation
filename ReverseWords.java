/*
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 */
public class ReverseWords {
	
	static String beg;
	static String output;
	static int count = 0;
	
	public static String reverseWords(String s) {
		
		StringBuilder str = new StringBuilder();
		
		int end = s.length();
		
		for (int i = s.length() - 1; i > 0; i--) {
			if (s.charAt(i) == ' ') {
				str.append(s.substring(i, end));
				end = i;
			}	
		}
		
		beg = s.substring(0, end);
		str.append(" " + beg);
		str.deleteCharAt(0);
		output = str.toString();

		//remove trailing white space and truncate any
		//white space in between words to only one
				
		
		System.out.print(str);
		System.out.println(count);
		return output;
	}
	
	public static void main (String[] args) {
		reverseWords("the sky is  blue");
	}

}
