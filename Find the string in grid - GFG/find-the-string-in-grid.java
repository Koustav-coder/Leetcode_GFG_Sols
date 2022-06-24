// { Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static class pair{
        int i, j;
        pair(int a, int b){
            i = a;
            j = b;
        }
    }
    
    static int N, M;
    public static boolean check(int i, int j){    
        return (i >= 0 && j >= 0 && i < N && j < M);
    }
    
    static int x[] = { -1, 1, 0, 0, 1, -1, 1, -1};
    static int y[] = { 0, 0, 1, -1, -1, 1, 1, -1};
    
    public static boolean DFS(int i, int j, char[][] grid, String word, int length, int charint, String create, int xIncress, int yIncress){
      if(create.length() == length && word.equals(create)) {
                    // System.out.println("-Got here-");
        return true;
      }
      String temp = create;
      if(xIncress == -1218 && yIncress == -1217) {
        for(int a = 0; a < 8; a++){
            int xi = i + x[a];
            int yj = j + y[a];
            
            if(check(xi, yj) && charint < word.length() && word.charAt(charint) == grid[xi][yj]){
                create = temp;
                create += grid[xi][yj];
                // System.out.println(create);
                if(create.length() == length && word.equals(create)) {
                    // System.out.println("Got here");
                    return true;
                }
                if(DFS(xi, yj, grid, word, length, charint+1, create, x[a], y[a]) == true) 
                    return true;
            }
        }
        
      } else {
            int xi = i + xIncress;
            int yj = j + yIncress;
            
            if(check(xi, yj) && charint < word.length() && word.charAt(charint) == grid[xi][yj]){
                create += grid[xi][yj];
                // System.out.println(create+"--");
                if(create.length() == length && word.equals(create)) {
                    // System.out.println("-Got here-");
                    return true;
                }
                if(DFS(xi, yj, grid, word, length, charint+1, create, xIncress, yIncress)) return true;
            } 
      }  
        return false;
    }
    
    public int[][] searchWord(char[][] grid, String word){
        // Code here
        N = grid.length;
        M = grid[0].length;
        // Result = word;
        ArrayList<pair> adj = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                
                if(grid[i][j] == word.charAt(0) && DFS(i, j, grid, word, word.length(), 1, word.charAt(0)+"", -1218, -1217)) {
                    
                    adj.add(new pair(i, j));
                }
            }
        }
        
        // System.out.println(adj);
        
        int[][] ss = new int[adj.size()][2];
        for(int i=0; i<adj.size(); i++){
            int a = adj.get(i).i;
            int b = adj.get(i).j;
            ss[i][0] = a;
            ss[i][1] = b;
        }
        return ss;
    }
}