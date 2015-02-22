import java.util.Hashtable;

public class wordFrequency {

	public static Hashtable<String, Integer> setUpDict(String text[]) {
		if(text == null) return null;
		
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		
		for(String str : text) {
			int count = 1;
			str = str.toLowerCase();
			if(str.trim() != "") {
				if(table.containsKey(str)) {
					count = table.get(str);
					table.put(str, count + 1);
				}
				else {
					table.put(str, count);
				}
			}	
		}
		
		return table;
	}
	
	// case in-senstive search
	public static int getFrequency(Hashtable<String, Integer> table, String word) {
		if(word == null || table == null) return -1;
		word = word.toLowerCase();
		
		if(table.containsKey(word)) {
				return table.get(word);
		}
		return 0;
	}
	
	public static void main(String args[]) {
		String text[] = {"adaa", "ahaa", "affg", "fdd", "h aa", "", "hAa"};
		String word = "haa";
		Hashtable<String, Integer> dict = setUpDict(text);
		System.out.println(getFrequency(dict, word));
	}

}