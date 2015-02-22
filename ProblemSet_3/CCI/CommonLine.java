public class CommonLine {
	
	public Line findMostCommonLine(GraphPoints [] points) {
		int i = 0;
		int j = 0;
		
		HashMap<Line, Integer> map = new HashMap<Line, Integer>();
		Line best = null;
		
		for(i = 0; i < points.length; ++i) {
			for(j = i + 1; j < points.length; ++j) {
				Line l = new Line(points[i], points[j]);
				if(map.containsKey(l)) {
					map.put(l, map.get(l) + 1);
				} else {
					map.put(l, 1);
				}
				
				if(best == null || map.get(l) > map.get(best)) 
					best = l;
			}
		}
		return best;
	}
	
	class line {
		public static double epsilon = 0.001;
		double slope;
		double intercept;
		
		public line(point p1, point p2) {
			if(Math.abs(p1.x - p2.x) > epsion) {
				slope = (p1.y - p2.y) / (p1.x - p2.x);
				intercept = p.y - slope * p.x;
			} else {
				infinite = true;
				intercept = p1.x 				
			}
		}
		
		public boolean isEqual(double a, double b) {
			return (Math.abs(a - b) < epsilon);
		}
		
		public int hashcode() {
			int sl = (int) (slope * 1000);
			int in = (int) (in * 1000);
			return sl | in;
		}
		
		public boolean equals(Object o) {
			Line l = (line) o;
			if(isEqual(l1.slope, l2.slope) && isEqual(l1.in, l2.in) && infinite == l1.infinite) {
				return true;
			} 
			return false;
		}
	}
	
}