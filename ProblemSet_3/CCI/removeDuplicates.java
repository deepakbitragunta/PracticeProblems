
public class removeDuplicates {

	// http://www.joelonsoftware.com/articles/Unicode.html
	// 65536
	public static String deleteDuplicates(String input) {

		boolean characters [] = new boolean[256];
		
		if(input == null) return input;
		
		int n = input.length();
		
		if(n < 2) return input;
		
		StringBuilder unique = new StringBuilder();
	
		for(int i = 0; i < n; ++i) {
			if(characters[input.charAt(i)]) {
				continue; 
			}		
			characters[input.charAt(i)] = true;
			unique.append(input.charAt(i));
		}	
		return unique.toString();
	}
	public static void main(String args[]) {		
		String s = "azkpla", s1 = "", s2 = "aaa", s3 = null, s4 = "abcde", s5 = "aaabbccd";
		System.out.println(deleteDuplicates(s));
		System.out.println(deleteDuplicates(s1));
		System.out.println(deleteDuplicates(s2));
		System.out.println(deleteDuplicates(s3));
		System.out.println(deleteDuplicates(s4));
		System.out.println(deleteDuplicates(s5));
	}

}