// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
   {
      char[] s= str.toCharArray();
      int n=s.length;
      int halflength=n/2;
      for(int i=0;i<halflength;i++){
          char temp=s[i];
          s[i]=s[n-1-i];
          s[n-1-i]=temp;
      }
      return new String(s);
   }
}