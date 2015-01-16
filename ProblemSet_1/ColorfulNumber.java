import java.util.List;
import java.util.ArrayList;

public class ColorfulNumber {

	public static boolean checkColorfulNum(int num) {
		if(num < 10) return true;
		if(num < 0) num = Math.abs(num);
		
		String number = String.valueOf(num);
		if(number.contains("0") || number.contains("1")) return false;
		
		int num_length = number.length();
		List<Integer> product = new ArrayList<Integer>();
		
		
		for(int i = 1; i < num_length; ++i) {
			for(int j = 0; j + i <= num_length; ++j) {
				int current = getProduct(Integer.parseInt(number.substring(j, j + i)));
				if(product.contains(current)) return false;
				else {
					product.add(current);
				}					
			}
		}
	return true;
	}
	public static int getProduct(int num) {
		if(num < 10) return num;
		int product = 1;
		while(num > 0) {
			product *= num % 10;
			num /= 10;
		}
		return product;
	}
	public static void main(String args[]) {
		int number = 2357;
		System.out.println(checkColorfulNum(number));	
	}
}