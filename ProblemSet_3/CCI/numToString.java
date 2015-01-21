public class numToString {
	
	public static String convertToString(int num) {
		
		StringBuilder sb = new StringBuilder();
		
		int len = 1;
		
		while(Math.pow((double) 10, (double) len) < num) {
			len++;
		}
		
		String word1 []= {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String word11 []= {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String word10 [] = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String word100 []= {"", "hundred", "thousand"};
		
		int temp;
		
		if(num == 0){
			sb.append("zero");
		}
		else {
			if(len > 3 && len % 2 == 0) {
				len++;
			}
			
			do {
				// number greater than 999
				if(len > 3) {
					temp = num / ( (int) (Math.pow((double) 10, (double) len-2)));
					
					if(temp / 10 == 1 && temp % 10 != 0){
						sb.append(word11[temp % 10]);
					} else {
						sb.append(word10[temp / 10]);
						sb.append(word1[temp % 10]);
					}
					
					if(temp > 0){
						sb.append(word100[len / 2]);
					}
					
					num = num % (int) (Math.pow((double) 10, (double) len - 2));
					len = len - 2;

				}
				else {
				// number less than 1000
					temp = num / 100;
					if(temp != 0){
						sb.append(word1[temp]);
						sb.append(word100[len / 2]); 
					}
					temp = num % 100;
					
					if(temp / 10 == 1 && temp % 10 != 0){
						sb.append(word11[temp % 10]);
					} else {
						sb.append(word10[temp / 10]);
						sb.append(word1[temp % 10]);
					}
					len = 0;
				}	
			} while(len > 0);
		}
		return sb.toString();		
	}
	public static void main(String args[]) {
		System.out.println(convertToString(14001));
		System.out.println(convertToString(111));
		System.out.println(convertToString(001));
	}
}