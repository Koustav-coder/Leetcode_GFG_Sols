// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String S) {
       // code here
       int mod = 1000000007;
       int n = S.length();
       long [] dp = new long[n + 1];
       
       dp[0] = 1;
       HashMap<Character, Integer> lo = new HashMap<>();
       
       for(int i=1; i < dp.length; i++){
           dp[i] = (2 * dp[i-1]) % mod;
           char ch = S.charAt(i-1);
           
           if(lo.containsKey(ch)){
               int j =  lo.get(ch);
               dp[i] = (dp[i] - dp[j-1] + mod) % mod;
           }
           lo.put(ch, i % mod);
           
       }
       return (int)(dp[n] % mod);
       
       
   }
}