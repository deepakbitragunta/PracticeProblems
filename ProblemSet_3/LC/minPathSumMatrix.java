public class minPathSumMatrix {
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 ) {
            return 0;
        }
        int m = grid.length; 
        int n = grid[0].length;
        
        int base[][] = new int[m][n];
      
        base[0][0] = grid[0][0];
        
        for(int i = 1; i < m; ++i)  {
            base[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for(int j = 1; j < n; ++j)  {
            base[0][j] = grid[0][j] + grid[0][j - 1];
        }
        
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                base[i][j] = grid[i][j] + Math.min(base[i - 1][j], base[i][j - 1]);
            }
        }
       
        return base[m - 1][n - 1];
    }
    
    public static void main(String args[]) {
    	int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
    	System.out.println(minPathSum(grid));
    }

}