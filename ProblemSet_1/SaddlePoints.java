public class SaddlePoints {

	public static void printSaddlePoints(int a[][]) {
		int i, j, k;
		int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
		int n = a.length;
		int saddle_j = 0;
		
		for(i = 0; i < n; ++i) {
			for(j = 0; j < n; ++j) {
				if(a[i][j] > max) {
					max = a[i][j];
					saddle_j = j;
				}
			}
			for(k = 0 ; k < n; ++k) {
				if(a[k][saddle_j] < min) {
					min = a[k][saddle_j];
				}
			}
			if(max == min) {
				System.out.println(max);
			}
		}
	}
		
	
	public static void main(String args[]) {
		 int[][] arr = {{2, 6, 3},
				 		{11, 13, 1}, 
				 		{10, 12, 25}};
		 printSaddlePoints(arr);
	}

}