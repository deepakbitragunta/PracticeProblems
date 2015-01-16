package programs;

import java.util.HashMap;
import java.util.Map;
	
public class TwoSum {

	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			if (map.containsKey(target - x)) {
				return new int[] { map.get(target - x) + 1, i + 1 };
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String args[]) {
		int [] num = {1,6,3,2,7,8,3,2,6,7,9,4};
		int target = 12;
		int res[] = twoSum(num, target);
		for(int i = 0; i < res.length; ++i) { 
			System.out.println(res[i]);
		}
	}
	
}