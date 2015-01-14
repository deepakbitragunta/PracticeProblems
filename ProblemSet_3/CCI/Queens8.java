public class Queens8 {

	static int colsForRow [] = new int[8];
	
	public static boolean check(int row) {
		for(int i = 0; i < row; ++i)  {
			int diff = Math.abs(colsForRow[row] - colsForRow[i]);
			if(diff == 0 || diff == row - i) 
				return false;
		}
		return true;
	}
	
	public static void placeQueens(int row) {
			if(row == 8) {
				printBoard();
				return;
			}
			
			for(int i = 0; i < 8; ++i) {
				colsForRow[row] = i;
				if(check(row)) {
					placeQueens(row + 1);
				}		
			}
	}
	
	public static void printBoard() {
		System.out.println("arrangement: ");
		for(int i = 0; i < 8; ++i) {
			System.out.println(colsForRow[i]);
		}	
		System.out.println();
	}
	
	public static void main(String args[]) {
		placeQueens(0);
	}
}