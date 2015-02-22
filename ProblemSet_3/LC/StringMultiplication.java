public class StringMultiplication {
    public static String addStrings(String s1, String s2, int k) {
        if(s1.length() == 0) return s2;
        if(s2.length() == 0) return s1;
        int n1 = s1.length();
        int n2 = s2.length();
        StringBuilder s3 = new StringBuilder("");
        
        s3.append(s1.substring(n1 - k, n1));
        int carry = 0;
        int i, j;
        for(i = n1 - k - 1, j = n2 - 1; i >= 0 || j >= 0; i--, j--) {
            int d1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int d2 = s2.charAt(j) - '0';
            int sum = d1 + d2 + carry;
            int d3 = sum % 10;
            carry = sum / 10;
            s3.insert(0, d3);
        }
        
        if(carry > 0) {
        	s3.insert(0, carry);
        }
        /* if(j >= 0) {
        	 String temp =  s2.substring(0, j);
        	 int l = temp.length
        	 while(l < temp.length()) {
        		 carry;
        	 }
             s3.insert(0, first);
         } else if(carry > 0) {
             first = carry;
             s3.insert(0, first);
         }*/
         
          return s3.toString();  
    } 
        
    public static String multiply(String num1, String num2) {
        int carry;
        String result = "";
        StringBuilder temp;
        int k = 0;
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        
        
        int n1 = num1.length();
        int n2 = num2.length();
        String zero = "0";
        
        if((n1 == 1 && num1.charAt(0) == '0') || (n2 == 1 && num2.charAt(0) == '0')) return zero;
        
        
        for(int i = n2 - 1 ; i >= 0; --i) {
            int d2 = num2.charAt(i) - '0';
            temp = new StringBuilder("");
            carry = 0;
            for(int j = n1 - 1; j >= 0; --j) {
                int d1 = num1.charAt(j) - '0';
                int prod = ((d1 * d2) + carry);
                int d3 = prod % 10;
                carry = prod / 10;
                temp.insert(0, d3);
            }
            if(carry > 0) {
                 temp.insert(0, carry);
            }
            result = addStrings(result, temp.toString(), k++);
        }
        return result;
    }
		public static void main(String args[]) {
			System.out.println(multiply("237", "284"));
			
		}
}   