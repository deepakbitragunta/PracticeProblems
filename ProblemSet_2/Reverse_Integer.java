package programs;
public class Reverse_Integer {

	public static int reverseInt(int num) {
		int rem, reverse_num = 0;
		
		while(num > 0) {
			
			rem = num % 10;
			num = num / 10;
			reverse_num = reverse_num * 10 + rem;
		}
		return reverse_num;
	}
	
	
	public static void main(String args[]) {
		System.out.println(reverseInt(8706));	
	}
}