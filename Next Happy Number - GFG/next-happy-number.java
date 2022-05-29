// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{

   static int nextHappy(int N){
       
       // code her
       int n=N+1;
       int f=N+2;
       while(n<f)
       {
           boolean res=false;
           int fast=n;
           int slow=n;
           do
           {
               slow=square(slow);
               fast=square(square(fast));
           }while(slow!=fast);
           
           if(slow==1)return n;
           n++;
           f++;
           
       }
       return 0;
       
   }
   static int square(int n)
   {
       int ans=0;
       while(n>0)
       {
           int temp=n%10;
           ans=ans+(temp*temp);
           n=n/10;
       }
       return ans;
   }
}

