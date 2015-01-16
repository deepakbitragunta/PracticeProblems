package programs;

public class patternSearch {
	
	public static int [] preprocessPattern(String pattern) {
		int m = pattern.length();

		int lps [] = new int[m];
		int len = 0; // length of previous proper suffix

		lps[0] = 0;

		for(int i = 1; i < m;) {
			if(pattern.charAt(i) == pattern.charAt(len)) {		
				len++;
				lps[i] = len;
				++i;
			}
			else {
				if(len != 0){ 
					len = lps[len - 1];
				}
				else {
					lps[i] = 0;
					++i;
				}
			}
		}
	  return lps;
	}

	public static boolean findPattern(String pattern, String text) {
		int n = text.length(), m = pattern.length();
		int i, j;
		int lps [] = preprocessPattern(pattern);
		
		for( i = 0, j = 0; i < n - 1;) {
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			if(j == m) {				
				j = lps[j - 1];
				return true;
			}
			else if(text.charAt(i) != pattern.charAt(j)) {
				if( j != 0) {
					j = lps[j - 1];
				}
				else{
					++i;
				}
			}
			
		}
		return false;
	}
public static void main(String args[]) {
		
		String text = "thieietteeteee";
		String pattern = "etteee";

		System.out.println(findPattern(pattern, text));
	}

}