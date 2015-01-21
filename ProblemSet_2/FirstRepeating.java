package programs;

import java.util.HashSet;

public class FirstRepeating {

	public static int findRepeating(int a[]) {
		HashSet<Integer> s = new HashSet<Integer>();
		int position = -1;
		
		for(int i = a.length - 1; i >= 0; --i) {
			if(s.contains(a[i])) {
				position = i;
			}
			else {
				s.add(a[i]);
			}
		}
		return position;
	}
	
	public static void main(String args[]) {
		int a[] = {2, 4, 5, 2, 1, 6, 8, 9};
		int min = findRepeating(a);
		if(min == -1) System.out.println("No repeating elements");
		else System.out.println("The first repeating element is: " + a[min]);
	}
}