public class TrailingZeros {
    public static int trailingZeroes(int n) {
        int k = 5;
        int zeros = 0;
        while(n > 0) {
            zeros = zeros + n / 5;
            n = n / 5;
        }
       return zeros; 
    }
		
		public static void main(String args[]) {
			System.out.println(trailingZeroes(2147483647));
		}
}