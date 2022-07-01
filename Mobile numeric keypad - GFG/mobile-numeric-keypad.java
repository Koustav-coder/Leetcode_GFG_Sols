// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public long getCount(int n)
	{
	  int paths[][] = {{8,0}, {1,2,4}, {1,2,3,5}, {2,6,3}, {1,4,5,7}, {2,4,5,6,8}, {3,5,9,6}, {4,7,8}, {7,5,8,0,9}, {8,6,9}};
	  long dp[][] = new long[n+1][10];
	  for(int i=1; i<=n; i++){
	      for(int j=0; j<=9; j++){
	          if(i==1)dp[i][j] = 1;
	          else {
	             for(int path : paths[j])
	                dp[i][j] += dp[i-1][path];
	          }
	      }
	  }
	  
	  long ans = 0;
	  for(int j=0; j<10; j++)
	     ans += dp[n][j];
	     
	  return ans;
	}
}