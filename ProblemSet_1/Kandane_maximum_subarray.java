public class Kandane_maximum_subarray {
	
 public static int max(int a, int b) {
		if( a > b) {
			return a;
		}
		else {
			return b;
		}
  }
 
 /* 
  * Kandade's algorithm without handling the case of all negative numbers in the array
  * public static int [] maximum_sum_subarray(int a[]) {
	
	int max_sum_so_far = 0;
	int max_sum_here = 0;
	int start = 0;
	int end = 0;
	
	for(int i = 1; i < a.length; ++i) {
		max_sum_here += a[i];
		if(max_sum_here <  0) {
			max_sum_here = 0;
		}
		else if (max_sum_so_far < max_sum_here) {
			max_sum_so_far = max_sum_here;
		}
	}
	return max_sum_so_far;
 } 

*/
public static int max_sum_array(int a[], int min_length) {
	int current_sum = 0;
	int max_sum = 0;
	int begin = 0;
	int end = 0;
	int i;
	int max_sum_here = 0, max_start = 0;
	
	for(i = 0; i < min_length; ++i) {
		max_sum_here += a[i];
	}
	
	current_sum = max_sum_here;
	max_sum = current_sum;
	
	for(i = min_length; i < a.length; ++i) {
		max_sum_here += a[i] - a[i - min_length];
		
		if(max_sum_here < current_sum + a[i]) {
			current_sum += a[i];
			max_start = i - min_length ;
		}
		else {
			current_sum = max_sum_here;
			max_start = i - min_length + 1 ;
		}
		

		if(current_sum > max_sum) {
			max_sum = current_sum;
			begin = max_start;
			end = i;
		}			
	}
	System.out.println("beigin" + begin + "end" + end);
	return max_sum;
}	

 /*
  * kandade algorithm handling all negative numbers
  * 
  * public static int maximum_sum_subarray(int a[]) {
		
	int max_sum_so_far = a[0];
	int max_sum_here = a[0];

	for(int i = 1; i < a.length; ++i) {
		max_sum_here = max(a[i], max_sum_here + a[i]);
		max_sum_so_far = max(max_sum_here, max_sum_so_far);
	}
	return max_sum_so_far;
 } */

 
  public static void main (String args[]) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int arr2[] = {-2, -5, 6, -2, -3, 1, 5, -6};
		
		int res = max_sum_array(arr2, 2);
		System.out.println(res);
		/*for(int i = 0; i < res.length; ++i) {
			System.out.println(res[i]);
		}*/
	
	}
}
