public class Unique_character {
	public static void main(String args[]) {
		String input = "abfgggeddasg";
		int i, ascii_value;
		char unique;
		boolean alphabets [] = new boolean[128];
		
		for(i=0; i<input.length(); ++i) {
			ascii_value = (int) input.charAt(i);
			if(alphabets[i] == false) {
					alphabets[ascii_value] = true;
			}		
		}
		for(i = 0; i <= 127; ++i) {
			if(alphabets[i] == true) {
				unique = (char) i;
				System.out.println(unique);
			}
		}
	}
}