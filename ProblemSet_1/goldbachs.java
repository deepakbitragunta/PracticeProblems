import java.util.Scanner;

public class goldbachs {
	
	public static boolean isPrime(int number) {
	
	for(int i = 2; i <= Math.sqrt(number); ++i) {
		if(number % i == 0) {
				return false;
		}
	}
	return true;
}
	
	public static void printPrimePairs(int number) {
	
	if(number > 2 && number % 2 != 0) {
		System.out.println("Invalid number: input even integer > 2");
		return;
	}	
	int range = number / 2 ;
	int second_num;

	for(int i = 2; i <= range ; ++i)
		if(isPrime(i)) {
			second_num = number - i;
			if(isPrime(second_num)) {
				System.out.println("< " + i + ", " + second_num + "> \n");
			}
		}
	}


	public static void main(String args[]){

		System.out.println("Enter the even integer sto check for Goldbachs conjecture: ");
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		System.out.println("List of prime pairs: \n");
		printPrimePairs(number);

	}
}