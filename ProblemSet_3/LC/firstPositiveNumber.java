public class firstPositiveNumber {
    public static int firstMissingPositive(int[] A) {
        int i = 0, n = A.length;
        while(i < n) {
            if(A[i] != i + 1 && A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
               /* A[i] = A[i] ^ A[A[i] - 1];
                A[A[i] - 1] = A[i] ^ A[A[i] - 1];
                A[i] = A[i] ^ A[A[i] - 1]; */
            } else {
                i++;
            }
        }
                
        for(i = 0; i < n; ++i) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
		public static void main(String args[]) {
			int a[] = {2, 1};
			System.out.println(firstMissingPositive(a));
		}
}