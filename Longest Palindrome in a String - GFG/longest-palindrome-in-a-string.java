// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution{
   static String longestPalin(String S){
       String longStr=Character.toString(S.charAt(0));
       for(int i=0;i<S.length()-1;i++){
           for(int j=i+1;j<=S.length();j++){
               boolean flag=checkPalin(S.substring(i,j));
               if(flag){
                   if(longStr.length()<S.substring(i,j).length()){
                       longStr=S.substring(i,j);
                   }
               }
           }
       }
       return longStr;
       
   }
   static boolean checkPalin(String str){
       for(int i=0;i<str.length();i++){
           if(str.charAt(i)!=str.charAt(str.length()-1-i)){
               return false;
           }
       }
       return true;
   }
}