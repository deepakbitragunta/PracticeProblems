public class SearchSortedStrings {

	public static int findString(String[] a, String key) {
		int l = 0, r = a.length - 1;
		
		while( l <= r) {		
			while(l <= r && a[r] == "") 
				r--;
			if(r < l) return -1;
			
			int mid = l + (r - l) / 2;
			while(a[mid] == "") {
				mid++;
			}
			int result = a[mid].compareTo(key);
			System.out.println(a[mid]);
			if(result == 0) {
				return mid;
			}
			else if(result > 0){
				r = mid - 1;
			}
			else 
				l = mid + 1;
		}
		return -1;
	}
	
	public static int findString(String s[], int length, String key) {
		if(s == null || key == null) return -1;
		if(key == "") {
			for(int i = 0; i < length; ++i)
				if(s[i] == "") return i;
		}
		return findString(s, key);
	}
	public static void main(String args[]) {
		String s[] = { "", "etet", "", "", "gdd", "", "", "ggg", "kdf", "lgg"};
		System.out.println(findString(s, s.length, "ggg"));
		System.out.println(findString(s, s.length , ""));
	}
}