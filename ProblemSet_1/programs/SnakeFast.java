
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SnakeFast {
   
    static int[][] A;
    static int[][] S;
    static boolean[][] output;
    static int n,m;
    static int maxLength;
   
    static class Coord {
        int x,y;
        Coord(int x, int y) {this.x = x; this.y = y; }
    }
    static Coord snake; // location of cell in snake
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        n = sc.nextInt();
        m = sc.nextInt();
       
        A = new int[n][m];
        S = new int[n][m]; // Length of longest snake ending at i,j
        output = new boolean[n][m];
       
        for (int i = 0; i < n; i++) {
            String sLine = sc.nextLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = sc.nextInt();
            }
        }
       
        // Find cells that are local minima
        Queue<Coord> bfs = new LinkedList<Coord>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isLessThanOrEqualToUnmarkedNeighbors(i,j))
                bfs.add(new Coord(i,j));
            }
        }
       
        // Do BFS from local minima cells
        int maxLength = 0;
        while (bfs.size() > 0) {
            Coord c = bfs.remove();
            if (isLessThanOrEqualToUnmarkedNeighbors(c.x,c.y)) {
                S[c.x][c.y] = 1 + getMaxLengthOfSmallerNeighbors(c.x,c.y);
                if (S[c.x][c.y] > maxLength) {
                    maxLength = S[c.x][c.y];
                    snake = c;
                }
                addUnmarkedNeighbors(c.x,c.y,bfs);
            }
        }
       
        // Mark the output array
        for (int i = 0; i < maxLength; i++)
        markSnakeCell();
       
        // Produce output
        System.out.println(maxLength);
        for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
            if (output[i][j])
            System.out.print(1);
            else
            System.out.print(0);
           
            if (j == m - 1)
            System.out.println();
            else
            System.out.print(" ");
        }
    }
   
    // Return max value in S array for neighbors of cell at x,y
    static int getMaxLengthOfSmallerNeighbors(int x, int y) {
        int max = 0;
        if (x > 0 && A[x-1][y] < A[x][y])
        max = S[x-1][y];
        if (y > 0 && max < S[x][y-1] && A[x][y-1] < A[x][y])
        max = S[x][y-1];
        if (x < n - 1 && max < S[x+1][y] && A[x+1][y] < A[x][y])
        max = S[x+1][y];
        if (y < m - 1 && max < S[x][y+1] && A[x][y+1] < A[x][y])
        max = S[x][y+1];
        return max;
    }
   
    // Add neighbors of cell (x,y) to Q if value in S array is 0
    static void addUnmarkedNeighbors(int x, int y, Queue<Coord> q) {
        if (x > 0 && S[x-1][y] == 0)
        q.add(new Coord(x-1,y));
        if (y > 0 && S[x][y-1] == 0)
        q.add(new Coord(x,y-1));
        if (x < n - 1 && S[x+1][y] == 0)
        q.add(new Coord(x+1,y));
        if (y < m - 1 && S[x][y+1] == 0)
        q.add(new Coord(x,y+1));
    }
   
    // Return true if A[x][y] is less or equal to than 4 adjacent cells in A
    // array for which the S array is 0
    static boolean isLessThanOrEqualToUnmarkedNeighbors(int x, int y) {
        if (x > 0 && S[x-1][y] == 0 && A[x-1][y] < A[x][y])
        return false;
        if (y > 0 && S[x][y-1] == 0 && A[x][y-1] < A[x][y])
        return false;
        if (x < n - 1 && S[x+1][y] == 0 && A[x+1][y] < A[x][y])
        return false;
        if (y < m - 1 && S[x][y+1] == 0 && A[x][y+1] < A[x][y])
        return false;
        return true;
    }
   
    // Mark the snake cell that continues current snake
    static void markSnakeCell()
    {
        if (output[snake.x][snake.y])
        {
            // Find next cell
          /*  if (snake.x > 0 &&
           ( S[snake.x-1][snake.y] + 1 == S[snake.x][snake.y] || S[snake.x-1][snake.y] - 1 == S[snake.x][snake.y])) //&&
           // A[snake.x-1][snake.y] < A[snake.x][snake.y])
            snake.x--;
            else */
           if (snake.x < n - 1 && S[snake.x+1][snake.y] + 1 == S[snake.x][snake.y] || S[snake.x+1][snake.y] - 1 == S[snake.x][snake.y])
          /*  &&  A[snake.x+1][snake.y] < A[snake.x][snake.y]) */
            snake.x++;
           /* else if (snake.y > 0 &&
            S[snake.x][snake.y-1] + 1 == S[snake.x][snake.y] &&
            A[snake.x][snake.y-1] < A[snake.x][snake.y])
            snake.y--;*/
            else if (snake.y < m - 1 &&   S[snake.x][snake.y+1] + 1 == S[snake.x][snake.y] || S[snake.x][snake.y+1] - 1 == S[snake.x][snake.y]) 
            //	&& A[snake.x][snake.y+1] < A[snake.x][snake.y])
            snake.y++;
        }
        output[snake.x][snake.y] = true;
    }
}