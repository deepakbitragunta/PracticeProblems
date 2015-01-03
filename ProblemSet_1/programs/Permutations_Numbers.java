public class Permutations_Numbers {
	static int n = 4;
	static int count = 0;
	public static void printNumbers(String prefix) {
		if(prefix.length() == n) {
			System.out.println(prefix);
			count++;
			return;
		}
		
		for(int i = 0; i <= 9; ++i) {
			/*if(prefix.length() == 0 && i == 0) {
				continue;
			}*/
			if(prefix.length() > 0) {
				if(Integer.parseInt(prefix.charAt(0) + "") == 4 && prefix.length() == n - 1 && i != 4)  continue; 
				
				if(i == Integer.parseInt(prefix.charAt(prefix.length() - 1) + "")) continue;
			}	
				printNumbers(prefix + i);
		}		
	
	}

	public static void main(String args[]) {
		printNumbers("");	
		System.out.println("Count: " +  count);
	}
}