// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
   String addBinary(String A, String B) {
       // code here
       int lenOfA = A.length();
       int lenOfB = B.length();
       
       int i = lenOfA-1;
       int j = lenOfB-1;
       int carry = 0;
       StringBuilder sb = new StringBuilder();
       
       while(i!=-1 || j!=-1 || carry!=0)
       {
           int Asum = (i != -1)? A.charAt(i--) - '0': 0;
           int Bsum = (j != -1)? B.charAt(j--) - '0': 0;
           
           int sum = carry + Asum + Bsum;
        sb.append(Integer.toString(sum % 2));
        carry = sum / 2;
       }
       
       j = sb.length() - 1;
       
    while(sb.charAt(j) != '1')
    {  
        sb.deleteCharAt(j);
        j--;
    }
    sb.reverse();
    return sb.toString();
   }
}