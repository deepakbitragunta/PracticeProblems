public class printCoinChange {

	public static int print(int n, int denom) {
		int next_denom = 0;
		switch(denom) {
			case 25:
				next_denom = 10;
				break;
			case 10:
				next_denom = 5;
				break;
			case 5:
				next_denom = 1;
				break;
			case 1:
				return 1;
		}
		int count = 0;
		for(int i = 0; i * denom <= n; ++i) {
			count += print(n - i * denom, next_denom);
		}
		return count;
	}
	
	public static void main(String args[]) {
			System.out.println(print(10, 25));
	}

}