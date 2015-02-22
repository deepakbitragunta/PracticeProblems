import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations_phone {
    static String numToChars[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
    	 int len = digits.length();
    	    List<String> result = new ArrayList<String>();
    	    if(len == 0) {
    	        result.add("");
    	        return result;
    	    }
    	    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	     if(len == 1) {
    	        result.add("");
    	        return result;
    	    }
    	    for (int i = 0; i < len; i++) {
    	        int index = digits.charAt(i) - '0';
    	        List<String> old = new ArrayList<String>();
    	        old.addAll(result);
    	        
    	        for(int m = 0; m < map[index].length(); ++m) {
    	            for(String item : old) {
    	                item += map[index].charAt(m);
    	                result.add(item);
    	            }
    	        }
    	    } 
    	   
    	    return result;
    }
		
		public static void main(String args[]) {
		
			List<String> l = letterCombinations("22");
			System.out.println(l.toString());
		}
}