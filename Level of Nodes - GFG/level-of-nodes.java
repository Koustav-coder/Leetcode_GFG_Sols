// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int x)
    {
        Queue<Node> q=new LinkedList<>();
        boolean visited[]=new boolean[V];
        q.add(new Node(0,0));
        while(!q.isEmpty()){
            Node node=q.remove();
            int level=node.level;
            int u=node.u;
            visited[u]=true;
            for(int v:adj.get(u)){
                if(!visited[v]){
                   if(v==x) return level+1;
                   else q.add(new Node(level+1,v));
                }
            }
        }
        return -1;
    }
}
class Node{
    int level;
    int u;
    Node(int level,int u){
        this.level=level;
        this.u=u;
    }
}