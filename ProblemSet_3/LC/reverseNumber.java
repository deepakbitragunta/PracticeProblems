public class reverseNumber {
    public static int reverse(int x) {
    	int reverse = 0;
        while(x != 0) {
            int digit =  x % 10;
            reverse = reverse * 10 + digit;
            if(reverse % 10 != digit) 
            	return 0;
            else {
                reverse =  (reverse * 10 +  x % 10); 
            }
           x = x / 10;    
        }        
       return reverse; 
    }
		public static void main(String args[]) {
			System.out.println(reverse(1534236469));
		}
}