import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class seedOfNumber {
	private int num;
	public seedOfNumber(int num) {
		this.num = num;
	}

	public int getproductOfDigits(int num) {
		int rem, product = 1;
		int num_temp = num;
		
		while(num_temp > 0) {
			rem = num_temp % 10;
			product *= rem;
			num_temp = num_temp / 10;
		}
	return product;
	}
	
/*	public void checkSeed(ArrayList<Integer> digits) {
		Iterator<Integer> it = digits.iterator();
		int product = 1;
		
		while(it != null && it.hasNext()) {
			product *= it.next().intValue();
		}
		
		if(product == num) {
			System.out.println("Seeds of number: "  + num);
			
		}
		
		
	}
*/	public void  printSeeds() throws InputMismatchException, Exception{
		
		if(num < 0) {
			throw new  InputMismatchException("The input number can't be negative");
		}
		if(num < 10) {
		 System.out.println("The seeds of the number is" + num);
		 return;
		}
		
		int product = 1;
		
		for(int i = 1; i <= (num * 0.5); ++i) {
			if(num % i == 0) {
			product = getproductOfDigits(i);
				if(num == product) {
					System.out.println(i);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int num;
		
		Scanner input = new Scanner(System.in);
		
		num = input.nextInt();
		
		seedOfNumber seeds = new seedOfNumber(num);
		try{
		seeds.printSeeds();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
