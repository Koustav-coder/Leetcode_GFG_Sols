// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}// } Driver Code Ends


//User function Template for Java

class Solution
{
   //Function to find length of shortest common supersequence of two strings.
   public static int lcs(String s1,String s2,int m,int n)
   {
       int[][] dp = new int[m+1][n+1];
       for(int i=1;i<m+1;i++){
           for(int j=1;j<n+1;j++){
               if(s1.charAt(i-1)==s2.charAt(j-1)){
                   dp[i][j]=1+dp[i-1][j-1];
               }
               else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
           }
       }
       return dp[m][n];
   }
    public static int shortestCommonSupersequence(String s1,String s2,int m,int n){
        return (m+n)-lcs(s1,s2,m,n); //only diff from lcs is here
    }
}