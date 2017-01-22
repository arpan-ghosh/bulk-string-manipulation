public class Acronym {
	
	static String output = "";
	
	public static String generate(String input) {
		
		output += input.charAt(0);
		
		for (int i = 1; i < input.length(); i++) {
			if (Character.isWhitespace(input.charAt(i))) {
				output = output + input.charAt(i);
				output += input.charAt(i+1);
			}
 		}
		
		/*for (int i = 1; i < input.length(); i++) {
			if (Character.isUpperCase(input.charAt(i))) {
				output += input.charAt(i);
			}
		}*/
		return output.replaceAll("\\s+","").toUpperCase();
	}
	
	public static void main(String[] args) {
		System.out.print(generate("Ruby on Rails")); 
	}
	
}