package programs;

public class longest_palindrome {

	private static final boolean TRUE = true;

	public static String longest_common_string (String input) {
		return input;

 }
// O(n ^ 2) solution with O( n ^ 2) space
	public static String longest_Palindromic_substring (String input) {
		int n = input.length();
		int begin_index = 0;
		int max_length = 1;
		int len;
		boolean checkTable[][] = new boolean[n][n];
		
		for(int i = 0; i< n; ++i) {
			checkTable[i][i] = TRUE;
		}
		
		for(int i = 0; i < n - 1; ++i) {
			if(input.charAt(i) == input.charAt(i + 1)) {
				checkTable[i][i+1] = TRUE;
				begin_index = i;
				max_length = 2;
			}
		}
		for(len = 3; len <= n; ++len) {
			for(int i = 0; i < n - len + 1; ++i) {
			 int	j = i + len - 1;
				if(input.charAt(i) == input.charAt(j) && checkTable[i + 1][j - 1]) {
					checkTable[i][j] = TRUE;
					begin_index = i;
					max_length = len;
				}
			}
		}
		return (input.substring(begin_index, begin_index + max_length));
	}

// O(n ^ 2) solution with O(1) space by expanding around center
	public static String longest_Palindromic_substring_Space (String input) {
		int n = input.length();
		int max_length = 1;
		int len;
		int start = 0, end = 0, begin_index = 0;
	
	for(int i = 1; i < n; ++i) {
			start = i - 1;
			end = i + 1;	
			while(start >= 0 && end < n &&  input.charAt(start) == input.charAt(end)) {
				if( end - start + 1 > max_length) {
					begin_index = start;
					max_length = end - start + 1;
					
				}
				start--;
				end++;
			} 	
			start = i - 1;
			end = i ;	
			while(start >= 0 && end < n &&  input.charAt(start) == input.charAt(end)) {
				if( end - start > max_length) {
					max_length = end - start;
				}
				start--;
				end++;
			} 		
	}
		return (input.substring(start, start + max_length));
	}
	static int max(int a, int b) { return (a > b) ?  a : b; }

	// recursive solution 
	public static int longest_Palindromic_subsequence (String input, int i, int j) {
		
		if(i == j) { return 1; }
		if(j == i + 1 && input.charAt(i) == input.charAt(j)) return 2;
	
		if(input.charAt(i) == input.charAt(j)) return longest_Palindromic_subsequence(input, i + 1, j - 1) + 2;
		else {
				return	max(longest_Palindromic_subsequence(input, i, j - 1), longest_Palindromic_subsequence(input, i + 1, j));
		}		
	}
	
	// Dynamic programming solution O(n ^ 2) O(n ^ 2)
	public static int longest_Palindromic_subsequence (String input) {
		int n = input.length();
		int table[][] = new int[n][n];
		
		for(int i = 0; i < n; ++i) 
			table[i][i] = 1;

		for(int len = 2; len <= n; ++len) {
			for(int i = 0; i < n - len + 1; ++i) {	
					int j = i + len - 1;
					if(input.charAt(i) == input.charAt(j) && len == 2) { 
						table[i][j] = 2;
					}
				else if(input.charAt(i) == input.charAt(j)) {
						table[i][j] = table[i+1][j-1] + 2;
					}
				else {
						table[i][j] = max(table[i][j-1], table[i + 1][j]);
				}
			}
		}
		return table[0][n-1];
}

public static boolean isPalindrome(String s) {
	int l = 0, r = s.length() - 1;

	while( l < r) {
		if(s.charAt(l) != s.charAt(r)) return false;
		l++;
		r--;
	}
	return true;
}

public static boolean isRotation(String s) {
	int i, n = s.length();
	
	for(i = 0; i < n; ++i) {
		String right = s.substring(i, n);
		String left = s.substring(0, i + 1);
		String rotation = right + left;
		System.out.println(rotation);
		if(isPalindrome(rotation)) return true;
	}
	return false;
}
	public static void main(String args[]) {
		
		String input = "aaaad";

	//	System.out.println(longest_Palindromic_substring(input));
	//	System.out.println(longest_Palindromic_substring_Space(input));
		//	System.out.println(longest_Palindromic_subsequence(input, 0, input.length() - 1));
		//	System.out.println(longest_Palindromic_subsequence(input));
			System.out.println(isRotation(input));
	}

}