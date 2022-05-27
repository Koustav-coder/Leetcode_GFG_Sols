// { Driver Code Starts
// Initial Template for Java
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
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    HashSet<Integer> set;   
    public ArrayList<Integer> articulationPoints(int v , ArrayList<ArrayList<Integer>> adj)
    {
        int[] tin = new int[v];
        int[] low = new int[v];
        int[] visited = new int[v];
        set = new HashSet<>();
        
        solve(adj , 0 , -1 , tin , low ,visited , 1);
        
        Iterator<Integer> it = set.iterator();
        
        ArrayList<Integer> ll = new ArrayList<>();
        
        while(it.hasNext()){
            ll.add(it.next());
        }
        if(ll.size() == 0)
            ll.add(-1);
            
        Collections.sort(ll);
        return ll;
        
    }
    
    void solve(ArrayList<ArrayList<Integer>> adj ,int src , int parent , int[] tin , int[] low , int[] visited, int timer){
        
        visited[src] = 1;
        low[src] = tin[src] = timer++;
        
        int child = 0;
        for(Integer nn : adj.get(src)){
            
            if(visited[nn] == 0 ){
                solve(adj , nn , src, tin , low , visited , timer);
                low[src] = Math.min(low[src] , low[nn]);
                
                if(low[nn] >= tin[src] && parent != -1){
                    set.add(src);
                }
                
                child++;
            }
            else{
                low[src] = Math.min(low[src] , tin[nn] ); 
            }
            
        }
        
        if(child > 1 && parent == -1){
            set.add(src);
        } 
    } 
}