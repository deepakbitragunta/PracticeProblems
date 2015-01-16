public class Permutations_KeyStrokes {

    public static String []  s = {null,"vtfrq","ftk","wzbg","rs",null,"fir","p","lo","p"};
	
	public static void print_KeyStrokes(String prefix, String number) {
		int n = number.length();
		
		if(n == 0) {
			if(prefix == "") {
				System.out.println("Invalid input");
				return;
			}
			System.out.println(prefix);
			return;
		}
		
		int first_char = Integer.parseInt(number.charAt(0) + "");
		if(first_char < 0 && first_char > 9) return;
		
		String temp = s[first_char];
		
		if(temp == null) {
			print_KeyStrokes(prefix, number.substring(1, n));
		}
		else{		
			for(int i = 0; i < temp.length(); ++i) {
				print_KeyStrokes(prefix + temp.charAt(i), number.substring(1, n));
			}
		}	
	}
	
	public static void main(String[] args) {
		String num = "9801";
		print_KeyStrokes("", num);
	}


}