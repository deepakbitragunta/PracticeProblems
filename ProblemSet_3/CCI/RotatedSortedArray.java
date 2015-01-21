public class RotatedSortedArray {
	// in case of duplicates, it will take O(n)
	// otherwise O(logn)
	public static int findElement(int a[], int key) {
		int l = 0;
		int r = a.length - 1;
		
		while( l <= r) {
			int mid = l + ((r - l) / 2);
			if(key == a[mid]) {
				return mid;
			}
			else if(a[l] <= a[mid]) {
				if(key > a[mid]) {
					l = mid + 1;
				}
				else if(key >= a[l]){
					r = mid - 1;
				}
				else {
					l = mid + 1;	
				}
			}
			else if(key < a[mid]) {
					r = mid - 1;
				}
			else if(key <= a[r]) {
					l = mid + 1;
			}
			else {
					r = mid - 1;
			}
		}
		return -1;
	}
	
	
	public static void main(String args[]) {
		int a[] = {15, 16, 19, 20, 25, 29, 1, 5, 7, 9, 11, 12, 14};	
		System.out.println(findElement(a, 1));
	}
}