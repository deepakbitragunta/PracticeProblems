public class PaintColor {
	enum Color {
		BLACK, WHITE, RED, GREEN, BLUE
	}
	public static boolean fillColor(Color c[][], int x, int y, Color old, Color nColor) {
		if(x < 0 || x >= c[0].length ||
		   y < 0 || y >= c.length) {
				return false;
		}
		if(c[y][x] == old) {
			c[y][x] = nColor;
			fillColor(c, x - 1,  y,  old, nColor); // left
			fillColor(c, x + 1,  y,  old, nColor); // right
			fillColor(c, x,  y - 1,  old, nColor); // up as we are starting at (n, n)
			fillColor(c, x,  y + 1,  old, nColor); // down
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		Color c[][] = { { Color.BLACK, Color.BLACK, Color.WHITE, Color.RED},
						{ Color.GREEN, Color.RED, Color.GREEN, Color.RED},
						{ Color.GREEN, Color.RED, Color.BLUE, Color.RED},
						{ Color.RED, Color.GREEN, Color.BLUE, Color.BLUE},
					 };
		
		
		System.out.println(fillColor(c, 3, 3, Color.BLUE, Color.BLACK));
		for(int i = 0; i < c[0].length; ++i) {
			for(int j = 0; j < c.length;++j){
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}