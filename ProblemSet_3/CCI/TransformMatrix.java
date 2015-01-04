public class TransformMatrix{

	public static void printMatrix(int a[][], int n) {
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) 
				System.out.print(a[i][j] + " ");
			System.out.println("\n");
		}
	}
	
	public static void printMatrix(int a[][], int m, int n) {
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) 
				System.out.print(a[i][j] + " ");
			System.out.println("\n");
		}
	}

	public static void nonBooleanMatrix(int a[][], int m, int n) {
	
			int rows[] = new int[m];
			int cols[] = new int[n];
			
			int i, j;
			
			for(i = 0; i < m; i++) {
				for(j = 0; j < n; j++) {
					if(a[i][j] == 0){
						rows[i] = 1;
						cols[j] = 1;
					}
				}
			}
			
			for(i = 0; i < m; ++i) {
				for(j = 0; j < n; ++j) {
					if(rows[i] == 1 || cols[j] == 1) {
						a[i][j] = 0;
					}
				}
			}
			
			printMatrix(a, n);
	}
	
	public static int scanRow(int a[][], int i) {
		for(int k = 0; k < a[i].length; ++k) {
			if(a[i][k] == 0) {
					return 0;
			}
		}
		return 1;
	}
	
	public static int scanCol(int a[][], int i) {
		for(int k = 0; k < a.length; ++k) {
			if(a[k][i] == 0) {
					return 0;
			}
		}
		return 1;
	}
	

	
	public static void booleanMatrix(int a[][], int m, int n) {
			int i, j, k;
			int firstRow = scanRow(a, 0);
			int firstCol = scanCol(a, 0);
			
			// use first row as auxillary space for all columns
			for(k = 0; k < n; ++k) {
				a[0][k] = scanCol(a, k);
			}
			
			// use first col as auxillary space for all rows
			for(k = 0; k < m; ++k) {
				a[k][0] = scanRow(a, k);
			}
			
			a[0][0] = firstRow | firstCol;
			
			for(i = 1; i < m; ++i) {
				for(j = 1; j < n; ++j) {
					a[i][j] = a[0][j] & a[i][0];
				}
			}
			

			if(firstRow == 0) {
				for(k = 0; k < a.length; ++k) 
					a[0][k] = 0;			
			}
			
			if(firstCol == 0) {
				for(k = 0; k < a.length; ++k) 
					a[k][0] = 0;			
			}
			System.out.println("Final matrix ");
			printMatrix(a, m, n);
			
	}
	
	public static void main(String args[]) {
	
		int a[][] = {
									{1, 3, 5, 0},
									{2, 1, 6, 8},
									{10, 12, 0, 16},
									{11, 13, 15, 17}
								};
		int b[][] = {
						{1, 0, 1, 1},
						{1, 1, 1, 0},
						{1, 0, 1, 1},
						{1, 1, 1, 1}
					};
		System.out.println("\n Non Boolean");
		nonBooleanMatrix(a, 4, 4);
		System.out.println("\n  Boolean");
		booleanMatrix(b, 4, 4);
		
	}
}