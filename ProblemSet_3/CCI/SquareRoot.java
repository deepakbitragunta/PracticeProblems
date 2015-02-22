public class SquareRoot {
	static int error = 1;
	// sqrt(35) will be 5
	
	public static int findSqrt(int num) {
		int low = 0;
		int high = num;
		
		while(high - low > error) {
			int mid = low + (high - low) / 2;
			if(mid * mid > num) {
				high = mid;
			} else {
				low = mid;
			}
		}	
		
		return low;
	}
	public static void main(String args[]) {
	 System.out.println(findSqrt(35));
	 System.out.println(findSqrt(25));
	 System.out.println(findSqrt(15));
	}
}