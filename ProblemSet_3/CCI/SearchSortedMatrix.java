public class SearchSortedMatrix {
	static int count = 0;
	public static boolean search(int m[][], int row, int col, int key) {
	
		int r = 0;
		int c = col - 1;
		
		while(r < row && c >= 0) {
			count++;
				if(m[r][c] == key) {
					return true;
				}
				else if (key < m[r][c]) {
						c = c - 1;
				} else {
						r = r + 1;
				}
		}
		return false;
	}

	public static void main(String args[]) {
		int m[][] = { 
									{1, 4, 5, 6},
									{3, 6, 7, 8},
									{4, 7, 8, 9},
									{5, 7, 8, 10}
								};
		System.out.println(search(m, 4, 4, 7));
		System.out.println(count);
	}
}