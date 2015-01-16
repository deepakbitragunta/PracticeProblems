package programs;

public class Duplicates {

	public static void findDuplicates(int a[], int k) {
		int n = a.length;
		
		for(int i = 0; i < n; ++i) {
			a[a[i] % k] = a[a[i] % k] + k;
		}
		for(int i = 0; i < n; ++i) {
			if(a[i] < k) {
				System.out.println(i);
			}
		}
	}
	public static void main(String args[]) {
		int a[] = {2, 12, 5, 6,12, 8, 15, 7, 0, 9, 8, 7, 2, 8, 9, 8, 11, 12};
		findDuplicates(a, 15);
	}
}