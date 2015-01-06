/*class NodeMin {
	int min;
	int val;
	
	public NodeMin(int min, int value) {
		this.min = min;
		val = value;		
	}
}

public class StackMin{
	
	public void push(int value) {
		int min = Math.min(value, min());
		//push(min, value);	
	}
	
	public int pop() {
		return super.pop();
	}
	
	public int min() {
		if(this.isEmpty()) return Integer.MAX_VALUE; 	 	
		else {
			return peek().min;
		}
	}

}

public class StackEff extends StackMin {
	Stack s2;
	
	public StackEff() {
		s2 = new Stack();
	}
	
	public void push(int value) {

		if(value <= min())
			s2.push(value);
			
		super.push(value);
	}
	
	public int pop() {
		int value =  super.pop();
		if(value == min()) {
			s2.pop();
		}
		return value;
	}
	
	public int min() {
		if(this.isEmpty()) return Integer.MAX_VALUE; 	 	
		else {
			return s2.peek();
		}
	}

}
*/