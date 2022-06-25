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
            String[] S = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.AlternatingaMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   public int AlternatingaMaxLength(int[] nums)
   {
       int flag=0;
       int ans=0;
       int res=0;
       for(int i=1;i<nums.length;i++){
           if(nums[i]>nums[i-1] && flag==0){
               ans++;
               flag=1;
           }
           else if(nums[i]<nums[i-1] && flag==1){
               ans++;
               flag=0;
           }
       }
       flag=0;
       for(int i=1;i<nums.length;i++){
           if(nums[i]<nums[i-1] && flag==0){
               res++;
               flag=1;
           }
           if(nums[i]>nums[i-1] && flag==1){
               res++;
               flag=0;
           }
       }
       return Math.max(ans+1,res+1);
   }
}