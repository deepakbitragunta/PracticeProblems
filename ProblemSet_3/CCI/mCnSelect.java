public class mCnSelect {
	
	public static int rand(int min, int max) {
		return (int) Math.random() * (max - min + 1) + min;		
	}
	public static int [] selectElements(int a[], int m) {
		int subset[] = new int[m];
		int index;
		
		for(int j = 0; j < m; ++j) {
			index = rand(j, a.length);
			subset[j] = a[index];
			a[index] = a[j]; // dead elements are pushed to start of array
		}
		return subset;
	}
	public static void main(String args[]) {
		int a[] = {3, 5, 4, 5, 29, 2, 22, 5, 22};
		int b [] = selectElements(a, 4);
		for(int i = 0; i < b.length; ++i) {
			System.out.println(b[i]);
		}
	}
}