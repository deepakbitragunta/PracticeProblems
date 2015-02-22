import java.util.Queue;
import java.util.LinkedList;

public class MagicNumber {
	
	public static int findKthNumber(int k) {
		if(k <= 0) return 0;
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		
		q3.add(3);
		q5.add(5);
		q7.add(7);
		int val = 1;
		
		for(k--; k > 0; --k) {
			val = Math.min(q3.peek().intValue(), Math.min(q5.peek().intValue(), q7.peek().intValue()));
			if(val == q7.peek()) {
					q7.remove();
			} else {
				if(val == q5.peek()) {
					q5.remove();
				} else {
					if(val == q3.peek()){
						q3.remove();
						q3.add(val * 3);
					}
				}
				q5.add(val * 5);
		}
		q7.add(val * 7);
	}
	return val;
}
	public static void main(String args[]) {
		
		System.out.println(findKthNumber(14));
	}
}