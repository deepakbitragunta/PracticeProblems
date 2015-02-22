public class LCMGCD {
	
	public static int lcm(int a, int b) {
		int lcm  = 0;
		int max = (a > b) ? a : b;
		int min = (a < b) ? a : b;
		
		for(int i = 1; i <= min; ++i) {
			lcm = max * i;
			if(lcm % min == 0) {
				break;
			}
		}	
		return lcm;
	}
	public static int gcd(int a, int b) {
		while(b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	public static int lcmGcd(int a, int b) {
		return (a * (b / gcd(a, b)));
	}
	
	public static void main(String args[]) {
		System.out.println(lcm(20, 12));
		System.out.println(lcmGcd(20, 12));
		System.out.println(gcd(3, 40));	
	}
	
}