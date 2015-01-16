import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {

	public String sortSingleString(String s) {
		char c[] = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public int compare(String s1, String s2) {
		return sortSingleString(s1).compareTo(sortSingleString(s2));
	}
	public static void main(String args[]) {
		String[] s = {"abc", "aaav", "aaa", "cba", "avaa", "abc", "vvva"};
		Arrays.sort(s, new AnagramComparator());
		for(int i = 0; i < s.length; ++i)
			System.out.println(s[i]);
	}
}