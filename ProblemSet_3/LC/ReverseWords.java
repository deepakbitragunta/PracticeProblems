public class ReverseWords {

	public static void reverse(char c[]) {
		for(int i = 0, j = 0;j <= c.length; ++j) {
			if(j == c.length || c[j] == ' ') {
				reverse(c, i, j);
				i = j + 1;
			}
		}
	}
	
	public static void reverse(char c[], int b, int e) {
		for(int i = b; i < (e - b) / 2; ++i) {
			char temp = c[b + i];
			c[b + i] = c[e - i - 1];
			c[e - i - 1] = temp;
		}
	}
	
	public static void main(String args[]) {
		String s = "this is deepak";
		char c[] = s.toCharArray();
		reverse(c);
		System.out.println(new String(c));
	}
}