import java.util.Arrays;
import java.util.Comparator;
public class Solution {
   public static String largestNumber(int[] num) {
       String nums[] = new String[num.length], result = "";
       
       for(int i = 0; i < num.length; ++i) {
            nums[i] = String.valueOf(num[i]);
       }    
            
        Arrays.sort(nums, new Comparator<String> () {
        	 public int compare(String s1, String s2) {
        		 if(s1.length() == s2.length()) {
        			 return s2.compareTo(s1);
        		 }
        		 
        		 String s12 = s1 + s2;
        		 String s21 = s2 + s1;
        		 return s21.compareTo(s12);
	        }
    	});
        
        for(int i = 0; i < nums.length; ++i) {
        	System.out.println(nums[i]);
            result +=nums[i];
        }  
        if (result.length() > 0 && result.charAt(0) == '0') return "0";
        
		return result;
    }
   public static void main(String args[]) {
	   int a[] = {1, 2, 3, 4};
	   largestNumber(a);
	   int b[] = {4, 3, 2, 1};
	   largestNumber(b);
   }
}