package programs;

public class ShiftZeros {

	public static int [] shift(int a[]) {
		int n = a.length;
		int i = 0;
		int count = 0;
		
		while(i < n) {
			if(a[i] != 0) {
				a[count] = a[i];
				count++;
			}
			++i;
		}
		
		while(count < n) {
			a[count] = 0;
			count++;
		}
			
		return a;
	}
	
	public static void main(String args[]) {
		int a[] = {1, 0, 0, 3, 0, 5,7, 0, 0 , 0 ,3, -1, 0, 5, -10, 11};
		a = shift(a);
		for(int i = 0; i < a.length; ++i) 
			System.out.println(a[i]);
	}
}