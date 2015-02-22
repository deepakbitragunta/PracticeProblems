public class TwoSum {

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public void add(int val) {
		int count;
		if(map.containsKey(val)) { 
			count = map.getValue();
		} else {
			count = 0;
		}
		map.put(val, count);
	}
	public boolean find(int val) {
	
		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
		
			int num = val - e.getKey();
			if(num == e.getKey()){
				if(e.getValue() >= 2) return true;
			} else if (map.containsKey(num)) {
				return true;
			}
		}
		return false;
	}
	
}