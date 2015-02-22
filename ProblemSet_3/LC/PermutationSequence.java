import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<Integer>();
        
        for(int i = 1; i <= n; ++i) {
            list.add(i);
        }
        
        int fact = 1;
        
         for(int i = 2; i <= n; ++i) {
            fact = fact * i;
        }
        
        k = k - 1;
        StringBuilder newString = new StringBuilder();
        for(; n > 0; n--) {
            fact = fact / n;
            newString.append(list.remove(k / fact));
            k = k % fact;
        }
        
      return newString.toString();
    }
    
    public static void main(String args[]) {
    	System.out.println(getPermutation(3, 4));
    }
}