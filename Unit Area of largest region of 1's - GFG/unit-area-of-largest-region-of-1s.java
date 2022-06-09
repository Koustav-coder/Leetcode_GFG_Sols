// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Point{
    int i, j;
    Point(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}
class Solution
{
    //Function to find unit area of the largest region of 1s.
    int row = 0;
    int col = 0;
    public int findMaxArea(int[][] grid)
    {
        // Code here
        row = grid.length;
        col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        
        for(int i = 0 ; i<row; i++)
        {
            for(int j = 0; j<col ; j++)
            {
                if(!visited[i][j] && grid[i][j] == 1)
                maxArea = Math.max(bfsTraversal(grid,visited,i,j),maxArea);
            }
        }
        
        return maxArea;
        
    }
    
    int bfsTraversal(int[][] grid, boolean[][] visited, int i, int j)
    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i,j));
        visited[i][j] = true;
        int count = 0;
        
        while(!q.isEmpty())
        {
            count++;
            Point p = q.poll();
            
            if(isValidMove(p.i+1,p.j) && !visited[p.i+1][p.j] && grid[p.i+1][p.j] != 0)
            {
                visited[p.i+1][p.j] = true;
                q.add(new Point(p.i+1,p.j));
            }
            if(isValidMove(p.i-1,p.j) && !visited[p.i-1][p.j] && grid[p.i-1][p.j] != 0)
            {
                visited[p.i-1][p.j] = true;
                q.add(new Point(p.i-1,p.j));
            }
            if(isValidMove(p.i,p.j+1) && !visited[p.i][p.j+1] && grid[p.i][p.j+1] != 0)
            {
                visited[p.i][p.j+1] = true;
                q.add(new Point(p.i,p.j+1));
            }
            if(isValidMove(p.i,p.j-1) && !visited[p.i][p.j-1] && grid[p.i][p.j-1] != 0)
            {
                visited[p.i][p.j-1] = true;
                q.add(new Point(p.i,p.j-1));
            }
            if(isValidMove(p.i+1,p.j+1) && !visited[p.i+1][p.j+1] && grid[p.i+1][p.j+1] != 0)
            {
                visited[p.i+1][p.j+1] = true;
                q.add(new Point(p.i+1,p.j+1));
            }
            if(isValidMove(p.i+1,p.j-1) && !visited[p.i+1][p.j-1] && grid[p.i+1][p.j-1] != 0)
            {
                visited[p.i+1][p.j-1] = true;
                q.add(new Point(p.i+1,p.j-1));
            }
            if(isValidMove(p.i-1,p.j+1) && !visited[p.i-1][p.j+1] && grid[p.i-1][p.j+1] != 0)
            {
                visited[p.i-1][p.j+1] = true;
                q.add(new Point(p.i-1,p.j+1));
            }
            if(isValidMove(p.i-1,p.j-1) && !visited[p.i-1][p.j-1] && grid[p.i-1][p.j-1] != 0)
            {
                visited[p.i-1][p.j-1] = true;
                q.add(new Point(p.i-1,p.j-1));
            }
        }
        return count;
    }
    boolean isValidMove(int x, int y)
    {
        if(x < 0 || x >= row || y < 0 || y >= col)
        return false;
        else 
        return true;
    }
}