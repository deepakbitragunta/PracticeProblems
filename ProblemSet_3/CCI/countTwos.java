public class countTwos {
	
	public static int countNumber(int n, int d) {
			if(n == 0) {
				return 0;
			}
			int power = 1;
			while(power * 10 < n) {
				power = power * 10;
			}
			
			int first = n / power;
			int rem = n % power;
			
			int nTwos = 0;
			
			if(first > d) nTwos += power; // add 100 twos between 200 and 299
			else if (first == d) {
				nTwos += rem + 1; // number between 200 and 299. Extra one for 200
			}
			
			//count 2's from the remaining digits
			int nTwosOther = first * countNumber(power - 1, d)+ countNumber(rem, d);
			
			return nTwos + nTwosOther;
	}
	// 10 times faster approach
	public static int countIteratively(int n, int d) {
		int count = 0, seenDigits = 0, digit = 0, position = 0, pow10_pos = 1;
		int j = n;
		
		while(j > 0){
			digit = j % 10;
			int pow10_pos_1 = pow10_pos / 10;
			count += digit * position  * pow10_pos_1;
			
			if(digit == d) {
				count +=seenDigits + 1;
			}
			else if (digit > d) {
				count += pow10_pos;
			}
			seenDigits = seenDigits +  pow10_pos * digit;
			pow10_pos *= 10;
			position++;
			j = j / 10;
		}
		return count;
	}
	
	public static void main(String args[]) {
		System.out.println(countNumber(552, 2));
		System.out.println(countIteratively(552, 2));
	
	}


}