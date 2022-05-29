// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;



 // } Driver Code Ends
class Solution {
public:
    bool dfs(int node,int V,vector<pair<int,int>>graph[],vector<int>&visited,int maxPath,int k)
   {
       visited[node] = 1;
       if(maxPath >= k) return true;
       for(int i=0;i<graph[node].size();i++)
       {
           int temp = maxPath;
           if(!visited[graph[node][i].first])
           {
               temp+=graph[node][i].second;
               if(dfs(graph[node][i].first,V,graph,visited,temp,k)) return true;
           }
       }
       visited[node] = 0;
       return false;
   }
   bool pathMoreThanK(int V, int E, int k, int *a) 
   { 
      vector<pair<int,int>>graph[V];
      for(int i=0;i<E*3;i+=3)
      {
          graph[a[i]].push_back({a[i+1],a[i+2]});
          graph[a[i+1]].push_back({a[i],a[i+2]});
      }
      vector<int>visited(V,0);
      return dfs(0,V,graph,visited,0,k);
   } 
};




// { Driver Code Starts.


int main() {
	//code
    int t;cin >> t;
    while(t--)
    {
        int V, E, K;
        cin >> V >> E >> K;
        int a[3*E + 1];
        for(int  i=0;i<3*E;i++){
            cin >> a[i];
        }
        
        Solution obj;
        if(obj.pathMoreThanK(V, E, K, a)){
            cout << 1 << endl;
        }
        else{
            cout << 0 << endl;
        }
        
    }
	return 0;
}  // } Driver Code Ends