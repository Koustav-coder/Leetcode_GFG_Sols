// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minVal(a, b));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static int countBits(int n)
    {
        int count = 0;
        while(n > 0)
        {
            count = count + (n&1);
            n  = n >> 1; 
        }
        return count;
    }
    public static int minVal(int a, int b) {
        //Find number of set bit in B
        int bitsA = countBits(a);
        int bitsB = countBits(b);
        int diff = Math.abs(bitsA-bitsB);
        
        if(bitsA == bitsB) return a;
        else if( bitsA > bitsB)
        {
            //Convet 1 t 0;
            while(diff > 0)
            {
                a = a & (a - 1);
                diff --;
            }
        }
        else
        {
            //Convert 0 to 1
            while(diff > 0)
            {
                a = a | (a + 1);
                diff --;
            }
        }
      
        return a;
    }
}