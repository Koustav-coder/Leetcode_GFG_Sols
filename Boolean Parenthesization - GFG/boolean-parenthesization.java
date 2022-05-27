// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod = 1003;
    static int memo(int i, int j, int isTrue, String s, int[][][] dp) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue == 1) {
                if (s.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        int ways = 0;

        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            int lt = memo(i, ind - 1, 1, s, dp);
            int lf = memo(i, ind - 1, 0, s, dp);
            int rt = memo(ind + 1, j, 1, s, dp);
            int rf = memo(ind + 1, j, 0, s, dp);

            if (s.charAt(ind) == '&') {
                if (isTrue == 1) {
                    ways += ((lt * rt) % mod) % mod;
                } else {
                    ways += ((lt * rf) % mod + (rt * lf) % mod + (lf * rf) % mod) % mod;
                }
            } else if (s.charAt(ind) == '|') {
                if (isTrue == 1) {
                    ways += ((lt * rf) % mod + (lt * rt) % mod + (lf * rt) % mod) % mod;
                } else {
                    ways += ((lf * rf) % mod) % mod;
                }
            } else if (s.charAt(ind) == '^') {
                if (isTrue == 1) {
                    ways += ((lt * rf) % mod + (lf * rt) % mod) % mod;
                } else {
                    ways += ((lf * rf) % mod + (lt * rt) % mod) % mod;
                }
            }
        }

        return dp[i][j][isTrue] = ways % mod;
    }
    
    static int countWays(int n, String s){
        // code here
        int[][][]dp = new int[n+1][n+1][2];
        
        for(int[][] row1: dp){
            for(int[]row2 : row1){
                Arrays.fill(row2, -1);
            }
        }
        
        return memo(0, n-1, 1, s, dp);
    }
}