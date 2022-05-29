// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
		class Solution
{
    public:
    int min_operations(vector<int> arr)
    {
        int N = arr.size();
        
        vector<int> dp(N, 1);
        
        for(int i = 1; i < N; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[j] < arr[i] and (i - j) <= arr[i] - arr[j])
                {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return N - *max_element(dp.begin(), dp.end());
    }
};




// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>nums(n);
		for(int i = 0; i < n; i++)cin >> nums[i];
		Solution ob;
		int ans  = ob.min_operations(nums);
		cout << ans <<"\n";
	}
	return 0;
}  // } Driver Code Ends