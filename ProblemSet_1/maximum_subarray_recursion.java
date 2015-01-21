public class maximum_subarray_recursion {
	// recursive method
	public static int maximum_subarray(int a[], int l, int r) {	
		
		if (l == r) {
			return a[l];
		}
		int m = l + (r - l) / 2 ;

		return max_3(maximum_subarray(a, l, m), maximum_subarray(a, m + 1, r), maximum_sum(a, l, m, r));
	}
	public static int maximum_sum(int a[], int l, int m, int r) {
		int sum = 0;
		int max_sum1 = Integer.MIN_VALUE;

		for(int i = m; i >= l; --i) {
				sum = sum + a[i];
				if(sum > max_sum1) {
					max_sum1 = sum;
				}
		}

		int max_sum2 = Integer.MIN_VALUE;
		sum = 0;
		for(int i = m + 1; i <= r; ++i) {
				sum = sum + a[i];
				if(sum > max_sum2) {
					max_sum2 = sum;
				}
		}
	 return max_sum1 + max_sum2;
	}
	
	public static int max_3(int a, int b, int c) {
		return max(max(a, b), c);
	}
	
	public static int max(int a, int b) {
		if( a > b) {
			return a;
		}
		else {
			return b;
		}
  }

	public static void main (String args[]) {
		int arr[] = {-2, -5, 6, -2, -3, 1, 5, -6};
		int n = arr.length;
		System.out.println(maximum_subarray(arr, 0, n-1));

	}
}