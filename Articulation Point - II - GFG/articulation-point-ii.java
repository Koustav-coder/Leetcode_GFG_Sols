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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
   static int time=0;
   void dfs(int u,int dis[],int low[],int parent[], boolean ap[],ArrayList<ArrayList<Integer>> adj)
   {
       dis[u]=low[u]=time;
       time++;
       int children=0;
       for(int i=0;i<adj.get(u).size();i++)
       {
           int v=adj.get(u).get(i);
           if(dis[v]==-1)
           {
               children+=1;
               parent[v]=u;
               dfs(v,dis,low,parent,ap,adj);
               low[u]=Math.min(low[u],low[v]);
               if(children>1&&parent[u]==-1)//if root is ap
               {
                   ap[u]=true;
               }
               if(parent[u]!=-1&&low[v]>=dis[u])// if non root is ap 
               {
                   ap[u]=true;
               }
           }
           else if(parent[u]!=v) //ignore child to parent edge
               low[u]=Math.min(low[u],dis[v]);
       }
   }
   public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
   {
       int dis[]=new int[V];
       int low[]=new int[V];
       int parent[]=new int[V];
       for(int i=0;i<V;i++)
       {
           dis[i]=-1;
           low[i]=-1;
           parent[i]=-1;
       }
       boolean ap[]=new boolean[V];
       for(int i=0;i<V;i++)
       if(dis[i]==-1)
       {
           dfs(i,dis,low,parent,ap,adj);
       }
       int j=0;
       int count=0;
       for(int i=0;i<V;i++)
       {
           if(ap[i])
               count++;
       }
       if(count==0)
       {
           return new int[]{-1};
       }
       int ans[]=new int[count];
       for(int i=0;i<V;i++)
       {
           if(ap[i])
               ans[j++]=i;
       }
       return ans;
       
   }
}