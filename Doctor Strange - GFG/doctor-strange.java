// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    int arr [][] = new int[K][2];
		    for(int i = 0;i<K;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.doctorStrange(N, K, arr);
            System.out.println(ans);
    	    
		}
	}
}



// } Driver Code Ends


//User function Template for Java

//User function Template for Java


class Complete{
   
   // Function for finding maximum and value pair
   public static int doctorStrange (int n, int k, int g[][]) {
      //construct the graph;
      ArrayList<Integer>[] graph = new ArrayList[n+1];
      for (int i = 1; i <=n; i++){
          graph[i] = new ArrayList<>();
      }
      
      for (int[] br: g){
          int u = br[0];
          int v = br[1];
          
          graph[u].add(v);
          graph[v].add(u);
      }
      
      int[] disc = new int[n+1];
      Arrays.fill(disc, -1);
      int[] low = new int[n+1];
      int time = 0;
      
      boolean[] ap = new boolean[n+1];
      int rootcalls = 0;
      for (int i = 1; i <= n; i++){
          if (disc[i] == -1){
              dfs(i, -1, disc, low, time,graph, ap, rootcalls);
          }
      }
     int tap = 0;
     if (ap[1] && rootcalls > 1){
         tap++;
     }
     for (int i = 2; i <= n; i++){
         if (ap[i]){
            tap++;
         }
     }
     return tap;
   }
   
   private static void dfs(int src, int par, int[] disc, int[] low, int time,ArrayList<Integer>[] graph, boolean[] ap, int rootcalls){
       
      disc[src] = low[src] = time++;
      
      for (int nbr : graph[src]){
          if (disc[nbr] == -1){
              if (par == -1)
                rootcalls++;
             dfs(nbr, src, disc, low, time, graph, ap, rootcalls);
             
             if (disc[src] <= low[nbr]){
                ap[src] = true;
             }
             low[src]= Math.min(low[src], low[nbr]);
          }
          else if (nbr != par){
              low[src] = Math.min(low[src], disc[nbr]);
          }
      }
   }
}