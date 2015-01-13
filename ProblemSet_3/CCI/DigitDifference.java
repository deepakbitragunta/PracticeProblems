public class DigitDifference {
	
	public static int difference(int a, int b) {
		int count = 0;
		for(int c = a ^ b; c != 0; c = c >> 1) 
			count += c & 1;
		return count;
	}
	
	public static void main(String args[]) {
		System.out.println("count: " + difference(1, 63));
	}
}