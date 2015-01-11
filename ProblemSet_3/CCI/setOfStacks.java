import java.util.ArrayList;
import java.util.Stack;

public class setOfStacks {
	int MAX_SIZE = 3;
	ArrayList<Stack<Integer>> stackSet = new ArrayList<Stack<Integer>>();
	
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
		if(index < stackSet.size()) {
			int val =  stackSet.get(index).pop();
			if(stackSet.get(index).size() == 0) stackSet.remove(index);	
			return val;
		}
		else return -1;
	}

	public static void main(String arg[]) {
		int a[] = {1, 5, 12, 8, 11, 14, 19, 13, 17, 14};
		setOfStacks s = new setOfStacks();
		for(int i = 0; i < a.length; ++i) {
			s.push(a[i]);
		}
		
	//	System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.popAtIndex(0));
		System.out.println(s.popAtIndex(1));
		s.push(22);
		System.out.println(s.popAtIndex(2));
	}

}

