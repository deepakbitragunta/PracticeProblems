import java.util.ArrayList;

public class PrintParanthesis {

	public static void printParens(int l, int r, char str[], int count) {
			if(l < 0 || r < 0) return;
			
			if( l == 0 && r == 0) {
				System.out.println(str);	
			}
			else {
					// still we have left parenthesis
					if( l > 0){
						str[count] = '(';
						printParens(l - 1, r, str, count + 1);
					}			
					if( r > l){
						str[count] = ')';
						printParens(l, r - 1, str, count + 1);
					}
			}
	}
	/*
	public static ArrayList<String> printPairs(String s, ArrayList<String> all, int index, int n) {
		
		if(all.size() == 0) {
			for(int i = 0; i < n; ++i) 
				s += "()";			
			all.add(s);
		}
		if(index >= s.length()) {
			return null;
		}
		String temp = "";
		if(s.indexOf(")(") >= index) {
			temp = s.substring(0, index);
			temp += "()";
			temp += s.substring(index + 2);	
			all.add(temp);
		}	
		ArrayList<String> list = printPairs(temp, all, index + 2, n);
		System.out.println(list);
		return (list == null) ? all : list;
	} */
	
	public static void main(String args[]) {
		 printParens(3, 3, new char[3 * 2], 0);

	}

}