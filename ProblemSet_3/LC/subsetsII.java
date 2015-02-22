import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> sets = new LinkedList<List<Integer>>();
        int n = num.length;
        
        if(n == 0) {
            return sets;
        }
        Arrays.sort(num);
        
        int max = (1 << n);
        for(int i = 0; i < max; ++i) {
            int  k = i;
            List<Integer> set = new LinkedList<Integer>();
            if(k == 0) {
                sets.add(set);
                continue;
            }
            int index = 0;
            while(k > 0) {
               if((k & 1) > 0) {
                   set.add(num[index]);
               }
               k = k >> 1;
               index++;
            }
            sets.add(set);
        }
        return sets;
    }
		public static void main(String args[]) {
				int input[] = {0};
				subsetsWithDup(input);
		}
}