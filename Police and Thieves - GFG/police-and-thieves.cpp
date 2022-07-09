// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    int catchThieves(char arr[], int n, int k) 
    {
        queue<int> dq;
        vector<int> v;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]=='P')
                v.push_back(i);
            else dq.push(i);
        }
        for(int i:v){
            if(dq.size() and dq.front()<i){
                while(dq.size() and i-dq.front()>k)
                    dq.pop();
                if(dq.size()){
                    count++;
                    dq.pop();
                }
            }
            else if(dq.size() and dq.front()-i<=k){
                dq.pop();
                count++;
            }
        }
        return count;
    }
};

// { Driver Code Starts.

int main() 
{ 
	int t;
	cin>>t;
	while(t--)
	{
		int n, k;
		cin>>n >> k;
		char arr[n];
		for (int i = 0; i < n; ++i)
			cin>>arr[i];
		Solution obj;
		cout<<obj.catchThieves(arr, n, k) << endl;
	}
	return 0; 
} 

  // } Driver Code Ends