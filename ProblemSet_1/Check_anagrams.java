public class Check_anagrams {

	public static void check_Valid_anagrams(char [] a, char []  b) {
		int i = 0, j = 0;
		int n = a.length;
		char temp;
		if(a.length != b.length) { System.out.println("Invalid input"); };
		
		while(i < n) {
			j = i;
			while(a[i] != b[j]) {
				++j;
			}
			
			while(j > i) {
			
				temp = b[j - 1];
				b[j - 1] = b[j];
				b[j] = temp;
				--j;
			}
			System.out.println(b[i]);
			++i;
		}	
	}

	public static void main(String args[]) {
	
		char a[] = {'s', 'i', 'l', 'e', 'n', 't'};
		char b[] = {'l', 'i', 's', 't', 'e', 'n'};
		check_Valid_anagrams(a, b);
		
	}
}