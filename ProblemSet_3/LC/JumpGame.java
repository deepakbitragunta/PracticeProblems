public class JumpGame {
    public static boolean canJump(int[] A) {
        if(A == null || A.length == 0) {
            return false;
        }
        
       if(A.length == 1) {
            return true;
        }
        int n = A.length;
        int jumps = 0;
        
        boolean hasPath = false;
        int maxJump = 0;
        int minSteps = 0;
       // int maxJ = 0;
        for(int i = 0; i < n;) {
            hasPath = false;
            for(int j = i; j < i + A[i]; ++j) {
                int jump = j + A[j];
                if(jump >= n - 1) {
                    return true;
                }
                
                if(A[jump] != 0 ) {
                    hasPath = true;
                    if(A[j] >= maxJump) {
                        maxJump = A[j];
                    //    maxJ = j;
                    }
                }
            }
            
            if(hasPath == false) {
                return false;
            }
           
            i = i + maxJump;
            
            
           
            minSteps = minSteps + 1;
            
        }
        return true;
    }
		
		public static void main(String args[]) {
			int a[] = {1,1,2,2,0,1,1};
			
			System.out.println(canJump(a));
		}
	
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) {
            return false;
        }
        
       if(A.length <= 1) {
            return true;
        }
        int n = A.length;
        int maxReach = 0;
        int step = 1;
        int minSteps = 0;
        int nextStep = 0
        for(int i = 0; i < n; ++i) {
            step--;
            if(i + A[i] > maxReach) {
                maxReach = i +  A[i];
                nextStep = A[i];
            }
            
            if(step == 0 && i < A.length - 1)  
                return false;
            else {
                 step = nexStep;
                 minSteps++;
            }
        }         
        return true;
    }
	}
}