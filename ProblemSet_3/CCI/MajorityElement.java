public class MajorityElement {

	// returns index of majority element
	//moore's voting algorithm
	public static int  findCandiate(int a[]) {
		int max_index = 0;
		int count = 1;
		for(int i = 1; i < a.length; ++i){
			if(a[i] == a[max_index]){
				count++;
			} else {
				count--;
			}
			if(count == 0){
				max_index = i;
				count = 1;
			}
		}	
		return max_index;
	}
	
	public static boolean isMajority(int a[], int num) {
		int count = 0;
		for(int i = 0; i < a.length && count <= (a.length / 2); ++i) {
			if(a[i] == num) {
				count++;
			}
		}
		if(count > a.length / 2) 
			return true;
		else 
			return false;
	}
	
	//check majority index
	public static int findMajority(int a[]) {
		int index = findCandiate(a);
		if(isMajority(a, a[index])) {
			return index;
		}
		else {
			return -1;
		}
	}
	
	public static void main(String args[]) {
		int a[] = {3, 5, 3, 6, 3, 8, 3};
		int index = findMajority(a);
		System.out.println(a[index]);
	}

}