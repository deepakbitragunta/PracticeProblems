public class generate_numbers{

	public static void print_numbers(int base_num, int n) {
		
		int lastDigitUsed =(int) (base_num / Math.pow(10,n))%10;
		for(int i=lastDigitUsed+1; i< 10;i++)
		{
			int temp = (int) (base_num + i*(Math.pow(10, n-1)));
			if(n == 1)
				System.out.println(temp);
			else 
				print_numbers(temp, n - 1);
		}	
	}
	public static void main(String args[]) {
		print_numbers(0, 3);
	}

}