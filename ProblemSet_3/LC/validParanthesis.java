import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParanthesis {
    private static final HashMap<Character, Character> map =  new HashMap<Character, Character>(){{
        put('(', ')'); 
        put('{', '}'); 
        put('[', ']'); 
    }};
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s == null || s.length() == 1) return false;
        
        if(s.length() == 0) return true;
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c); 
            }
            else if(stack.isEmpty() || map.get((stack.pop())) != c){
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String args[]) {
    	System.out.println(isValid("["));
    }
}