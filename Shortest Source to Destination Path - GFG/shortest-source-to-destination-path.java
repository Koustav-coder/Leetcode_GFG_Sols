// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
   
    int[][]dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int shortestDistance(int n, int m, int grid[][], int x, int y) {
        // code here
        
        if(grid[0][0]!=1 || grid[x][y]!=1){
            return -1;
        }
        
        boolean[][] visit = new boolean[n][m];
        visit[0][0]=true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        int res=0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                int[] cur = q.remove();
                
                if(cur[0] == x && cur[1] == y){
                    return res;
                }
                
                for(int i=0; i<dir.length; i++){
                    int nextX = dir[i][0] + cur[0];
                    int nextY = dir[i][1] + cur[1];
                    
                    if((nextX >=0 && nextX < n && nextY >=0 && nextY < m)
                        && !visit[nextX][nextY] && grid[nextX][nextY]==1 ){
                        
                        q.add(new int[]{nextX, nextY});
                        
                        visit[nextX][nextY]=true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
    }
