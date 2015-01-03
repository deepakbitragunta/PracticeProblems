public class LookandSay {

	/*public static String printSequence(String number) {
		int count = 1;
		
		if(number.length() == 1) {
			number = count + number;
		}
		
		char number_chars[] = number.toCharArray();
		int length = number_chars.length;
		int i = 0;
		
		StringBuilder result = new StringBuilder();
	
		for(; i < length - 1; ++i) {
			if(number_chars[i] != number_chars[i + 1]) {
				result.append(count + "" + number_chars[i] );
				count = 1;
				
			}
			else {
				count++;
			}
		}
		if(i == length) {
			result.append(count + "" + number_chars[i - 1]);
		}
		return result.toString();
	}	*/
	public static String printSequence(String number){
		StringBuilder result= new StringBuilder();
	 
		char repeat= number.charAt(0);
		number= number.substring(1) + " ";
		int times= 1;
	 
		for(char actual: number.toCharArray()){
			if(actual != repeat){
				result.append(times + "" + repeat);
				times= 1;
				repeat= actual;
			}else{
				times+= 1;
			}
		}
		return result.toString();
	}
	
	public static void lookandSay(String num, int n) {
	if(num.length() == 0) {
		System.out.println("Invalid input");
		return;
	}	
	for(int i = 0; i < n; ++i) {
		num = printSequence(num);
		System.out.println(num);
	}
		
	}
		
	public static void main(String args[]) {
		String num = "1";
		int n = 10;
		lookandSay(num, n);
	}
}