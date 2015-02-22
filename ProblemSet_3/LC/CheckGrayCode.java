public class CheckGrayCode {
	public static boolean checkNum(int a, int b) {
		int count = 0;
		while(a > 0 || b > 0) {
			if((a & 1) != (b & 1)) {
				count++;
				if(count > 1) {
					return false;
				}
			}
			a >>= 1;
			b >>= 1;
		}
		return count == 1;
	}
	//f6da5e30
	
	//23280014150490
	
	/*public static boolean checkNum2(int a, int b) {
		return (b == (a ^ 1)) || (b == ((a & -a) << 1));		
	}*/
	public static boolean checkNum3(int a, int b) { 
		int x = a ^ b;
		
		return (x > 0) && ((x & -x) == x);
	}
	public static boolean checkNum(String a, String b) {
		int count = 0, i = 0, n = a.length();
		if(a.length() != b.length()) return false;
		while(i < n) {
			if(a.charAt(i) != b.charAt(i)) {
				count++;
				if(count > 1) {
					return false;
				}
			}
			i++;
		}
		return (count == 1);
	//	return (b == (a ^ 1)) || (b == ((a & -a) << 1));		
	}
	public static void main(String args[]) {
		int a = -2, b = -4;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(checkNum(a, b));
	//	System.out.println(checkNum2(a, b));
		System.out.println(checkNum3(a, b));
		System.out.println(checkNum(Integer.toBinaryString(a), Integer.toBinaryString(b)));
	}
}