import java.util.HashMap;

public class wordValue {
	
	public static int calculateValue(String word) {
		int value = 0;
		if(word == null || word.length() == 0) return value;
		int i;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int first = 1, second = 1;
		char c = 'a';
		map.put(c, first);
		map.put(++c, second);
		
		for(i = 3; i <= 26; ++i) {
			int current = first + second;
			System.out.println(current);
			map.put(++c, current);
			first = second;
			second = current;
		}
		
		for(i = 0; i < word.length(); ++i) {
			if(map.containsKey(word.charAt(i))) {
				System.out.println(map.get(word.charAt(i)));
				value += map.get(word.charAt(i));
			} 
		}
		return value;
	}
	public static void main(String args[]) {
		System.out.println(calculateValue("deepak"));
	}
	
}