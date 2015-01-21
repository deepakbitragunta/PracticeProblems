public class test {
	/*int getHeight(Node n) {
		Node t = n;
		int count = 0;
		while(t != null) {
			count++;
			t = t.next;
		}
		return count;
	}
	
	Node findLCA(Node n1, Node n2) {
	
		int h1 = getHeight(n1);
		int h2 = getHeight(n2);
		
		if(h1 > h2) {
			swap(h1, h2);
			swap(n1, n2);
		}
		
		int df = h2 - h1;
		
		for(int i = 0; i < df; ++i) {
			n2 = n2.parent;
			while(n2 != null && n1 != null) {
				if(n2 == n1) return n2;
				
				n2 = n2.parent;
				n1 = n1.parent;
			
			}
		}
		return null;
	}
	*/
	public static String longestCommonSubstring(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int start_index = 0;
		int LCS[][] = new int[m+1][n+1];
		int result = 0;
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if( i == 0 || j == 0) {
					LCS[i][j] = 0;
				}
				else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
					if(result < LCS[i][j]) {
						start_index = i;
						result = LCS[i][j];	
					}	
				}
				else 
					LCS[i][j] = 0;
			}
		}
		
		return s1.substring(start_index - result, start_index);
	}
	
	/*public static ArrayList<Character> findFrequentCharacter(String s) {
	
		HashMap<Character, Integer> map = new  HashMap<Character, Integer> ();
		List<Character> max_chars = new ArrayList<Character>();
		if(s == null || s.length == 0) {
			return '';
		}
		int max = '';
		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
			if(map.get(c) > max) {
				max = map.get(c);
			}
		}
		for(Map<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue() == max)
				max_chars.add(entry.key);
		}
		return max_chars;
	}*/
	
	public static String binarySearchNum(int a[], int key) {
		int l = 0, mid;
		int r = a.length - 1, start = 0, end = 0;
		
		// First occurence
		while(l < r) {
			mid = l + (r - l) / 2;
			if(a[mid] == key) {
				if(mid < start) {
					start = mid;
				}
				if(mid > end) {
					end = mid;
				}
			}
			else if(a[mid] < key) {
				r = mid - 1;
			}
			else 
				l = mid + 1;
		}
		return start + ", " + end;
	}
	public static void main(String args[]) {
		int a[] = { 1, 2, 2, 4, 5, 5, 5, 5, 5, 6, 7, 7, 8, 9, 9};
		System.out.println(binarySearchNum(a, 5));
		System.out.println(longestCommonSubstring("astttas", "sttta"));
	}
}