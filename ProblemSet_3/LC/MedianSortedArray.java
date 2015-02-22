public class MedianSortedArray {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        
        if((m + n) % 2 != 0) 
            return (double) findMedianSortedArrays(A, 0, m - 1 , B, 0, n - 1, (m + n) / 2);
        else {
            return  (findMedianSortedArrays(A, 0, m - 1 , B, 0, n - 1, (m + n) / 2) +
                             findMedianSortedArrays(A, 0, m - 1 , B, 0, n - 1, (m + n) / 2 - 1)) * 0.5;
        }       
    }
    
   
    public static int findMedianSortedArrays(int A[], int as, int ae, int B[], int bs, int be, int k) { 
      int alen = ae -as + 1;
      int blen = be - bs + 1;
      
      if(alen == 0) return B[bs + k];
      if(blen == 0) return A[as + k];
      if(k == 0) return A[as] < B[bs] ? A[as] : B[bs];
      
      int amid = (alen * k) / (alen + blen);
      int bmid = k - amid - 1;
      
      amid = as + amid;
      bmid = bs + bmid;
      
      if(A[amid] > B[bmid]) {
          k = k -(bmid - bs + 1);
          ae = amid;
          bs = bmid + 1;
      } else {
          k = k - (amid - as + 1);
          as = amid  + 1;
          be = bmid;
      }
     return findMedianSortedArrays(A, as, ae, B, bs, be, k);
    }
			
		public static void main(String args[]) {
			int a[] = {1, 2};
			int b[] = {1, 2};
			
			System.out.println(findMedianSortedArrays(a, b));
		
		}
}