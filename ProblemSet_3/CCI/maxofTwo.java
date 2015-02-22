public class maxofTwo {
	
	public static int largest(int a, int b) {
		int c = a - b;
		int k = (c >> 31) & 1;
		return (a - k * c);
	}
	
	public static void main(String args[]) {
		System.out.println(largest(-10, 10));
	}
}