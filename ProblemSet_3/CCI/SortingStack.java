import java.util.Stack;

public class SortingStack {
	
	public Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> t = new Stack<Integer>();
		
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!t.isEmpty() && t.peek() > temp) {
				s.push(t.pop());
			}
			t.push(temp);
		}
	return t;
	}
	
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(22);
		s.push(14);
		s.push(42);
		s.push(-24);
		s.push(-34);
		s.push(34);
		s.push(24);
		SortingStack ss = new SortingStack();
		Stack<Integer> t = ss.sort(s);
		System.out.println(t.toString());
	}
}