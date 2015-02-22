public class RotatedSortedArray {
	// in case of duplicates, it will take O(n)
	// otherwise O(logn)
	public static boolean findElement(int A[], int target) {
		int l = 0;
     int r = A.length - 1;
     
      while (l <= r) {
        int m = (l + r) >> 1;
        if (A[m] == target) return true; 
        if (A[l] < A[m]) { //left half is sorted
            if (A[l] <= target && target < A[m])
                r = m - 1;
            else
                l = m + 1;
        } else if (A[l] > A[m]) { //right half is sorted
            if (A[m] < target && target <= A[r])
                l = m + 1;
            else
                r = m - 1;
        } else l++;
    }
    return false;
	}
	
	
	public static void main(String args[]) {
		int a[] = {1,3,1,1,1};	
		System.out.println(findElement(a, 3));
	}
}