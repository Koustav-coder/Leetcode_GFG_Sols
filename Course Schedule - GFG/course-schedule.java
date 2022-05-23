// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
   static public boolean dfs(ArrayList<ArrayList<Integer>> adjList, int numCourses, int index, boolean[] visited, boolean[] recStack, Stack<Integer> topologicalStack){
       visited[index] = true;
       recStack[index] = true;
       for(Integer courseIndex : adjList.get(index)){
           if(!visited[courseIndex]){
               boolean isCycle = dfs(adjList, numCourses, courseIndex, visited, recStack, topologicalStack );
               if(isCycle){
                   return true;
               }
           }else if(recStack[courseIndex]){
               // back edge
               return true;
           }
       }
       recStack[index] = false;
       topologicalStack.push(index);
       return false;
   }
   
   static public ArrayList<ArrayList<Integer>> getadjList(int numCourses, ArrayList<ArrayList<Integer>> prerequisites){
       ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(numCourses);
       for(int index = 0; index< numCourses; index++){
           adjList.add(new ArrayList<Integer>());
       }
       for(ArrayList<Integer> prereqPair:  prerequisites){
            adjList.get(prereqPair.get(1)).add(prereqPair.get(0));
        }
       return adjList;
   }
   
   static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
   {
       // add your code here
       boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        boolean isCycle = false;
        Stack<Integer> topologicalStack = new Stack<Integer>();
       
       
        ArrayList<ArrayList<Integer>> adjList =  getadjList( n, prerequisites);
        for(int i=0; i<n;i++){
            if(!visited[i])
               isCycle = isCycle | dfs(adjList, n, i, visited, recStack, topologicalStack);
        }
       
       if(!isCycle){
           int[] courseOrder = new int[n];
           for(int i=0; i< n; i++){
               courseOrder[i] = topologicalStack.pop();            
           }
           return courseOrder;
       }else{
           int[] courseOrder = {};
           return courseOrder;
       }
   }
}
 