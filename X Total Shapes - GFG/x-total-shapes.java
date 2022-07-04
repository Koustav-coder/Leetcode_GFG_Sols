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
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the number of 'X' total shapes.
   public int xShape(char[][] grid)
    {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean vis[][] = new boolean[n][m];
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};
        int count = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 'X' && vis[i][j] == false){
                    DFSRec(grid, vis, i, j, row, col);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void DFSRec(char[][] grid, boolean [][]vis, int rs, int cs, int []row, int []col){
        vis[rs][cs] = true;
        
        for(int i=0; i<4; i++){
            if(isSafe(grid, vis, rs + row[i], cs + col[i], row, col)){
                DFSRec(grid, vis, rs + row[i], cs + col[i], row, col);
            }
        }
    }
    
    private boolean isSafe(char[][] grid, boolean [][]vis, int rs, int cs, int []row, int []col){
        return (rs >= 0 && rs < grid.length && cs >= 0 && cs < grid[0].length && 
                grid[rs][cs] == 'X' && vis[rs][cs] == false);
    }
}