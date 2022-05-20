// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S1 = read.readLine();
            String S2 = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.findTime(S1,S2));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
   static int findTime(String S1 , String S2) {
       // code here
       Map<Character,Integer> m = new HashMap<>();
       int count=0;
       
       for(int i=0;i<S1.length();i++)
       {
           m.put(S1.charAt(i),count++);
       }
       int result=0,pos=0;
       
       for(int i=0;i<S2.length();i++)
       {
           int temp=m.get(S2.charAt(i));
           result+=Math.abs(pos-temp);
           pos=temp;
       }
       return result;
   }
};