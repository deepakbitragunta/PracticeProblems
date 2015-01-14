class stack {
	int data[];
	int head;
	public stack() {
		data  = new int[200000];
		head = -1;
	}
	public void push(int num) {
		if(head >= 200000) {
			System.out.println("-1");
			System.exit(0);
		}
		else {
			head++;
			data[head] = num;			
		}
	}
	
	public int pop() {
		if(head < 0) {
			return -1;
		}
		else {
			
			 int val = data[head];
			 head--;
			 return val;
		}
	}	
}

public class ExpressionEvaluator {


public static void main(String args[]) {
	String s = "2 *";
	stack ss = new stack();
	String tokens[] = s.split(" ");
	int i = 0;
	while(i < tokens.length){
		if(tokens[i].charAt(0) == '+') {
			int val1 = ss.pop();
			int val2 = ss.pop();
			if(val1 == -1  || val2 == -1) {
				System.out.println("-1");
				System.exit(0);
			}
			int sum = val1 + val2;
			ss.push(sum);
		}
		else if(tokens[i].charAt(0) == '*') {
			int val1 = ss.pop();
			int val2 = ss.pop();
			if(val1 == -1  || val2 == -1) {
				System.out.println("-1");
				System.exit(0);
			}
			int prod = val1 * val2;
			ss.push(prod);
		}
		else if(Integer.parseInt(tokens[i]) >=  0 || Integer.parseInt(tokens[i]) <=  9) {
			ss.push(Integer.parseInt(tokens[i]));
		}
		++i;
	}
	System.out.println(ss.pop());
}
}