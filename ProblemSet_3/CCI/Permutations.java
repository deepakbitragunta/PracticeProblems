import java.util.ArrayList;

public class Permutations {

	public static ArrayList<String> permute(String s) {
	
		ArrayList<String> all_strings = new ArrayList<String>();
		
		if(s == null) {
			return null;
		}
		else if(s.length() == 0) {
			all_strings.add("");
			return all_strings;
		}
		
		char first = s.charAt(0); // first character
		String rem = s.substring(1);
		ArrayList<String> words = permute(rem);
		for(String word : words) {
			for(int j = 0; j <= word.length(); ++j) {
				all_strings.add(insertCharAt(word, first, j));
			}
		}
		
		return all_strings;
		
	}
	
	public static String insertCharAt(String word, char c, int j) {
		String start = word.substring(0, j);
		String end = word.substring(j);
		return start + c + end;
	}
	public static void main(String args[]) {
		ArrayList<String> s = permute("abc");
		System.out.println(s.toString());
	}

}