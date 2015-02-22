import java.util.ArrayList;

class Point {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class RightBottom {
	

	public static boolean is_free(int x, int y) {
		return true;
	}
	public static boolean getPaths(ArrayList cur_path, int x, int y) {
		Point p = new Point(x, y);
		cur_path.add(p);
		
		if(x == 0 && y == 0) return true;
		
		boolean success = false;
		
		if(x >= 1 && is_free(x - 1, y)) {
			success = getPaths(cur_path, x - 1, y);
		}
		if(!success && y >= 1 && is_free(x, y - 1)) {
			success = getPaths(cur_path, x, y - 1);
		}
		if(!success) {
			cur_path.remove(p);
		}
		return success;
	}
	public static int countAllPaths(int m, int n) {
		int paths[][] = new int[m + 1][n + 1];
		
		paths[m - 1][n] = 1;
		
		for(int i = m - 1; i >= 0; --i) {
			for(int j = n - 1; j >= 0; --j) {
				paths[i][j] = paths[i + 1][j] + paths[i][j + 1]; // + paths[i + 1][j + 1];
			}
		}
		return paths[0][0];
	}
	
	public static void printAllPaths(int i, int j, int matrix[][], int paths[], int index, int m, int n) {
		// last row
		if(i == m - 1) {
			for(int c = j; c < n; ++c) {
				
				paths[index + c - j] = matrix[i][c];
			}
			for(int k = 0; k < index + n - j; ++k) {
				System.out.print(paths[k] + " ");
			}
			System.out.println("\n");
			return;
		}
		
		// last column 
		if(j == n - 1) {
			for(int r = i; r < m; ++r) {
				paths[index + r - i] = matrix[r][j];
			}
			for(int k = 0; k < index + m - i; ++k) {
				System.out.print(paths[k] + " ");
			}
			System.out.println("\n");
			return;
		}
		
		paths[index] = matrix[i][j];
		// Go right
		printAllPaths(i, j + 1, matrix, paths, index + 1, m , n);
		
		// Go downward
		printAllPaths(i + 1, j, matrix, paths, index + 1, m, n);
		
		// Go Diagonal
		// printAllPaths(i + 1, j + 1, matrix, paths, index + 1, m, n);
		
	}
	
	public static void main(String args[]) {
		ArrayList<Point> cur_path = new ArrayList<Point>();
		getPaths(cur_path, 3, 2);
		for(Point c : cur_path) 	
			System.out.println("(" + c.x + ", " + c.y + ")");
		System.out.println(countAllPaths(3, 2));
		int matrix[][] = {{1, 2, 3}, {4, 5, 6}};
		int paths[] = new int[matrix.length + matrix[0].length];
		printAllPaths(0, 0, matrix, paths, 0,  matrix.length, matrix[0].length);
	}

}