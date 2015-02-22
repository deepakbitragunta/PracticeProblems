public class UniqueBinaryTrees {

	public static int numOfUniqueTrees(int n) {
	
		int trees[] = new int[n + 1];
		
		trees[0] = 1;
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 0; j < i; ++j) {
				trees[i] = trees[i] + trees[j] + trees[i - j - 1];
			}
		}
		
		return trees[n];
	}
	
	public static void main(String args[]) {
		System.out.println(numOfUniqueTrees(3));
	}
}