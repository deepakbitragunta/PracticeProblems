package programs;

public class longest_common {

	// O( m * n) time and space
	public static String longest_common_substring(String str1, String str2) {
		
		int n1 = str1.length() + 1; // Lengths increased by 1 so that to match the definition of DP
		int n2 = str2.length() + 1; // Lengths
		int start = 0;
		int result = 0;
		int lengths [][] = new int[n1][n2];
		
		for(int i = 0; i < n1; ++i) {
			for(int j = 0; j < n2; ++j) {
				if( i == 0 || j == 0) {
					lengths[i][j] = 0;
				}
				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lengths[i][j] = lengths[i -1][j - 1] + 1;
					result = max(result,  lengths[i][j]);
					start = i;
				}
				else {
					lengths[i - 1][j - 1] = 0;
				}
			}
		}
		return str1.substring(start - result, start);
	}
	// recursive and exponential
	public static int longest_common_subsequence(String str1, String str2, int m, int n) {
		if(m == 0 || n == 0) 
			return 1;
		
		if(str1.charAt(m) == str2.charAt(n)) 
			return 1 + longest_common_subsequence(str1, str2, m-1, n-1) ;
		else
			return max(longest_common_subsequence(str1, str2, m, n-1), longest_common_subsequence(str1, str2, m-1, n));
		
	}
	// DP O(n ^ 2) time and space
	public static int longest_common_subsequence(String str1, String str2) {
		int n1 = str1.length() + 1; // Lengths increased by 1 so that to match the definition of DP
		int n2 = str2.length() + 1; // Lengths
		int max_length = 0;
		int lengths [][] = new int[n1][n2];
		
		for(int i = 0; i < n1; ++i) {
			for(int j = 0; j < n2; ++j) {
				if( i == 0 || j == 0) {
					lengths[i][j] = 0;
				}
				else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lengths[i][j] = lengths[i -1][j - 1] + 1;
				}
				else {
					lengths[i][j] = max(lengths[i-1][j], lengths[i][j-1]);
				}
			}
		}
		return lengths[n1 - 1][n2 - 1];
	}
	
	// utility functions
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static void main(String args[]) {
		
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
	//	System.out.println(longest_common_substring(str1, str2));
		System.out.println(longest_common_subsequence(str1, str2, str1.length() - 1, str2.length() - 1));
		System.out.println(longest_common_subsequence(str1, str2));
	}

}