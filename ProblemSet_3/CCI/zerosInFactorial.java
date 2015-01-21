public class zerosInFactorial {
	
	public static int countZeros(int n) {
		if(n < 0) return -1;
		
		int count = 0;
		
		for(int i = 5; (n / i) > 0;i = i * 5)
				count += (n / i);
	
		return count;
	}
	public static void main(String args[]) {
		System.out.println(countZeros(10));
	}
}