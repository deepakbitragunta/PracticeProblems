public class PhoneNumbers {
	
	static int n = 0;
	static String numbers = "0123456789"; 
	static int count = 0;
	public static void printValidNumbers (String prefix) {
		if(prefix.length() == n) {
			System.out.println(prefix);
			count++;
			return;		
		}
		
		for(int i = 0; i <  numbers.length(); ++i) {
			if(prefix.length() > 0) {
				if(prefix.charAt(prefix.length() - 1)  == numbers.charAt(i)) {
					continue;
				}
				if(numbers.charAt(i) == '4' && prefix.charAt(0) != '4') 
					continue;	
			}
			
			printValidNumbers(prefix + numbers.charAt(i));
		}
	}
	
	public static void refineNumbers(String prefix, String invalid) {
	
		for(int i = 0; i < invalid.length(); ++i) {
			numbers = numbers.replaceAll(invalid.charAt(i) + "", "");
		}
		printValidNumbers(prefix);
	}
	
	public static void main(String args[]) {	
		String invalid = "279";
		n = 4;
		refineNumbers("", invalid);
		System.out.println("count: " + count);
	}

}