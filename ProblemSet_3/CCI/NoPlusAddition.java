public class NoPlusAddition {
	
	public static int add(int a, int b) {
		if(b == 0 ) return a;
	
		int sum_no_carry = a ^ b;
		int carry =  (a & b) << 1; // only carry
		return add(sum_no_carry, carry);
	}

	public static void main(String args[]) {
		System.out.println(add(8, 4));
		System.out.println(add(0, 8));
		System.out.println(add(31, 31));
	}
}