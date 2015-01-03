package programs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class popularNum {

	public static void printPopular(int a[]) {
	
		HashMap<Integer,Integer> numCount = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < a.length; ++i) {
				
			if(numCount.containsKey(a[i])) {
				int count = numCount.get(a[i]);
				numCount.put(a[i], count + 1);	
			}
			else {
				numCount.put(a[i], 1);
			}			
		}
		
		Set<Integer> numKeys = numCount.keySet();
		Iterator<Integer> i = numKeys.iterator();
		int max  = 0;
		
		while(i.hasNext()) {
			if(max < numCount.get(i.next())) {
				max = i.next();
			}
		}
		System.out.println("The popular number is: " + max);
	}
	/* 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : a) {
			Integer count = map.get(i);
			map.put(i, count != null ? count+1 : 0);
		}
		Now, we find the number with the maximum frequency and return it:

		Integer popular = Collections.max(map.entrySet(),
			new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		}).getKey();
	*/
	public static void main(String args[]) {
		int a[] = {2, 6,7,2,1,6,7,2,8,9};
		printPopular(a);
	}
}