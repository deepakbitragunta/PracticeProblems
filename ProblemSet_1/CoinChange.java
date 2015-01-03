public class CoinChange {

	public static int findSolutions_DP (int a[], int sum) { 
		int n = a.length;
		int i, j;
		int table [][] = new int[sum + 1][n];
		int x, y;
		for(i = 0; i < n; ++i) {
			table[0][i] = 1;
		}
		
		for(i = 1; i < sum + 1; ++i) {
			for(j = 0; j < n; ++j ) {
				// count no of solutions including a[j]
				x = (i - a[j] >= 0) ? table[i - a[j]][j] : 0;
				
				//count no of solutions excluding a[j]
				y = (j >= 1) ? table[i][j - 1] : 0;
				
				table[i][j] = x + y;				
			}
			
		}
		
		return table[sum][n - 1];
	}
	/*public static int findSolutions_space(int a[], int sum) {
		int n = a.length;
		int i, j;
		boolean valid = false;
		
		for(i = 0 ; i < n; ++i) {	
			if(a[i]  <=  sum && a[i] != 0) {
				valid = true;
				break;
			}
		}
		
		if(!valid) return 0;
		
		
		int table[] = new int[sum + 1];
		
		
		table[0] = 1;
		
		for(i = 1; i < sum + 1; ++i) {
			table[i] = 0;
		}
		
		for(i = 0; i < n; ++i) {
			for(j = a[i]; j < sum + 1; ++j) {
				table[j] += table[j - a[i]];
			}
		}	
		return table[n];
	}*/
	
	public static void main(String args[]) {
		int a[] = {1, 0, 3, 4};
		int sum = 4;
	//	System.out.println(findSolutions_space(a, sum));
		System.out.println(findSolutions_DP(a, sum));
	}
}