public class Queens8 {

	int colsForRow [] = new int[8];
	
	boolean check(int row) {
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
	
	public void printBoard() {
		for(int i = 0; i < 8; ++i) {
			System.out.println(colsForRow[i]);
		}	
	}
	
	public static void main(String args[]) {
		placeQueens(0);	
	}
}