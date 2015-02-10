public class OneEditDistance {

	public static boolean checkOneDistance(String s, String t) {
		int m = s.length();
		int n = t.length();
		
		if(m > n) return checkOneDistance(t, s);
		
		if(n - m > 1) return false;
		
		int i = 0, shift = n - m;
		
		while(i < m && s.charAt(i) == t.charAt(i)) i++;
		
		if(i == m) return shift > 0;
		
		if(shift == 0) i++;
		while(i < m && s.charAt(i) == t.charAt(i + shift)) i++;
		
		return i == m;	
	}
	
	public static void main(String args[]) {
		String s = "abdc";
		String t = "bbdca";
		
		System.out.println(checkOneDistance(s, t));
	}
}