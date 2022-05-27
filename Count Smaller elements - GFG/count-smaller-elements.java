// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    int[] constructLowerArray(int[] arr, int n) {
        // code here
        int[] ar = new int[n];
           int count = 0;
           
          for(int i=0;i<n-1;i++)
          {
              for(int j=i+1;j<n;j++)
          {
              if(arr[i]>arr[j])
              {
                  count++;
              }
          }
          ar[i]=count;
          count=0;
          }
 
       return ar;
    }
}