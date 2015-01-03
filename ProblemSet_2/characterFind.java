package programs;

class charCount {
	int count;
	int index;
}

public class characterFind {

	public static void firstDistinct(String s) {	
		int i = 0;
		charCount chars[] = new charCount[256];
		
		for(i = 0; i < s.length(); ++i) {
			int ascii = s.charAt(i);
			chars[ascii]  = new charCount();
			chars[ascii].count = chars[ascii].count++;
			if(chars[s.charAt(i)].count == 1) {
				chars[s.charAt(i)].index = i;
			}	
		}
		
		int first_index = Integer.MAX_VALUE;
		
		for(i = 0; i < chars.length; ++i) {
			if(chars[i] != null && chars[i].count == 1 && first_index > chars[i].index) {
				first_index = chars[i].index;
			}
		}	
		if(first_index != Integer.MAX_VALUE) {
			System.out.println("First non repeating: " + s.charAt(first_index));
		}
	}
	
	public static void firstDuplicate(String s) {
		boolean characters[] = new boolean[256];
		
		for(int i = 0; i < s.length(); ++i) {
			if(characters[s.charAt(i)] != false) {
				System.out.println("First Duplicate: " + s.charAt(i));
				break;
			}
			characters[s.charAt(i)] = true; 
		}
	}
	
	public static void main(String args[]) {
	
		String input = "aaaabcbbccc";
		String input2 = "anvbhcksrc";
		firstDistinct(input);
		firstDuplicate(input2);
	}

}