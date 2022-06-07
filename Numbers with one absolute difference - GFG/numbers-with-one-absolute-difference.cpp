// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution{
    public:
    #define ll long long
    #define vll vector<long long>
    #define pb push_back 
    vector<long long> absDifOne(long long N)
    {
        //code here.
        vll temp, newList, curList, ans;
        ll num=0;
        int lastDigit;
        if(N<=9) return ans;
        
        curList.pb(1);
        curList.pb(2);
        curList.pb(3);
        curList.pb(4);
        curList.pb(5);
        curList.pb(6);
        curList.pb(7);
        curList.pb(8);
        curList.pb(9);
        
        while(true)
        {
            for(ll number: curList)
            {
                lastDigit=number%10;
                if(lastDigit!=0)
                {
                    num= number*10 + lastDigit-1;
                    if(num<=N)
                    {
                        newList.pb(num);
                        ans.pb(num);
                    }
                        
                    else
                        return ans;
                }
                if(lastDigit!=9)
                {
                    num= number*10 + lastDigit+1;
                    if(num<=N)
                    {
                        newList.pb(num);
                        ans.pb(num);
                    }
                        
                    else
                        return ans;
                }
            }
            curList = newList;
            newList.clear();
        }
        return ans;
    }

};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
        {
            long long n;
            cin>>n;
            Solution ob;
            vector<long long> res = ob.absDifOne(n);
            for(int i = 0;i<res.size();i++)
                cout<<res[i]<<" ";
            if(res.size()==0)
                cout<<-1;
            cout<<endl;    
        }
}
  // } Driver Code Ends