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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    class Pair {
        int v, level;
        
        Pair (int v, int level) {
            this.v = v;
            this.level = level;
        }
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == - 1)
                if(!findBipartite(adj, i, visited))
                    return false;
        }
        
        return true;
    }
    
    public boolean findBipartite(ArrayList<ArrayList<Integer>> graph, int source, int[] visited) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(source,0));
        
        while(!q.isEmpty()) {
            Pair rem = q.remove();
            
            if(visited[rem.v] != -1) {
                if(visited[rem.v] != rem.level)
                    return false;
            } else 
                visited[rem.v] = rem.level;
            
            for(int e : graph.get(rem.v)) {
                if(visited[e] == -1) {
                    q.add(new Pair(e, rem.level + 1));
                }
            }
        }
        
        return true;
    }
}