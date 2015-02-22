public class ShuffleDeckOfCards {
	
	public static void doShuffle (int a[]) {
		int index;
		int max = a.length;
		
		for(int i = 0; i < max; ++i) {
			int min = i;
			index = min +	(int) (Math.random() * (max - min));
			 a[index] = a[index] ^ a[i];
			 a[i] = a[index] ^ a[i];
			 a[index] = a[index] ^ a[i];		
		}
	}
	
	public static void main(String args[]) {
		int a[] = new int[52];
		for(int i = 0; i < 52; ++i){
			a[i] = i;
		}
		doShuffle(a);
		for(int i = 0; i < 52; ++i){
			System.out.println(a[i]);
		}
	}
}