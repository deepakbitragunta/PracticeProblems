public class matrixRotation {

	public static void printMatrix(int a[][], int n) {
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) 
				System.out.print(a[i][j] + " ");
			System.out.println("\n");
		}
	}
	
	public static void rotateClockwise(int a[][], int n) {
	
			int level, offset = 0, i = 0, first, last, top;
			
			for(level = 0; level < n / 2; ++level) {
					first = level;
					last =  n - 1 - level;
					for(i = first; i < last; ++i) {
						offset = i - first;
						//save top element
						top = a[first][i];
						// clockwise shift left -> top
						a[first][i] = a[last - offset][first];
						
						// clockwise shift bottom -> left	
						a[last - offset][first] = a[last][last - offset];
						
						// clockwise shift right -> bottom
						a[last][last - offset] = a[i][last];
						
						// clockwise shift top -> right
						 a[i][last] = top;
					}
			}
			printMatrix(a, n);
	}
	
	public static void rotateAntiClockWise(int a[][], int n) {
			int level, offset = 0, i = 0, first, last, top;
			
			for(level = 0; level < n / 2; ++level) {
					first = level;
					last =  n - 1 - level;
					for(i = first; i < last; ++i) {
						offset = i - first;
						//save top element
						top = a[first][i];
						// clockwise shift right -> top
						a[first][i] = a[i][last];
						
						// clockwise shift bottom -> right	
						a[i][last] = a[last][last - offset];
						
						// clockwise shift left -> bottom
						a[last][last - offset] = a[last - offset][first] ;
						
						// clockwise shift top -> left
						 a[last - offset][first]  = top;
					}
			}
			printMatrix(a, n);
			
	}
	
	public static void main(String args[]) {
	
		int a[][] = {
									{1, 3, 5, 7},
									{2, 4, 6, 8},
									{10, 12, 14, 16},
									{11, 13, 15, 17}
								};
		System.out.println("\n Clockwise");
		rotateClockwise(a, 4);
		System.out.println("\n Anti Clockwise");
		rotateAntiClockWise(a, 4);
	
	}
}