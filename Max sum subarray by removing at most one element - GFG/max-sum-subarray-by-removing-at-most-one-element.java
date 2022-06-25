// { Driver Code Starts
import java.util.*;

import java.lang.Math;
import java.io.*;
class Subarray
{
	public static void main(String[] args)throws IOException
	{
    //     Scanner sc = new Scanner(System.in);
    // 	int t = sc.nextInt();
    
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //taking total testcases
        int t = Integer.parseInt(read.readLine());
    	while(t-->0)
    	{
    	    //taking number of elements
    		int n = Integer.parseInt(read.readLine());
    		int[] a = new int[n];
    		
    		String str[] = read.readLine().trim().split(" ");
    		
    		//inserting elements to the array
    		for(int i = 0;i < n; i++)
    			a[i] = Integer.parseInt(str[i]);
    		
    		Solution g = new Solution();
    		
    		//calling method maxSumSubarray() of 
    		//class GfG
    		System.out.println(g.maxSumSubarray(a , n));
    	}
	}
}// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return maximum sum subarray by removing at most one element.
    public static int maxSumSubarray(int A[], int n)
    {
     //add code here.
     int sum = A[0];
             int max = A[0];
             int skip =A[0];
             for(int i =1;i<n;i++){
                int temp =sum;
                sum += A[i];
                sum = Math.max(sum,A[i]);
                
                skip = Math.max(temp,skip+A[i]);
                
                temp = Math.max(sum,skip);
                
                max = Math.max(temp,max);
                
             }
             return max;
    }
}

