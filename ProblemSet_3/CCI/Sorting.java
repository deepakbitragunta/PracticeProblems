import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
	
	static  int a[] = {12, 5, 6, 20, -2, 5};
	static  int b[] = new int[a.length];
	public static void bubbleSort(int a[]) {
		for(int i = 0; i < a.length - 1; ++i) {
			for(int j = 0; j < a.length - i - 1; ++j) {
				if(a[j] > a[j + 1]) {
					a[j] = a[j] + a[j + 1];
					a[j + 1] = a[j] -a[j + 1];
					a[j] = a[j] - a[j + 1];
				}
			}
		}
	}
	public static void selectionSort(int a[]) {
		int small, small_index = 0;
		
		for(int i = 0; i < a.length; ++i) {
			small = a[i];
			for(int j = i; j < a.length; ++j) {
				if(a[j] <= small)  {
					small = a[j];
					small_index = j;
				}	
			}
			a[small_index] = a[i];
			a[i] = small;			
		}
	}
	public static void mergeSort(int a[], int l,  int r) {
		if(l < r) {
			int mid = l + (r - l) / 2;
			mergeSort(a, l, mid);
			mergeSort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}
	public static void merge(int a[], int l, int m, int r) {
		int i = 0, j = 0, k = 0;
		int b[] = new int[a.length];
		
		for(i = l; i <= r; ++i) {
			b[i] = a[i];
		}
		i = l;
		j = m + 1;
		k = l;
		
		while(i <= m && j <= r) {
			if(b[i] <= b[j]) {
				a[k] = b[i];
				i++;
				k++;
			}
			else {
				a[k] = b[j];
				j++;
				k++;
			}
			
		}
		// just copy left, the right will not change
		while(i <= m) {
				a[k] = b[i];
				i++;
				k++;
		}
	}
	
	public static void quickSort(int a[]) {
		if(a == null || a.length == 0) return;
		quickSort(a, 0, a.length - 1);
	}
	
	public static void quickSort(int a[], int l, int r) {
		int i = l, j = r;
		
		int pivot = a[(l + ( r - l) / 2)];
		
		while(i <= j) {
			while(a[i] < pivot) {
				++i;
			}
			while(a[j] > pivot) {
				--j;
			}			
			
			if(i <= j) {
				swap(a, i , j);
				++i;
				--j;
			}
		}	 // end of while
		// left half
		if(l < j)  {
			quickSort(a, l, j);
		}
		// right half
		if(i < r)  {
			quickSort(a, i, r);
		}		
	}
	public static void swap(int a[], int i, int j) {			
		int temp = a[i];
		a[i] =  a[j];
		a[j] =temp;
	}
	
	public static void bucketSort(int a[], int n) {
	
		ArrayList<Integer> buckets[] = new ArrayList[n];
		
		int high = 0;
		int low = 0;
		
		for(int i = 0; i < a.length; ++i) {
			if(low > a[i]) low = a[i];
			if(a[i] > high) high = a[i];
		}
		
		double interval = ((double) (high - low + 1) )/ n; // range of one bucket
		for(int i = 0; i < n; ++i) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < a.length; ++i) {
				buckets[ (int) ((a[i] - low) / interval)].add(a[i]);
		}
		
		int k = 0;
		for(int i = 0; i < buckets.length; ++i) {
			Collections.sort(buckets[i]); // merge sort
			for(int j = 0; j < buckets[i].size(); ++j) {
				a[k] = buckets[i].get(j);
				++k;
			}
		}
		
	}
	public static void main(String args[]) {
		int a[] = {12, 5, 20, 6, -2, 25, 5};
		//	bubbleSort(a);
		//	selectionSort(a);
		//  mergeSort(a, 0, a.length - 1);
		quickSort(a);
		//	bucketSort(a, 25);
				
		for(int i = 0; i < a.length; ++i) 
			System.out.println(a[i]);
	}
}