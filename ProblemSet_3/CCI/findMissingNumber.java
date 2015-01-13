/*import java.util.ArrayList;

public class findMissingNumber {

	public static int findMissingInt(ArrayList<BitInteger> array) {
		return findMissingInt(array, BitInteger.INTEGER_SIZE - 1);
	}
	
	public static int findMissingInt(ArrayList<BitInteger> input, int column) {
		if(column < 0){
			return 0;
		}
		
		ArrayList<BitInteger> oddIndices = new ArrayList<BitInteger>();
		ArrayList<BitInteger> evenIndices = new ArrayList<BitInteger>();
		
		for(BitInteger t : input) {
			if(t.fetch(column) == 0) {
				evenIndices.add(t);
			}
			else {
				oddIndices.add(t);
			}
		}
		if(oddIndices.size() >= evenIndices.size())
			return findMissingInt(evenIndices, column - 1) << 1 | 0;
		else {
			return findMissingInt(oddIndices, column - 1) << 1 | 1;
		}
	
	}
	public static void main(String args[]) {
		ArrayList<BitInteger> oddIndices = new ArrayList<BitInteger>();
	//	findMissingInt(0
	
	}
}*/