// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
	public:
	void solve(int ind,string &s,vector<string>&ans)
	    {
	        if(ind==s.length())
	        {
	            ans.push_back(s);
	            return;
	        }
	        for(int i=ind;i<s.length();i++)
	        {
	            if(i>ind && s[i]==s[i-1])continue;
	            swap(s[i],s[ind]);
	            solve(ind+1,s,ans);
	            swap(s[i],s[ind]);
	        }
	    }
		vector<string>find_permutation(string s)
		{
		    vector<string>ans;
		    sort(s.begin(),s.end());
		    solve(0,s,ans);
		    sort(ans.begin(),ans.end());
		    return ans;
		}
};



// { Driver Code Starts.
int main(){
    int t;
    cin >> t;
    while(t--)
    {
	    string S;
	    cin >> S;
	    Solution ob;
	    vector<string> ans = ob.find_permutation(S);
	    for(auto i: ans)
	    {
	    	cout<<i<<" ";
	    }
	    cout<<"\n";
    }
	return 0;
}
  // } Driver Code Ends