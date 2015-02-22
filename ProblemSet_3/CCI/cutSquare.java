public class cutSquare {
	
	class point {
		int x;
		int y;
		public point(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	class square {
		point left, right;
		int size;
		public square(point l, point r, int s) {
			left = l;
			right = r;
			size = s;
		}
	}
	
	
	
	public void drawLine(square s1, square s2) {
		int mx = (s1.left.x + s1.right.x) / 2;
		int my = (s1.left.y + s1.right.y) / 2;
		point m1 = new point(mx, my);
		
		mx = (s2.left.x + s2.right.x) / 2;
		my = (s2.left.y + s2.right.y) / 2;
		
		point m2 = new point(mx, my);
		
		if(m1.equals(m2)) {
			return new line(s1.left, s2.right);
		} else {
			return new line(m1, m2);
		}
		
		line l  = new line(m1, m2);
		
		return l;
	}
	
	public static void main(String args[]) {
		point l = new point(0, 2);
		point r = new point(2, 0);
		int s = 2;
		square s1 = new square(l, r, s);
		point l2 = new point(4, 2);
		point r2 = new point(6, 0);
		square s2 = new square(l2, r2, s);
		cutSquare cs = new cutSquare(s1, s2);
		point mid = cs.middle(s1, s2);
		System.out.println(mid.x + " " + mid.y);
	}
}