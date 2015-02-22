public class maxSum {
	
	public static int findSum(int a[]) {
		int current_sum = 0;
		int max_sum = Integer.MIN_VALUE;
		
		for(int i = 0; i < a.length; ++i) {
			current_sum += a[i];
			if(max_sum < current_sum) {
				max_sum = current_sum;
			} else if( current_sum < 0 ){
				current_sum = 0;
			}
		}	
		
		return max_sum;
	}
	
	public static void main(String args[]) {
		int a[] = {-2, 4, -1, 1, 5, -4, 5, 2, -1, 4};
		System.out.println(findSum(a));	
	}
}