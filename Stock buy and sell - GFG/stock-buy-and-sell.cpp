// { Driver Code Starts

// Program to find best buying and selling days
#include <bits/stdc++.h>

using namespace std;

// This function finds the buy sell schedule for maximum profit
void stockBuySell(int *, int);

// Driver program to test above functions
int main() {
    int T;
    cin >> T;

    while (T--) {
        int n, i;
        cin >> n;
        int price[n];
        for (i = 0; i < n; i++) cin >> price[i];
        // function call
        stockBuySell(price, n);
    }
    return 0;
}
// } Driver Code Ends


// User function template for C++

// This function finds the buy sell schedule for maximum profit
void print(int i,int j){
    printf("(%d %d) ",i,j);
}
void stockBuySell(int price[], int n) {
    // code here
      if (n == 1)
        return;

    // Traverse through given price array
    int i = 0;vector<pair<int,int>> res;
    while (i < n - 1) {
 
        // Find Local Minima
        // Note that the limit is (n-2) as we are
        // comparing present element to the next element
        while ((i < n - 1) && (price[i + 1] <= price[i]))
            i++;
 
        // If we reached the end, break
        // as no further solution possible
        if (i == n - 1){
            break;
        }
 
        // Store the index of minima
        int buy = i++;
        
        // Find Local Maxima
        // Note that the limit is (n-1) as we are
        // comparing to previous element
        while ((i < n) && (price[i] >= price[i - 1]))
            i++;
 
        // Store the index of maxima
        int sell = i - 1;
        res.push_back({buy,sell});
    } 
    if(res.size()==0)
    {cout<<"No Profit\n";
    return;}

    for(int i=0;i<res.size()-1;i++){
        print(res[i].first,res[i].second);
    }
    printf("(%d %d)\n",res[res.size()-1].first,res[res.size()-1].second);
}