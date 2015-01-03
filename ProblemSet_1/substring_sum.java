public class substring_sum {

		public static String findSubstringSum(int a[], int sum) {
			int current_sum = 0;
			int i, j;
			int n = a.length;
			String result = "";
			boolean found = false;
			
			for(i = 0; i < n; ++i) {
				current_sum  = 0;
				for(j = i; j < n; ++j) {
					current_sum += a[j];
					if(current_sum == sum) {
						result += i + "-" + j + "\n";
						found = true;
						break;
					}
					
				}
			//	if(found) break;			
			}
			return result;
		
	}
	
	public static void main(String args[]) {
	
	int a[] = {2,5,6,5,6,8,1,6,2};
	
	int sum = 15;
	System.out.println(findSubstringSum(a, sum));
		
	}
}