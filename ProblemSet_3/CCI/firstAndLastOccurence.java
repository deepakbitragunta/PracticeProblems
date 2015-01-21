public class firstAndLastOccurence {

	public static String findOccurence(int a[], int key) {
			
			int first , last ;
			first = findFirst(a, key);
			if(first == -1) {
				return "Not found";
			}
			last = findLast(a, first, a.length - 1, key);
			return first + ", " + last;
			
	}
	public static int findFirst(int a[], int key) {
		int l = 0, r = a.length - 1;
		while(l <= r) {
		int	mid = l + (r - l) / 2;
		
			if(a[mid] == key && (mid == 0 || a[mid - 1] < key)) {
				return mid;
			}
			else if(a[mid] >= key) {
				r = mid - 1;
			}
			else 
				l = mid + 1;
		}
		return -1;
	}
	public static int findLast(int a[], int l, int r,  int key) {

		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(a[mid] == key && (mid == a.length - 1 || a[mid + 1] > key)) {
				return mid;
			}
			else if(a[mid] <= key) {
				l = mid + 1;
			}
			else 
				r = mid - 1;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		int a[] = { 1, 2, 2, 4, 5, 5, 5, 5, 5, 6, 7, 7, 8, 9, 9};
		System.out.println(findOccurence(a, 5));
	}
	
}