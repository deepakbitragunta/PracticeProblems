package programs;

import java.util.Stack;

public class paranthesis {

	public static boolean isMatched(String exp) {
		Stack<Character> s = new Stack<Character>();
	
		for(int i = 0; i < exp.length(); ++i) {
			char current = exp.charAt(i);
			
			if(current == '(') {
				s.push(current);
			}
			else if(current == '{') {
				s.push(current);
			}
			else if(current == '[') {
				s.push(current);
			}
			else if(current == ')') {
				if(s.isEmpty()) 	return false;
				 if(s.pop() != '(') return false;
			}
			else if(current == '}') {
				if(s.isEmpty())		return false;
				 if(s.pop() != '{') return false;
			}
			else if(current == ']') {
				if(s.isEmpty())		return false;
				 if(s.pop() != '[') return false;
			}
		}	
		return s.isEmpty();
	}
	
	public static void main(String args[]) {
		String exp = "(({}))({}[][])";
		System.out.println(isMatched(exp));
	}


}