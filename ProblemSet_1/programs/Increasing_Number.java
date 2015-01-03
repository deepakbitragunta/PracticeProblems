public class Increasing_Number {
	public static boolean checkNumber(int number) {
		String num = number + "";
		int l, j, length;
		int n = num.length();
		int first, second, rest;
		
		length = n / 2;
		
		for(l = 1; l <= length; ++l) {
			for(j = 0; j <= n - 3 * l; ++j) {
				first = Integer.parseInt(num.substring(j, j+l));
				second = Integer.parseInt(num.substring(j + l, j + l * 2));
				for(int i = j + 2*l + 1; i <= n ; ++i) {
					rest =  Integer.parseInt(num.substring(j + 2* l, i));
					if((first + second) == rest) {
						if(i == n) { 
							return true;
						}
					}				
				}
				
				
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		int start = 1235813;
		int end = 1235813;
		boolean  result = false;
		for(int i = start; i <= end; ++i ) {
			result = checkNumber(i);
			System.out.println(i + " : " + result);
		//	i = i * 10 - 18;
		}	
	}

}