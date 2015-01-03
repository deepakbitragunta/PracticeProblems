public class StringReverse {

	public static String reverse(String input) {
		String words[] = input.split("\\s+");
		int i = 0, j = 0;
		String reverse_words = "";
		String output = "";
		for(i = 0; i < words.length; ++i) {
			j = words[i].length() - 1;
			while( j >= 0) {
				reverse_words += words[i].charAt(j);
				--j;
			}
			reverse_words += " ";
		}
		for(i = reverse_words.length() - 1; i >= 0; --i) {
			output += reverse_words.charAt(i);
		}
		return output;
	}
	public static void main(String args[]) {
		String input = "This is great";
		System.out.println(reverse(input));
	}
}