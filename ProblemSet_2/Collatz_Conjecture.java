package programs;

public class Collatz_Conjecture {
	
	public static void displaySequence(int num) {
	
		while(num > 1){
			System.out.println(num);
			if(num % 2 == 0) {
				num = num / 2;
			}
			else {
				num = num * 3 + 1;
			}
		}
		System.out.println(num);
	}

	public static void main(String args[]) {
		int num = 10;
		displaySequence(6);
	}
}