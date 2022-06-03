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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    static int mod=1000000007;
    
    static int f(int ind,int sum,int arr[],int dp[][]){
          if (ind == 0) {
            if (sum == 0 && arr[0]==0)  return 2;
            if(sum==0 || sum==arr[0])  return 1;
            return 0;
        }
        if(dp[ind][sum]!=-1)return dp[ind][sum];
        
        int notake=f(ind-1,sum,arr,dp)%mod;
        int take =0;
        
        if(arr[ind]<=sum) take=f(ind-1,sum-arr[ind],arr,dp)%mod;
        
        return dp[ind][sum]=(take+notake)%mod;
    }

	public static int perfectSum(int arr[],int n, int sum) 
	{ 
	    int dp[][]=new int[n][sum+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        	    
	    return f(n-1,sum,arr,dp) %mod;
	} 
}