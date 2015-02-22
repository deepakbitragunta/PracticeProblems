public class MissingNumber {

	
	public static int  findMissingOne(int a[], int n) {
		int xor1 = 0;
		int xor2 = 0, i;
		for(i = 0; i < a.length; ++i){
			xor1 ^= a[i]; 
		}	
		for(i = 1; i <= n; ++i){
			xor2 ^= i; 
		}
		return xor1 ^ xor2;
	}
	
	public static String findMissingTwo(int a[], int n) {
		int x = 0, p = 0, q = 0;
		int i;
		for(i = 0; i < a.length; ++i){
			x ^= a[i]; 
		}	
		for(i = 1; i <= n; ++i){
			x ^= i; 
		}
		//find the leftmost bit that is different 
		x = x & ~(x - 1);
		
		for( i =0 ;i < a.length; ++i) {
			if((a[i] & x) == x) {
				p ^= a[i];
			} else {
				q ^= a[i];
			}
		}
		for( i =1 ;i <= n; ++i) {
			if((i & x) == x) {
				p ^= i;
			} else {
				q ^= i;
			}
		}
		return p + ", " + q;
	}
	
	public static void main(String args[]) {
		int a[] = {1, 2, 5, 4, 6, 7, 8, 9, 10};
		int index = findMissingOne(a, 10);
		System.out.println(index);
		System.out.println(findMissingTwo(a, 10));
	}

}
