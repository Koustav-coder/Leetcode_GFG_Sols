// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
        // code here
        int f=-1;
       int s=-1;
       int ans=Integer.MAX_VALUE;
       for(int i=0;i<a.length; i++){
           if(a[i]==x){
                f=i;
           }
           else if(a[i]==y){
               s=i;
           }
           if(s!=-1 && f!=-1){
               int temp= Math.abs(s-f);
               ans= Math.min(temp,ans);
           }
       }

       if(s==-1 || f==-1){
           return -1;
       }

       return ans;
   }
}