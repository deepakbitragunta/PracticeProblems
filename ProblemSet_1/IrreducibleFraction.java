public class IrreducibleFraction {
	public static int gcdOfTwo(int a, int b) {
		if( a == 0) return b;
		if(b == 0) return a;
		
		while(a != b) {
			if( a > b ) {
				a = a - b;
			}
			else  {
				b = b - a;
			}
		}
		
		return a;
	}
	
	public static void irreducibleFraction(double num) {
		int divisor = 10000;
		int dividend = (int) (num * divisor);
		
		int gcd = gcdOfTwo(dividend, divisor);	
		System.out.println("Fraction: " + dividend / gcd + " / " + divisor / gcd );
	
	}
	
	public static void main(String args[]) {
		irreducibleFraction(0.4566);
	}

}