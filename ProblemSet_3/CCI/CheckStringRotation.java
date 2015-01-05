import java.util.LinkedList;

public class CheckStringRotation {

	public static boolean isSubstring(String s1, String s2) {
		return s2.contains(s1);
	}
	// check s1 is rotation of s2	
	public static boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length() || s1.length() == 0) return false;
		
		String temp = s2 + s2;
		return isSubstring(s1, temp);
	}
	public static void main(String args[]) {
	
		String s1 = " " , s2 = "";
		System.out.println(isRotation(s1, s2));
	}
	
}