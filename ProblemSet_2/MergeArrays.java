package programs;

public class MergeArrays {

	static int  no_value = -1;
	
	public static int [] movetoEnd(int b[]) {
		int n2 = b.length;
		int i , j = n2 - 1;
		for(i = n2 - 1; i >= 0; --i) {
			if(b[i] != no_value) {
				b[j] = b[i];
				--j;
			}
		}
		return b;
	}
	
	public static int[] mergeArray(int a[], int b[]) {
		
		int n = a.length;
		int n2 = b.length;
		int i = n, j = 0, k = 0;
		
			while(k < n2) {
				if( i < n2 && (j == n) || (b[i] <= a[j])) {
					b[k] = b[i];
					i++;
				}
				else {
					b[k] = a[j];
					j++;
				}
				++k;
			}
		return b;
	}
	public static void main(String args[]) {
		int a[] = {1,4,5,11,18,22,55};
		int b[] = {2, -1, 6, -1, 12, -1, 16, -1, 22, -1, -1, -1, 55,67,89};
		
		int changed_b[] = movetoEnd(b);		
		int c[] = mergeArray(a, changed_b);
		
		for(int i = 0; i < c.length; ++i)
			System.out.println(c[i]);
	}

}