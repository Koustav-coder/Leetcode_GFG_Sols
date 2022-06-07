// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

struct Info{
    int cost;
    string arrangement;
    string labelForm;
};

class Solution{
    public:
    map<string,Info> dp;
    
    string getOrderNotation(int A[], int start, int end){
        string arrangement="";
        arrangement+='[';
        for(int i=start;i<=end;i++){
            arrangement+=to_string(A[i]);
            arrangement+="x";
        }
        arrangement.pop_back();
        arrangement+=']';
        return arrangement;
    }    

    Info helper(int A[], int start, int end){
        if(start+1==end){
            string arrangement=getOrderNotation(A,start,end);
            return {0,arrangement,string(1,start+'A')}; 
        }
    
        string key=to_string(start)+'-'+to_string(end);
    
        if(dp.find(key)!=dp.end()){
            return dp[key];
        }
    
        int Mincost=INT_MAX;
        string MinArrangement="";
        string MinLabelForm="";
    
        for(int k=start+1;k<end;k++){
            Info LEFT=helper(A,start,k);
            Info RIGHT=helper(A,k,end);
            int cost=LEFT.cost+RIGHT.cost+A[start]*A[k]*A[end];
            string currArrangement=LEFT.arrangement+"x"+RIGHT.arrangement;
            string currlabelForm=LEFT.labelForm+RIGHT.labelForm;
            if(cost<Mincost){
                Mincost=cost;
                MinArrangement=currArrangement;
                MinLabelForm=currlabelForm;
            }
        }
        Info ans;
        ans.cost=Mincost;
        ans.arrangement="("+MinArrangement+")";
        ans.labelForm="("+MinLabelForm+")";
        
        return dp[key]=ans;
    }

    string matrixChainOrder(int A[], int n){
        return helper(A,0,n-1).labelForm;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int p[n];
        for(int i = 0;i < n;i++)
            cin>>p[i];
        
        Solution ob;
        cout<<ob.matrixChainOrder(p, n)<<"\n";
    }
    return 0;
}  // } Driver Code Ends