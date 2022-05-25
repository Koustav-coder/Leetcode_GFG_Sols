// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
   public String FirstNonRepeating(String a)
   {
       int[] freq = new int[26];
       StringBuilder ans = new StringBuilder();
       Queue<Character> q = new LinkedList<>();
       for(int i=0; i<a.length(); i++){
               char ch = a.charAt(i);
               freq[ch-'a']++;
               q.offer(ch);
               while(!q.isEmpty()){
                   if(freq[q.peek()-'a']>1)
                       q.poll();
                   else{
                       ans.append(q.peek());
                       break;
                   }
               }
               if(q.isEmpty())
                   ans.append('#');
       }
       return ans.toString();
   }
}