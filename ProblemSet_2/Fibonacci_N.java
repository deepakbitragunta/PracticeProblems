package programs;

public class Fibonacci_N {
	
	public static void printSeries(int n, int max) {
		int i;
		int last_n[] = new int[n];
		int last_sum = 0;
		
		for(i = 0; i < n; ++i) {
			last_n[i] = 1;
			System.out.println(last_n[i]);
		}
			
		while(true) {			
			for( i = 0, last_sum = 0; i < n - 1; ++i) {
				last_sum += last_n[i];
				last_n[i] = last_n[i + 1];
			}
			last_sum += last_n[i];
			last_n[i] = last_sum;
			if(last_sum > max) { 
				break;
			}
			else 
				System.out.println(last_sum);
		}
	}

	public static void main(String args[]) {
		printSeries(3, 12);
	
	}

}