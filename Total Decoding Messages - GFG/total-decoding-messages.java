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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   public int CountWays(String s)
   {
       int n=s.length();
       if(n==0||s.charAt(0)=='0') return 0;
       if(n==1) return 1;
       int count1=1;//previous to previous pointer
       int count2=1;//previous pointer
       for(int i=1;i<n;i++)
       {
           int d=s.charAt(i)-'0';
           int dd=(s.charAt(i-1)-'0')*10+d;
           int count=0;
           if(d>0) count+=count2;
           if(dd>=10&&dd<=26)  count+=count1;
           count1=count2%1000000007;
           count2=count%1000000007;
           
       }
       return count2;
   
}
}