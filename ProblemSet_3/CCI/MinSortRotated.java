public class MinSortRotated {
    public int findMin(int[] a) {
        int n = a.length;
        int low = 0, high = n - 1;
        int min = a[low];
        
        while(a[low] > a[high]) {
            int mid = low + (high - low) / 2;
            if(a[low] <= a[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return a[low];
    }
}