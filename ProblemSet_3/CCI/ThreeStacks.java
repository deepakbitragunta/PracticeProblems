class stack1 {
	int top;
	
	public stack1(int top) {
		this.top = top;
	}
	void push(int a[], int item) {
		if(top + 1 < (a.length / 3)) {
			top = top + 1;
			a[top] = item;
		}
		else{
			System.out.println("Stack Overflow");
		}
	}
	int pop(int a[]) {
		System.out.println("top" + top);
		if(top - 1 >= (a.length / 3)) {
			System.out.println("No elements to delete");
			return -1;
		}
		else {
			int k = a[top];
			top--;
			return k;
		}
	}
}

class stack2 {
	int top;
	public stack2(int top) {
		this.top = top;
	}
	void push(int a[], int item) {
		if(top < (2 * a.length / 3)) {
		
		}
		else{
			System.out.println("Stack Overflow");
		}		
	}
	void pop(int a[]) {
	
	}
}

class stack3 {
	int top;
	public stack3(int top) {
		this.top = top;
	}
	void push(int a[], int item) {
	
	}
	void pop(int a[]) {
	
	}
}
class StackNode {
	int prev;
	int val;
	
	public StackNode(int last, int value) {
		prev = last;
		val = value;		
	}
}


public class ThreeStacks {
	
	StackNode buffer[] = new StackNode[300];
	int index = 0;
	int stackPointer[] = {-1, -1, -1};
	
	public void push(int stackNum, int value) {
		int last = stackPointer[stackNum];
		stackPointer[stackNum] = index;
		index++;
		buffer[stackPointer[stackNum]] = new StackNode(last, value);
	}
	
	public int pop(int stackNum) {
		int last = buffer[stackPointer[stackNum]].prev;
		int value = buffer[stackPointer[stackNum]].val;
		buffer[stackPointer[stackNum]] = null;
		stackPointer[stackNum] = last;
		index--;

		return value;
	}

	public static void main(String args[]) {
	
		ThreeStacks t3 = new ThreeStacks();
		t3.push(0, 5);
		t3.push(1, 6);
		t3.push(0, 8);
		System.out.println(t3.pop(0));
		System.out.println(t3.pop(1));
		t3.push(2, 26);
		t3.push(1, 16);
		t3.push(0, 18);
		t3.push(2, 28);
		System.out.println(t3.pop(0));
		System.out.println(t3.pop(1));
		System.out.println(t3.pop(2));
		
		int a[] = new int[20];
		// [0, n/3)
		stack1 s1 = new stack1(0);
		s1.push(a, 1);
		s1.push(a, 12);
		s1.push(a, 13);
		s1.push(a, 14);
		System.out.println(s1.pop(a));
		s1.push(a, 11);
		System.out.println(s1.pop(a));
		
		// [n/3, 2n/3)
		stack2 s2 = new stack2((a.length)/3);

		// [2n/3, n)
		stack3 s3 = new stack3((2 * a.length)/3);
	}
}