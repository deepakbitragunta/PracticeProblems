package programs;

public class MaxRepeating {
	
	public static void printMax(String str) {
		int length = str.length();
		int i = 0;
		int max = 0;
		
		if(str == null) {
			System.out.println("Invalid string");
			return;
		}
		
		if( str.length() == 0) {
			System.out.println("empty string");
			return;
		}
		char max_char, next_char = max_char = str.charAt(0);
		
		
		int count  = 0;
		for(i = 0; i < length; ++i) {
			if(i == length - 1 || str.charAt(i) == str.charAt(i+1)) {	
				count++;
				if(count > max) {
					max = count;
					max_char = str.charAt(i);
				}
			}
			else{
				//next_char = str.charAt(i);
				count = 1;
			}		
		}
		System.out.println("String: " + max_char + " count: " + max);
	}
	

	public static void main(String args[]) {
		printMax("abcddddeb");
	}
}