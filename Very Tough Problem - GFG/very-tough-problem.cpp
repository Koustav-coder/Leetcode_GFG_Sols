// { Driver Code Starts

#include <bits/stdc++.h>
#include<iostream>
using namespace std;


 // } Driver Code Ends

class Solution{
public:    
 string toughProblem(int n, int s, int x){
    // Code Here
     int i,j,k = 0,m;
        if(s<x||(s%2!=x%2))
         {
         	return "No";
         }
         else if(n==1)
         {
         	if(s==x)
         	    return "Yes";
         	else
         		return "No";
         }
         else if(n==2)
         {
         	j=(s-x)/2;
         	for(i=30;i>=0;i--)
         	{
         		if(j&(1<<i))
         		{
         			if(x&(1<<i))
         				k=1;
         		}
         	}
         	if(k)
         	{
         		return "No";
         	}
         	else
         		return "Yes";
         }
         else
         {
         	return "Yes";
         }
  }
    
};


// { Driver Code Starts.

 
int main() {
  Solution ob;
  int tt;
  scanf("%d", &tt);
  while (tt--) {
    int n, s, x;
    scanf("%d %d %d", &n, &s, &x);
    
    cout << ob.toughProblem(n, s, x) << endl;
    
  }
  return 0;
}  // } Driver Code Ends