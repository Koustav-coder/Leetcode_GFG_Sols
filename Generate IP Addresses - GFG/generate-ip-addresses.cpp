// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


 // } Driver Code Ends
/*You are required to complete this method*/

class Solution{
  public:
    vector<string> res;
    void solve(string s,string t,int cnt){
        if(s.length() == 0  and cnt == 4){
            t.pop_back();
            res.push_back(t);
            return;
        }
        for(int i  = 0; i < s.length() ; i++){
            string d = s.substr(0 , i  + 1);
            if(d[0] == '0' and d.length() > 1) continue;
            if(stol(d) < 256){
                string tmp  = s.substr(i + 1);
                solve(tmp,t + d + '.' , cnt + 1);
            }else return;
        }
    }
    vector<string> genIp(string &s) {
        res.clear();
        solve(s, "" , 0);
        return res;
    }

};

// { Driver Code Starts.

int main() {
    int T;
    cin >> T;
    while (T--) {
        string s;
        cin >> s;

        /*generating naively*/
        Solution obj;
        vector<string> str = obj.genIp(s);
        sort(str.begin(), str.end());
        if(str.size()==0)
            cout << -1 << "\n";
        else{
            for (auto &u : str) {
                cout << u << "\n";
            }
        }
    }
}  // } Driver Code Ends