public class bitSubstring {
	
	public static int bitMasking(int m, int n, int i, int j) {
		int allOne = ~0;
		
		// all 1's till j and then all zeros
		int left = allOne - (( 1 << j) - 1);
		
		// all 1's till i
		int right = (1 << i) - 1;
		
		// zeros from i to j and all ones
		int mask = left - right;
		
		return (n & mask) | ( m << i);
	}

	public static void main(String args[]) {
		int n = 32;
		int m = 10;
		System.out.println(bitMasking(m, n, 3, 6));
	
	}
}