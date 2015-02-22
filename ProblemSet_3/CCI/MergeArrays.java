public class MergeArrays {
	
	public static void merge(int a[], int b[], int n, int m) {
	
	int i, j ;
	
	int k = m + n - 1;
		
	if(a.length < k) return;
	
	// comapre and merge from the end of arrays
		i = n - 1;
		j = m - 1;
		
		while(i >= 0 && j >= 0) {
			if(b[j] > a[i]){
				a[k] = b[j];
				j--;
			}
			else {
				a[k] = a[i];
				i--;
			}
			k--;	
		}
		while(j >= 0) {
			a[k] = b[j];
			k--;
			j--;
		}
	}
	
	public static void main(String args[]) {
	int a[] = new int [20];
	int b[] = { 2, 6, 8, 10, 12, 20};
	
	for(int i = 0, k = 0; i < 10; ++i) {
		if(i % 2 == 1)  {
			a[k] = i;
			k++;
		}	
	}
	merge(a, b, 5, 6);
	for(int i = 0; i < 11; ++i) 
		System.out.println(a[i]);
 }
}