// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            
            for(int i=0; i<N-1; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                String S[] = read.readLine().split(" ");
                temp.add(Integer.parseInt(S[0]));
                temp.add(Integer.parseInt(S[1]));
                arr.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxBinTreeGCD(arr,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
   static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> al, int n) {
       // code here
       
       if(n == 1) return 0;
       al.sort((a,b)->a.get(0)-b.get(0));
       int ans = 0;
       int i = 1;
       while(i<al.size()){
           ArrayList<Integer> al1 = al.get(i);
           ArrayList<Integer> al2 = al.get(i-1);
           
           if(al1.get(0)!=al2.get(0)){
               i++;
               continue;
           }
           ans = Math.max(ans, getGCD(al1.get(1),al2.get(1)));
           i+=2;
       }
       return ans;
   }
   static int getGCD(int a, int b){
       while(a != b){
           if(a>b){
               a = a-b;
           }else{
               b = b-a;
           }
       }
       return a;
   }
};