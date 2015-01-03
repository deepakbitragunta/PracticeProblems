public class ChangeBreakDown {
	public static void printChange(int money, int bill) {
		int money_left = money - bill;
		money_left *= 100;
		int count = 0;
		int denoms [] = { 1, 5, 10, 25, 50, 100, 500, 1000}; // in cents
	
	for(int i = denoms.length - 1; i >= 0; --i) {
		if(money_left >= denoms[i]) {
			count = money_left / denoms[i];
			money_left = money_left - (denoms[i] * count);
			System.out.println(denoms[i] + " cents:  " + count);
		}
	}	
	if(money_left >= 0) {
			System.out.println("Left over money without denomiations: " + money_left);
	}
	}
	
	public static void main(String args[]) {
		printChange(153,22);
		
	}
}