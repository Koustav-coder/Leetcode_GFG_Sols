// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
     static boolean match(String pattern, String str)
   {
       // code here
      StringBuilder npat = new StringBuilder("^");

       for(char c:pattern.toCharArray()){
           if(c=='*'){
               npat.append("[a-zA-Z0-9]*");
           }else if(c=='?'){
               npat.append(".");
           }else{
               npat.append(c);
           }
       }
       npat.append("$");

       return str.matches(npat.toString());
   }
}