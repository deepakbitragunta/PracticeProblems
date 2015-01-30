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
	
	public static void main(String args[]) {
		ArrayList<Point> cur_path = new ArrayList<Point>();
		getPaths(cur_path, 3, 3);
		for(Point c : cur_path) 	
			System.out.println("(" + c.x + ", " + c.y + ")");
	}

}