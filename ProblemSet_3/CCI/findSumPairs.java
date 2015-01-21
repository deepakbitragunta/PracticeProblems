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