import java.util.HashMap;
import java.util.Map.Entry;

public class CheckAnagrams {

	public static HashMap<Character, Integer> getCountMap(String str) {
		HashMap<Character, Integer> countStr = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); ++i){
			char key = str.charAt(i);
			if(countStr.containsKey(key)) {
					int temp = countStr.get(key);
					countStr.put(key, temp + 1);
			}
			else {
					countStr.put(key, 1);
			}		
		}
		return countStr;
	}
	
	// Own comparison method
	public static boolean compareMaps(HashMap<Character, Integer>  str1, HashMap<Character, Integer> str2) {
		if(str1.isEmpty() && str2.isEmpty()) {
			return true;
		}
		if(str1.size() != str2.size()) {
			return false;
		}
		for(Entry <Character, Integer> entry: str1.entrySet()) {
			if(str2.get(entry.getKey()) != str1.get(entry.getKey())) {
				return false;
			} 
		}
		
		return str1.isEmpty() ? false : true;
	}
	
	public static boolean isAnagrams(String str1, String str2) {
		HashMap<Character, Integer> countStr1 = getCountMap(str1);
		HashMap<Character, Integer> countStr2 = getCountMap(str2);
		
		System.out.println("check anagrams using equals() : " + countStr1.equals(countStr2));

		return compareMaps(countStr1, countStr2);	
	}
	
	public static void main(String args[]) {
		String str1 = "abcva", str2 ="abcvaa";
		System.out.println(isAnagrams(str1, str2));
		
		str1 = "aaaabbbccc";
		str2 ="abc";
		System.out.println(isAnagrams(str1, str2));
		
		str1 = "";
		str2 ="";
		System.out.println(isAnagrams(str1, str2));
		
		str1 = "";
		str2 ="a";
		System.out.println(isAnagrams(str1, str2));
		
		str1 = "abcbbd";
		str2 ="abcbd";
		System.out.println(isAnagrams(str1, str2));
	}
}