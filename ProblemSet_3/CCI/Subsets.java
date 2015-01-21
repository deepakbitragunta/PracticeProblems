import java.util.ArrayList;

public class Subsets {
	
	public static ArrayList<ArrayList<Integer>> generateSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>> ();
		
		if(set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		}
		else {
			allsubsets = generateSubsets(set, index + 1);
			int item = set.get(index);
			
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets) {
					ArrayList<Integer> newSubset = new ArrayList<Integer>();
					newSubset.addAll(subset);
					newSubset.add(item);
					moreSubsets.add(newSubset);
			}
			
			allsubsets.addAll(moreSubsets);
		}
		return allsubsets;
	}
	
	public static ArrayList<ArrayList<Integer>> generateSubsets(ArrayList<Integer> set) {
	
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>> ();
			
		int max = (1 << set.size());
		
		for(int i = 0; i < max; ++i) {
		
			ArrayList<Integer> subset = new ArrayList<Integer> ();
			
			int k = i;
			int index = 0;
			while(k > 0){
				if((k & 1) > 0) {
					subset.add(set.get(index));
				}
				
				k = k >> 1;
				index++;				
			}
			allsubsets.add(subset);
		}
		return allsubsets;
	}
		
	public static void main(String args[]) {
		ArrayList<Integer> set = new ArrayList<Integer>();
	
		for(int i = 1; i <= 5; ++i)
			set.add(i);	
			
		ArrayList<ArrayList<Integer>> temp = generateSubsets(set, 0);
		
		for(ArrayList<Integer> t : temp) {
			System.out.println(t.toString());
		}
		System.out.println("Using binary");
		ArrayList<ArrayList<Integer>> temp2 = generateSubsets(set);
		
		for(ArrayList<Integer> t : temp2) {
			System.out.println(t.toString());
		}
	}
}