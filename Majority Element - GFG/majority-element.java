// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
   static int majorityElement(int arr[], int size)
   {
       // your code here
       
       HashMap<Integer, Integer> hm = new HashMap<>();
       
       for(int i=0; i<size; i++){
           
           hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
           
           if(hm.get(arr[i])>size/2) return arr[i];
       }
       
       return -1;
   }
}