public class ReverseSpiralTraversal {
	
	public static void traverseSpiral(char [][]matrix) {
		int size = matrix.length;
		int level = 0;
		
		int levelstop;
		
		if(size % 2 == 0) { levelstop = size / 2; }
		else { levelstop = size / 2 + 1; }

		while( level <= levelstop) {
			int msize = size - 1 - level;
	
			for(int i = msize; i > level; --i) {
				System.out.print(matrix[level][i]);
  		}
			for(int i = level ; i < msize; ++i) {
				System.out.print(matrix[i][level]);
  		}
			for(int i = level; i < msize; ++i) {
				System.out.print(matrix[msize][i]);
  		}
			for(int i = msize; i > level; --i) {
				System.out.print(matrix[i][msize]);
  		}
			level++;
	   }	 	
	}
	
/*public int largest_contiguous_subarray(int a[]) {

	int max_sum_here = 0;
	int begin = 0; int end =0;
	int current = 0, max_sum, start_index = 0;
	int l = 2;

	for(int i = 0; i < l; ++i) {
		max_sum_here += a[i];
	}
	
	current = max_sum_here;
	max_sum = current;

	for(int i = l; i < a.length; ++i) {
		max_sum_here += a[i] - a[i - l];

		if(max_sum_here > current + a[i]) {
			current = max_sum_here;
			start_index = i - l + 1;
		}
		else{
			current += a[i];
	}
		if(max_sum < current) {
			max_sum = current;
			begin = start_index;
			end = i;
		
	}
}*/

//}

 public static void main(String args[]) {
	char[][] characterArray = { {'C', 'I', 'P', 'E'}, {'R', 'N', 'K', 'U'}, {'U', 'O', 'W', 'O'}, {'L', 'E', 'S', 'Y'}, {'T', 'H', 'I', 'E'}}; 
	traverseSpiral(characterArray);
 } 
	
}