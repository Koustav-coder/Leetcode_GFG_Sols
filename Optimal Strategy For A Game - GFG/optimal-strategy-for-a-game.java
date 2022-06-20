// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long memo(int st, int end, int[] arr, long[][]dp) {
        if (st > end) {
            return 0;
        }

        if(dp[st][end] != -1){
           return dp[st][end]; 
        }

        long first = arr[st] + Math.min(memo(st + 1, end - 1, arr, dp), memo(st + 2, end, arr, dp));
        long sec = arr[end] + Math.min(memo(st + 1, end - 1, arr, dp), memo(st, end - 2, arr, dp));

        return dp[st][end] = Math.max(first, sec);
    }
    
    static long countMaximum(int arr[], int n)
    {
        long[][]dp = new long[n+1][n+1];
        
        for(long[] row : dp)
            Arrays.fill(row, -1);
        
        return memo(0, arr.length - 1, arr, dp);
    }
}
