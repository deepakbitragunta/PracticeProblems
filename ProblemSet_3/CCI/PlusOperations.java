public class PlusOperations {
	public static int negate(int b) {
		int d = (b > 0) ? -1 :  1;
		int a = 0;
		
		while(b != 0) {
			a += d;
			b += d;
		}
		return a;
	}
	
	public static int subtract(int a, int b) {
		return a + negate(b);
	}	
	
	public static boolean isDifferentSigns(int a, int b) {
		return (a > 0 && b > 0) || (a < 0 && b < 0);
	}
	public static int abs(int a) {
		if(a < 0) {
			return negate(a);
		} else {
			return a;
		}
	}
	public static int multiplication(int a, int b) {
		if(a < b) return multiplication(b, a);
		
		int sum = 0;
		
		for(int i = abs(b); i > 0; --i) {
			sum += a;
		}
		if(b < 0) {
			sum = negate(sum);
		}
		return sum;
	}
	public static int divide(int a, int b) throws ArithmeticException{
		int quotient = 0;
		if(b == 0) throw new ArithmeticException("Division by zero");
		
		int divisor = negate(abs(b));
		
		for(int dividend = abs(a); dividend >= abs(divisor); dividend += divisor) {
			quotient++;
		}
		if(isDifferentSigns(a, b)) quotient = negate(quotient);
		
		return quotient;
	}
	
	public static void main(String args[]) {
		int a = -14, b = -8;
		System.out.println(subtract(a, b));
		System.out.println(multiplication(a, b));
		b = 10;
		System.out.println(divide(a, b));
		
	}
}