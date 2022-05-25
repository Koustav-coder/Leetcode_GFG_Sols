// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //without Rabin-Karp Algo
    ArrayList<Integer> search(String pat, String S)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        // your code here
        for(int i=0;i<=S.length()-pat.length();i++){
            if(S.charAt(i)==pat.charAt(0) && S.charAt(i+pat.length()-1)==pat.charAt(pat.length()-1)){
                int k = 0;
                for(char c:pat.toCharArray()){
                    if(i+k<S.length() && c==S.charAt(i+k)) k++;
                }
                if(k==pat.length()) ans.add(i+1); 
            }
        }
        if(ans.size()==0)ans.add(-1);
        return ans;
    }
}