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

            new Solution().zigZag(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution {
   void zigZag(int arr[], int n) {
       // code here
       for(int i=1;i<n;i++)
       {
           
           if(i%2!=0)
           {   
               if(arr[i]<arr[i-1])
               {
                   swap(arr,i,i-1);
               }
           }
           else
           {
               if(arr[i]>arr[i-1])
               {
                   swap(arr,i,i-1);
               }   
           }
       }
   }
   void swap(int arr[],int left,int right)
   {
       int temp=arr[left];
       arr[left]=arr[right];
       arr[right]=temp;
   }
}