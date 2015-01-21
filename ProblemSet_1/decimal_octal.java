import java.util.Scanner;

public class decimal_octal {

	public static String decimaltoOctal(int decimal) {
		int rem;
		String octal = "";
		
		while(decimal > 0) {
			octal += (decimal % 8);
			decimal /= 8;
		}
		return octal;
	}
	public static boolean isPalindrome(String number) {
		int i, j;
 
		for(i = 0, j = number.length() - 1; i < j; ++i, --j) {
				if(number.charAt(i) != number.charAt(j)) {
					return false;
				}
		}
		return true;
	}

	public static boolean checkBothPalindormes(int decimal_value) {
		String decimal = decimal_value + "";
		String octal;
		if(isPalindrome(decimal)) {
			octal	= decimaltoOctal(decimal_value);
			if(isPalindrome(octal)) {
				return true;
			}
		}
	return false;
	}

	public static void main(String args[]) {
		
	Scanner sc = new Scanner(System.in);

	int range = sc.nextInt();

	System.out.println("List of palindromes: ");

	for(int i = 0; i <= range; ++i) {
			if(checkBothPalindormes(i)) {
				System.out.println(i);
			}
	}
  }
}