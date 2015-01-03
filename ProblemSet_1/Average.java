public class Average {

	public static double calculateAvg(int a[]) {
		double avg = 0;
		int	n = a.length;
		if(n <= 3) return 0;
		int i;
		
		int first_max = a[0],  second_max = a[1], third_max = a[2];
		int sum = first_max + second_max + third_max;
		int count = n;
		
		for(i = 3; i < n; ++i) {
			if(a[i] == 0 ) {
				count--;
				continue;
			}
			sum += a[i];
			if(a[i] > third_max) {
				third_max = a[i];
			}
			if(third_max > second_max) {
				third_max = third_max + second_max;
				second_max = third_max - second_max;
				third_max = third_max - second_max;
			}
			if(second_max > first_max) {
				second_max =  second_max + first_max;
				first_max =  second_max - first_max;
				second_max = second_max - first_max;
			}
			
		}
		System.out.println(first_max);
		System.out.println(second_max);
		System.out.println(third_max);
		System.out.println(sum);
		avg = (double) (sum - (first_max + second_max + third_max)) / (count - 3);

		return avg;
	}
	public static void main(String args[]) {
	
		int a[] = {3, 7, 12, 2, 25, 8, 9, 13, 10, 0};
		System.out.println(calculateAvg(a));
	
	}
}