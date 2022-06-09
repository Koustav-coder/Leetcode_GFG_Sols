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
                    int w = sc.nextInt();
                    int cost[] = new int[n];
                    for(int i = 0;i<n;i++)
                        cost[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minimumCost(cost,n,w));
                }
        }
}    // } Driver Code Ends


class Solution
{
int memo(int i, int w, int[]arr, int[][]dp){
        if(i<0 && w==0){
            return 0;
        }
        
        if(i<0){
            return (int)Math.pow(10,9);
        }
        
        if(dp[i][w]!=-1){
            return dp[i][w];
        }
        
        if((i+1) > w || arr[i] == -1){
            return memo(i-1, w, arr, dp);
        }
        
        int take = arr[i] + memo(i, w-(i+1), arr, dp);
        int not = memo(i-1, w, arr, dp);
        
        return dp[i][w] = Math.min(take, not);
    }
    
	public int minimumCost(int arr[], int n, int w)
	{
	    
	    int[][]dp = new int[n+1][w+1];
	    
	    for(int[]row : dp)
	        Arrays.fill(row, -1);
	    
		return memo(n-1, w, arr, dp);
	}
}