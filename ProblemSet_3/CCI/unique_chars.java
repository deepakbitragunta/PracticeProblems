public class unique_chars {
	//All ASCII characters
	public static boolean checkUnique(String input) {
		int n = input.length();
		boolean characters[] = new boolean[256];
		
		for(int i = 0; i < n; ++i) {
				if(characters[input.charAt(i)]) {
					return false;
				}
				characters[input.charAt(i)] = true;
		}
		return true;
	}
	
	
	// Assume 'a' to 'z' range
	public static boolean checkUnique(String input, char start_char) {
		int n = input.length();
		int vector = 0;
		
		for(int i = 0; i < n; ++i) {
			int diff = input.charAt(i) - start_char;
			int value = ( 1 << diff);
			if((vector & value) >  0) {
				return false;
			}
			vector |= value;
		}
		return true;
	}
	public static void main(String args[]) {
		String s = "azkpla", s1 = "", s2 = "aaa", s3 = "abcabc";
		System.out.println(checkUnique(s, 'a'));
		System.out.println(checkUnique(s1, 'a'));
		System.out.println(checkUnique(s2, 'a'));
		System.out.println(checkUnique(s3, 'a'));
		System.out.println(checkUnique(s));
		System.out.println(checkUnique(s1));
		System.out.println(checkUnique(s2));
		System.out.println(checkUnique(s3));
	}

}