public class NextBitNumbers {
	public static boolean getBit(int n, int index) {
		return (n & (1 << index)) > 0; 
	}
	public static int setBit(int n, int index, boolean value) {
		if(value) {
			return n | (1 << index);
		}else {
			int mask = ~(1 << index);
			return n & mask;
		}
	}
	
	public static int getNextNumber(int n) {
		if(n <= 0) return -1;
		int index = 0;
		// get the first 1 index
		while(!getBit(n, index)) { 
			index++;
		}
		int countOnes = 0;
		// find the first zero from the index		
		//count the number of ones : countOnes
		while(getBit(n, index)) {
			index++;
			countOnes++;
		}
		
		//set it to one
		n = setBit(n, index, true);
		
		// decrement index
		//set the bit to zero
		// decrement countOnes
		index = index - 1;
		n = setBit(n, index, false);
		countOnes--;
		
		
		// We are done with setting the left most bit for larger value 
		// Now, rearrange the right bits to form the smallest number greater than given number by shifting right
		// set all to zero till index >= countOnes
		for(int i = index - 1; i >= countOnes; --i) {
			n = setBit(n, i, false);
		}
		
		// countones - 1 to index zero, set all to ones
		for(int i = countOnes - 1; i >= 0; --i) {
			n = setBit(n, i, true);
		}
		return n;
	}
	
	public static int getPrevNumber(int n) {
		if(n <= 0) return -1;
		
		int index = 0;
		// get the first 0 index
		while(getBit(n, index)) { 
			index++;
		}
		int countZeros = 0;
		// find the first one from the index		
		//count the number of zeros : countZeros
		while(!getBit(n, index)) {
			index++;
			countZeros++;
			
		}
		
		//set it to zero
		n = setBit(n, index, false);
		
		// decrement index
		//set the bit to zero
		// decrement countZeros
		index = index - 1;
		
	
		n = setBit(n, index, true);
		countZeros--;
		
		
		// We are done with setting the left most bit for smaller value 
		// Now, rearrange the right bits to form the largest number less than given number by shifting left
		// set all to one till index >= countZeros
		for(int i = index - 1; i >= countZeros; --i) {
			n = setBit(n, i, true);
		}
		
		// countZeros - 1 to index zero, set all to zeros
		for(int i = countZeros - 1; i >= 0; --i) {
			n = setBit(n, i, false);
		}
		
		return n;
	}
	
	public static void main(String args[]) {
		int n = 31;
		System.out.println("Previous Number: " + getPrevNumber(n));
		System.out.println("Number: " + n);
		System.out.println("Next Number: " + getNextNumber(n));
	}
	
}