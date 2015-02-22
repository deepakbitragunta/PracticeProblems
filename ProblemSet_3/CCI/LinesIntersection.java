public class LinesIntersection {
	
	class Line {
		
		double slope;
		double yIntercept;
		
		public void Line(double s, double y) {
			slope = s;
			yIntercept = y;
		}
	}
	public static void intersect(Line l1, Line l2) {
		return Math.abs(l1.slope - l2.slope) > EPSILON || Math.abs(l1.yIntercept - l2.yIntercept) < EPSILON;
	}
}