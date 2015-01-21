public class matrix_red_black {

	public static int findCount(char [][]matrix, int n, char c) {
	int i, j;
	int count = 0;
	// Horizontal
	for(i = 0; i < n; ++i) {
		for(j = 0; j < n - 2; ++j) {
			if(matrix[i][j] == c && matrix[i][j + 1] == c && matrix[i][j + 2] == c) {
				count++;
			}
		}
	}
	// Vertical
	for(i = 0; i < n - 2; ++i) {
		for(j = 0; j < n; ++j) {
			if(matrix[i][j] == c && matrix[i + 1][j] == c && matrix[i  + 2][j] == c) {
				count++;
			}
		}
	}

	//First Diagonal (top down)
	for(i = 0; i < n - 2; ++i) {
		for(j = 0; j < n - 2; ++j) {
			if(matrix[i][j] == c && matrix[i + 1][j + 1] == c && matrix[i  + 2][j + 2] == c) {
				count++;
			}
		}
	}
	
	// Second Diagonal (bottom up)
	for(i = n - 1; i > 1 ; --i) {
		for(j = 0; j < n - 2; ++j) {
			if(matrix[i][j] == c && matrix[i - 1][j + 1] == c && matrix[i  - 2][j + 2] == c) {
				count++;
			}
		}
	}
	return count;

	}

	public static void main(String args[]) {

		char matrix [][]= {{'r','r','b', 'r'},
						   {'b','r','b', 'b'},
						   {'b','b','b', 'r'},
						   {'r','r','b', 'r'}};
		int n = matrix.length;
		int red_count = findCount(matrix, n, 'r');
		int black_count = findCount(matrix, n, 'b');

		if(red_count > black_count) {
			System.out.println("Winner is red");
		} else if (red_count < black_count) {
			System.out.println("Winner is black");
		}
			else 
			System.out.println("It's a tie");
	}
}