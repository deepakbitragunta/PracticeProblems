import java.util.ArrayList;
import java.util.Stack;

public class setOfStacks_rollover {
	ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	int capacity;
	
	public setOfStacks_rollover(int capacity) {
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		if(stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(int val) {
		if(stackSet.size() == 0) {
			Stack<Integer> s = new Stack<Integer>();
			stackSet.add(s);
		}
		int n = stackSet.size();
		
		if(n > 0 && stackSet.get(n - 1).size() < MAX_SIZE) {
			stackSet.get(n - 1).push(val);
		}
		else{
			Stack<Integer> s = new Stack<Integer>();
			s.push(val);
			stackSet.add(s);
		}
	}

	public int pop(){
		int n = stackSet.size();
		int val = stackSet.get(n - 1).pop();
		if(stackSet.get(n - 1).size() == 0) stackSet.remove(n - 1);	
		return val;
	}

	public int popAtIndex(int index) {
				return leftShit(index, true);
	}

	public 	int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		
		if(removeTop) removed_item = stack.pop();
		else removed_item = stack.removeBottom();
		
		if(stack.isEmpty()) {
			stacks.remove(index);
		}
		else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
	
}

public class Stack {

	private int capacity;
	public Node top, bottom;
	public int size = 0;
	
	public Stack(int capacity) { this.capacity = capacity; }
	public boolean isAtCapacity() { return capacity = size(); }
	
	public void join(Node above, Node below) {
		if(below != null) below.above = above;
		if(above != null) above.below = below;
	}
	
	public boolean push(int v) {
		if(size >= capacity) return false;
		size++;
		Node n = new Node(v);
		if(size == 1) bottom = n;
		join(n, top);
		top = n;
		return true;
	}
	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;	
	}
	
	public boolean isEmpty() { return size == 0; }
	
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if(bottom != null) bottom.below =	null;
		size--;
		return b.value;
	}

}
}

