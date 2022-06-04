// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int minColour(int N, int M, vector<int> mat[]) {
        vector <int> adj[N+1], in(N+1);
        
        for(int i=0; i<M; i++){
            int u = mat[i][0], v = mat[i][1];
            adj[u].push_back(v);
            
            in[v]++;
        }
        
        queue <int> q;
        vector <int> dep(N+1, -1);
        
        for(int i=1; i<=N; i++){
            if(in[i] == 0){
                q.push(i);
                dep[i] = 1;
            }
        }
        
        while(!q.empty()){
            int v = q.front();
            q.pop();
            
            for(auto& u : adj[v]){
                in[u]--;
                dep[u] = max(dep[u], 1 + dep[v]);
                if(in[u] == 0){
                    q.push(u);
                }
            }
        }
        
        int ans = 1;
        for(int i=1; i<=N; i++){
            ans = max(ans, dep[i]);
        }
        
        return ans;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N, M, x, y;
        cin>>N>>M;
        vector<int> mat[M];
        for(int i = 0;i < M;i++){
            cin>>x>>y;
            mat[i].push_back(x);
            mat[i].push_back(y);
        }
        
        Solution ob;
        cout<<ob.minColour(N, M, mat)<<"\n";
    }
    return 0;
}  // } Driver Code Ends