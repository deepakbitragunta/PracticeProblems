public class replaceSpace {
	
	public static String substituteSpace(String str) {
		if(str == null || str.length() == 0) return str;
		
		char [] chars = str.toCharArray();
		StringBuilder modified = new StringBuilder();
		
		for(int i = 0; i < chars.length; ++i) {
			if(chars[i] == ' ') {
				modified.append("%20");
			}
			else {
				modified.append(chars[i]);
			}
		}
		return modified.toString();
	}

	public static void main(String args[]) {		
		String s = " a b c d ", s1 = "  ", s2 = "", s3 = null, s4 = "abcde  ", s5 = "  ; ", s6 = " ";
		
		System.out.println(substituteSpace(s));
		System.out.println(substituteSpace(s1));
		System.out.println(substituteSpace(s2));
		System.out.println(substituteSpace(s3));
		System.out.println(substituteSpace(s4));
		System.out.println(substituteSpace(s5));
		System.out.println(substituteSpace(s6));
	}
}