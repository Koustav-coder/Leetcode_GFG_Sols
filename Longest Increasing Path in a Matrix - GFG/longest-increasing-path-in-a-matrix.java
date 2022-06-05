// { Driver Code Starts
// Initial Template for Java

import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.longestIncreasingPath(arr, n, m));
            t--;
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    /*You are required to complete this method*/
    int[][]direction = {{0,1},{1,0}, {0,-1}, {-1, 0}};

     int dfs(int i, int j, int n, int m, int[][]arr, int[][]dp){
        int max=0;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        for(int[] dir : direction){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x<0 || y<0 || x>=n || y>=m || arr[x][y] <= arr[i][j]){
                continue;
            }

            int len = 1 + dfs(x, y, n, m, arr, dp);

            max = Math.max(max, len);
        }

        return dp[i][j] = max;
    }
    
    int longestIncreasingPath(int arr[][], int n, int m) {
        // Code here
        
        int max=0;
        
        int[][]dp = new int[n][m];
        
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int len = dfs(i,j,n,m,arr, dp);

                max = Math.max(max, len);
            }
        }
        return max+1;
    }
}