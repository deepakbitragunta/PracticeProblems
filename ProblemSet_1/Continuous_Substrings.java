public class Continuous_Substrings {

	public static void print(String str) {
		int i = 0, n = str.length();
		str = str.toLowerCase();
		boolean contiguous = false;
		
		for(i = 0; i < n - 1 ; ++i) {
			if(str.charAt(i + 1) - str.charAt(i) == 1) {
				System.out.print(str.charAt(i));
				contiguous = true;
			}
			else {
				if(contiguous) {
					System.out.print(str.charAt(i) + ";");
				}
				contiguous = false;
			}
				
		}
	}
	
	public static void main(String args[]) {
		print("AbcDefljdflsjflmnopflsjflasjftuvWxYz ");
	}

}