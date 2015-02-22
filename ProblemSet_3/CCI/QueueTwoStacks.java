import java.util.Stack;

public class QueueTwoStacks {

	Stack<Integer> s1, s2;
	
	public QueueTwoStacks() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	public void enqueue(int value) {
		s1.push(value);
	}
	
	public int dequeue() {
		if(s2.isEmpty()) {	
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
			return s2.pop();
	}
	
	public int peek() {
		if(s2.isEmpty()) {	
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
			return s2.peek();
	}
	public static void main(String args[]) {
		QueueTwoStacks q = new QueueTwoStacks();
		q.enqueue(12);
		q.enqueue(14);
		q.enqueue(42);
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		q.enqueue(242);
		System.out.println(q.dequeue());
	}
}