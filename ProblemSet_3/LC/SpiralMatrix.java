import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

 public class SpiralMatrix {
		public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0) return res;
        
        int n = matrix[0].length, offset = 0, first = 0, last = 0, level;
        

        for(level = 0; level < m / 2; ++level) {
           
            first = level;
            last = n - level - 1;
            // top
            for(int i = first; i < last; ++i) {
                offset = i - first;
                res.add(matrix[first][i]);
            }
            first = level;
            last = m - level - 1;
            // right
             for(int i = first; i < last; ++i) {
                offset = i - first;
                res.add(matrix[i][last]);
            }
            first = level;
            last = n - level - 1;
            //bottom
             for(int i = first; i < last; ++i) {
                offset = i - first;
                res.add(matrix[last][last - offset]);
            }
            first = level;
            last = m - level - 1;
            //left
             for(int i = first; i < last; ++i) {
                offset = i - first;
                res.add(matrix[last-offset][first]);
            }
        }
        if(m == n && m % 2 != 0) {
            res.add(matrix[level][level]);
        }
        return res;
    }
		
		public static void main(String args[]) {
			int a[][]= { {1}, {1}};
			System.out.println(spiralOrder(a).toString());
		}
}		