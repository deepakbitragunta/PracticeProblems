public class noTempSwap {
	
	public static void swap(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}
	
	public static void main(String args[]) {
		int a = 4;
		int b = 6;
		// Doesn't work in java
		swap(a, b);
		
		System.out.println(a);
		System.out.println(b);
	}
}