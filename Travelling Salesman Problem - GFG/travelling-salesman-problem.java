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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min = Integer.MAX_VALUE;
    public int total_cost(int[][] cost)
    {
        // Code here 
        boolean visited[] = new boolean[cost.length];
        travel(cost,0,visited,0,0);
        return min;
    }
    public void travel(int arr[][],int index,boolean visited[],int cost,int num) {
        if(visited[index])
        return;
        if(num==arr.length-1) {
            min = Math.min(min,cost+arr[index][0]);
            return;
        }
        visited[index] = true;
        
        for(int i=0;i<arr[index].length;i++) {
            if(i==index)
            continue;
            travel(arr,i,visited,cost+arr[index][i],num+1);
        }
        visited[index] = false;
    }
}