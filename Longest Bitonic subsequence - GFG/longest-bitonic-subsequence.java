// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        // Code here
        int n = arr.length;
        int[]dp1 = new int[n];
        int[]dp2 = new int[n];
        
        for(int i=0; i<n; i++){
            dp1[i] = 1;
            
            for(int prev=0; prev<i; prev++){
                if(arr[prev] < arr[i] && 1 + dp1[prev] > dp1[i]){
                    dp1[i] = 1 + dp1[prev];
                }
            }
        }
        
        for(int i=n-1; i>=0; i--){
            dp2[i] = 1;
            
            for(int prev=n-1; prev>=0; prev--){
                if(arr[prev] < arr[i] && 1 + dp2[prev] > dp2[i]){
                    dp2[i] = 1 + dp2[prev];
                }
            }
        }
        
        int maxi=0;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        
        return maxi;
    }
}