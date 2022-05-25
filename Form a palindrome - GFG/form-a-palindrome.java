// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution {
   static int getLCS(String x, String y, int n, int m) {
       int t[][] = new int[n + 1][m + 1];
       for (int i = 0; i < n + 1; i++) {
           for (int j = 0; j < m + 1; j++) {
               if (i == 0 || j == 0)
                   t[i][j] = 0;
           }
       }

       for (int i = 1; i < n + 1; i++) {
           for (int j = 1; j < m + 1; j++) {
               if (x.charAt(i - 1) == y.charAt(j - 1))
                   t[i][j] = 1 + t[i - 1][j - 1];
               else
                   t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
           }
       }

       return t[n][m];
   }

   static int getLPS(String str) {
       String x = str;
       String y = "";
       for (int i = str.length() - 1; i >= 0; i--)
           y += x.charAt(i);

       int lcs = getLCS(x, y, x.length(), y.length());
       return lcs;
   }

   static int countMin(String str) {
       int lps = getLPS(str);
       return str.length() - lps;
   }
}