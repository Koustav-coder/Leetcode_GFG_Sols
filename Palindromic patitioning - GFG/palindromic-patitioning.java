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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   static int palindromicPartition(String str)
   {
       int n=str.length();
       boolean dp[][]=new boolean[n][n];
       for(int i=0;i<n;i++){
           dp[i][i]=true;
       }
       for(int i=0;i<=n-2;i++){
           if(str.charAt(i)==str.charAt(i+1)){
               dp[i][i+1]=true;
           }
           else{
               dp[i][i+1]=false;
           }
       }
       for(int i=3;i<=n;i++){
           for(int j=0;j<=n-i;j++){
               int l=j;
               int r=j+i-1;
               dp[l][r]=dp[l+1][r-1] && (str.charAt(l)==str.charAt(r));
           }
       }
       int cut[]=new int[n];
       cut[n-1]=0;
       for(int i=n-2;i>=0;i--){
           if(dp[i][n-1]==true){
               cut[i]=0;
           }
           else{
               int min=Integer.MAX_VALUE;
               for(int j=i+1;j<n;j++){
                   if(dp[i][j-1]==true){
                       min=Math.min(min,cut[j]);
                   }
               }
               cut[i]=min+1;
           }
       }
       return cut[0];
   }
}