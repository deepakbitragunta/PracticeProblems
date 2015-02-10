import java.util.LinkedList;
import java.util.List;

public class MissingRanges {
	
	public static List<String> findRanges(int a[]) {
		List<String> list = new LinkedList<String>();
		if(a.length == 0) return list;
		
		for(int i = 0; i < a.length - 1; ++i) {
			if(a[i + 1] - a[i] < 2) {
			continue;
			}	else if(a[i + 1] - a[i] == 2) {
				list.add(String.valueOf(a[i] + 1));
			}	
			else {
				list.add((a[i] + 1) + "->" + (a[i + 1] - 1));
			}
		}
		
		return list;
	}
	public static void main(String args[]) {
		int a[] = { 1, 2, 5, 7, 10, 13, 13, 30, 37};
		System.out.println(findRanges(a).toString());
	}
	
}