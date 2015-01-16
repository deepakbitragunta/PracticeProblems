public class Fibonacci {
	public static int fibRec(int n) {
		if(n == 0) return 0;
		else if ( n == 1) return 1;
		else if ( n > 1) return fibRec(n-1) + fibRec(n-2);
		else 
			return -1;
	}
	public static int fibIter(int n) {
		if(n == 0 || n == 1) return n;
		
		
		int a = 1, b = 1, c = 0;
		
		for(int i = 3; i <= n; ++i) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	
	public static void main(String args[]) {		
		System.out.println(fibRec(6));
		System.out.println(fibIter(5));		
	}
}