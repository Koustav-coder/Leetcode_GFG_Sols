// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution{   
public:
     string smallestNumber(int S, int D){
        
        if (S > D * 9) return "-1";        
        int d = 1;        
        int res = pow(10, D - 1);        
        S -= 1;
        
        while (S > 0) {            
            res += d * min(S, 9);       
            S -= min(S, 9);
            d *= 10;
        }        
        return to_string(res);
    }
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int S,D;
        cin >> S >> D;
        Solution ob;
        cout << ob.smallestNumber(S,D) << endl;
    }
    return 0; 
}   // } Driver Code Ends