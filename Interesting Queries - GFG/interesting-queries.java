// { Driver Code Starts
//Initial Template for Java

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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int q = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int[] nums = new int[n];
            String[] S1 = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S1[i]);
            int[][] Queries = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] S3 = br.readLine().trim().split(" ");
                for(int j = 0; j < S3.length; j++){
                    Queries[i][j] = Integer.parseInt(S3[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.solveQueries(nums, Queries, k);
            for(int i = 0; i < ans.length; i++)
                System.out.println(ans[i]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

    class Solution
{
   public int[] solveQueries(int[] nums, int[][] Queries, int k)
   {
       ArrayList<Integer>arr=new ArrayList<>();
       
      Set<String> set=new HashSet<String>();
       Map<Integer, Integer> mp = new HashMap<>();
       // Code here 
       for(int i=0;i<Queries.length;i++)
       {int l=Queries[i][0];
       int r=Queries[i][1];
       int count=0;
       
        for (int j=l; j<=r; j++)
           {
            mp.put(nums[j-1], mp.get(nums[j-1]) == null ? 1 : mp.get(nums[j-1]) + 1);
            }
             for (int kk = l; kk <=r; kk++)
             {
               if (mp.get(nums[kk-1])>= k)
               {   String ss=nums[kk-1]+"";
                   if(!set.contains(ss))
                   {
                       count++;
                       set.add(ss);
                   }
               
               }

             }
           set.clear();
                             
           mp.clear();
           arr.add(count);
       }    
       int []arr1=new int[arr.size()];
       for(int i=0;i<arr.size();i++)
       arr1[i]=arr.get(i);
       return arr1;
   
}
   
}