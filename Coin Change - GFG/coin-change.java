// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
   public long count(int S[], int m, int n) {
       long [][]dp=new long [m+1][n+1];
      for(int i=0;i<m+1;i++){
          for(int j=0;j<n+1;j++){
              if(i==0){
                 dp[i][j]=0; 
              }
               if(j==0){
                 dp[i][j]=1; 
              }
          }
      }
      for(int i=1;i<m+1;i++){
          for(int j=1;j<n+1;j++){
             if(S[i-1]<=j){
                 dp[i][j]=dp[i][j-S[i-1]]+dp[i-1][j];
             }else{
                 dp[i][j]=dp[i-1][j];
             } 
          }
      }
      return dp[m][n];
   }
}