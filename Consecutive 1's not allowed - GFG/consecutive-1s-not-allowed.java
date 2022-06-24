// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
   long dp[][];
   private final long MOD = 1000000007;
   long countStrings(int n) {
       dp = new long[n + 1][2];
       for(long[] a : dp) {
           Arrays.fill(a, -1);
       }
       return helper(n, 0);
   }
   
   private long helper(int n, int isPrevOne) {
       
       if(n == 0) {
           return 1;
       }
       
       if(dp[n][isPrevOne] != -1) {
           return dp[n][isPrevOne];
       }
       
       if(isPrevOne == 1) {
           return dp[n][isPrevOne] = helper(n - 1, 0) % MOD;
       }
       else {
           return dp[n][isPrevOne] = (helper(n - 1, 0) % MOD + helper(n - 1, 1) % MOD) % MOD;
       }
       
   }
}