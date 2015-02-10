import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class findSumPairs {

	public static String getPairs(int a[], int sum) {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		ArrayList<String> pairs = new ArrayList<String>();
		
		for(int i = 0; i < a.length; ++i) {
			if(table.containsKey(sum - a[i])) {
				pairs.add("(" + (sum - a[i]) + "," + " " +  a[i] + ")");
			}
			else {
				table.put(a[i], sum - a[i]);
			}
		}
		return pairs.toString();
	}
	// O(n)
	public static String getPairsSorted(int a[], int sum) {
		Arrays.sort(a);
		ArrayList<String> pairs = new ArrayList<String>();
		int first = 0;
		int last = a.length - 1;
		
		while(first < last) {
			int temp = a[first] + a[last];
			if(temp == sum) {
				pairs.add("(" + a[first] + "," + " " +  a[last] + ")");
				first++;
				last--;
			} else{
				if (temp < sum) {
					first++;
				}		
				else {
					last--;
				}
			}
		}
		
		return pairs.toString();
		
	}
	/*	// O(n log n)
		public static String findPairs(int a[], int sum) {
			for(int i = 0; i < n; ++i) {
				binarySearch(a, i + 1, a.length - 1, sum - a[i]);
			}
		}
		
		public static int binarySearch(int a[], int l, int r, int key) {
		
			while( l < r) {
				int mid = (l + (r - l)) / 2;
				if(a[mid] == key) return true;
			
			
			}
			*/
		
		
		}
		public static String getPairsSorted(int a[], int sum) {
		Arrays.sort(a);
		ArrayList<String> pairs = new ArrayList<String>();
		int first = 0;
		int last = a.length - 1;
		
		while(first < last) {
			int temp = a[first] + a[last];
			if(temp == sum) {
				pairs.add("(" + a[first] + "," + " " +  a[last] + ")");
				first++;
				last--;
			} else{
				if (temp < sum) {
					first++;
				}		
				else {
					last--;
				}
			}
		}
		
		return pairs.toString();
		
	}
	
	public static void main(String args[]) {
		int a[] = {4, 2, 6, 4, 2, 7, 1, 10, 15};
		int sum = 8;
		System.out.println(getPairsSorted(a, sum));
	}
}