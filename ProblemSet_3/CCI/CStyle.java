public class CStyle {

	public static void swap(char[] input, int i, int j) {
		char temp;
		temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	public static String reverseinCStyle(String input) {
		char input_chars[] = input.toCharArray();
		int n = input_chars.length;
		
		for(int i = 0, j = n - 1; i < j; ++i, --j) {
			if(input_chars[i] != input_chars[j]) {
				swap(input_chars, i, j);
			}
		}
		return "\0" + new String(input_chars);
	}
	public static void main(String args[]) {
		String s = "azkpla", s1 = "", s2 = "aaa", s3 = "abcdexbs";
		System.out.println(reverseinCStyle(s));
		System.out.println(reverseinCStyle(s1));
		System.out.println(reverseinCStyle(s2));
		System.out.println(reverseinCStyle(s3));
		
	}

}