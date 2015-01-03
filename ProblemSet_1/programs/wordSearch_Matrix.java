
public class wordSearch_Matrix {
	
	/*public static char matrix[][] = { 
		{ 'a', 'b', 'c', 'd' }, 
		{ 'e', 'f', 'g', 'h' },
		{ 'i', 'j', 'k', 'l' }, 
		{ 'm', 'n', 'o', 'p' } };
	public static int n = matrix[0].length;
	
	public static  int xd[] = { -1, -1,  0, +1, +1, +1,  0, -1};

	public static int yd[] = { 0, -1, -1, -1,  0, +1, +1, +1 };
*/	
	/*public static boolean wordSearch(String word, int i, int j, int d) {
		
		 if (word.length == 0) {
	        	System.out.println("i = " + i + " : j = " + j);
	        	return true;
	        }
		 if (i < 0 || j < 0 || i >= n || j >= n)
	            return false;
		 
		 for(int d = 0; d < 8; ++d) {
				if(!wordSearch(word,  i, j, d)) return false;
			}
		

	        if (matrix[j][i] != word[0])
	            return false;

	        // when we reach the last character in the word
	        // the values of x,y represent location in the
	        // puzzle where the word stops
	       
	        // test the next character in the current direction
	        char[] copy = new char[word.length - 1];
	        System.arraycopy(word, 1, copy, 0, word.length - 1);
	        
		 
		return wordSearch(word, i + xd[d], j + yd[d], d);
	}*/

	
	
	public static boolean wordSearch(char word[][], String pattern, int i, int j, int k, boolean [][] visited) {
		int xd[] = {-1, -1, -1,  0, +1, +1, +1,  0};
	    int yd[] = {1, 0, -1, -1, -1,  0, +1, +1};
		int n = word.length;
		int m = pattern.length();
		
		if(k == m) { return true; }
	    if(i <= 0 || j <= 0 || i >= n - 1  || j >= n - 1 ) return false;
	    
	    if((word[i][j] != pattern.charAt(k)) || visited[i][j] == true) return false;
	    
	    visited[i][j] = true;
	    
		for(int d = 0; d < 8; ++d) {
			if(wordSearch(word, pattern,  i + xd[d], j + yd[d], k + 1, visited)) return true;
		}
	
		return (visited[i][j] = false);
	}
	
	public static boolean wordSearch(char word[][], String pattern) {
		int n = word.length;
		if(n == 0) { return false; }
		boolean found  = false;
		boolean visited[][] = new boolean[n][n];
		
		
		for(int i = 0; i < n; ++i) {
			for( int j = 0; j < n; ++j) {
				visited[i][j] = false;
				if(wordSearch(word, pattern, i, j, 0, visited))  {
					found = true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		
		return found;
	}
	
	public static void main(String args[]) {
		char word[][] = { 
			{ 'a', 'b', 'c', 'd' }, 
			{ 'e', 'f', 'g', 'h' },
			{ 'i', 'j', 'k', 'l' }, 
			{ 'm', 'n', 'o', 'p' } };
		String pattern = "mjgd";
		
		if(wordSearch(word, pattern)) {
			System.out.println("word found");
		}
		else
			System.out.println("word not found");
	}

}