class charCount {
	int count;
	int index;
}

public class characterFind {

	public static void firstDistinct(String s) {	
		int i = 0;
		charCount chars = new charCount[256];
		
		for(i = 0; i < characters.length; ++i) {
			chars[s.charAt(i)].count++;
			if(chars[s.charAt(i)].count == 1) {
				chars[s.charAt(i) = index;
			}	
		}
		
		for(i = 0; i < chars.length; ++i) {
			if(chars[i].count == 1) {
				System.out.println(s.charAt(chars[i].index));
			}
		}	
	}
	
	public static void firstDuplicate(String s) {
		boolean characters[] = new boolean[256];
		
		for(int i = 0; i < s.length(); ++i) {
			if(characters[s.charAt(i)] != false) {
				System.out.println(s.charA	t(i));
			}
		}
	}
	
	public static void main(String args[]) {
	
		String input = "aaaabcbbccc";
		String input2 = "anvbhcksrc";
		firstDistinct(input);
		firstDuplicate(input2);
	}

}