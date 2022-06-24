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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.

    public int[][] nearest(int[][] mat)
   {
       int r = mat.length;
       int c = mat[0].length;
       int max = 100001;
       for (int i = 0; i < r; i++) {
           for (int j = 0; j < c; j++) {
               if (mat[i][j] != 1){ 
                   int top = (i - 1 >= 0) ? mat[i - 1][j] : max;
                   int left = (j - 1 >= 0) ? mat[i][j - 1] : max;
                   mat[i][j] = Math.min(top, left)+1;
               }
           }
       }
       for (int i = r-1; i >= 0; i--) {
           for (int j = c-1; j >= 0; j--) {
               if (mat[i][j] != 1){ 
                   int bottom = (i + 1 < r) ? mat[i + 1][j] : max;
                   int right = (j + 1 < c) ? mat[i][j + 1] : max;
                   mat[i][j] = Math.min(mat[i][j], 1 + Math.min(bottom, right));
               }
           }
       }
       for (int i = 0; i < r; i++) 
           for (int j = 0; j < c; j++) 
               mat[i][j]--;
       return mat;
   }
}