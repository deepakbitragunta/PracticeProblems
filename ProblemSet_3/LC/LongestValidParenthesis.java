import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
      
        int start = 0, max = 0;
        
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        max = Math.max(max, i - start + 1);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
         }
        return max;
					
		}
	public static void main(String args[]){
		System.out.println(longestValidParentheses("(()(("));
	}
}