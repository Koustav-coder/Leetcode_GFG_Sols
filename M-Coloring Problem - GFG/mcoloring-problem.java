// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color = new int[n];
        for(int i=0;i<n;i++) color[i]=0;
        if(solve(graph,0,m,color,n)) return true;
        return false;
    }
    private boolean solve(boolean graph[][],int node,int m,int[] color,int n){
        if(node==n) return true;
                for(int k=1;k<=m;k++){
                if(isSafe(node,graph,k,n,color)){
                    color[node]=k;
                    if(solve(graph,node+1,m,color,n)) return true;
                    color[node]=0;
                }
            }
        return false;
    }
    private boolean isSafe(int node,boolean[][] graph,int i,int n,int[]color){
        for(int it=0;it<n;it++){
            if(it!=node && graph[it][node] && color[it]==i) return false;
        }
        return true;
    }
}