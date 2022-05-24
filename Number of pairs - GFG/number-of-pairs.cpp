// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
 

class Solution{
    public:
    
    // X[], Y[]: input arrau
    // M, N: size of arrays X[] and Y[] respectively
    //Function to count number of pairs such that x^y is greater than y^x.
    long long Solve(int val,int Y[],int freq[],int M, int N)
   {
       long long int pos = 0;
       long long int res= 0;
       if(val==0)
       {
           return 0;
       }
       if(val==1)
       {
           return freq[0];
       }
       
       pos = upper_bound(Y,Y+N,val)-Y;
       
       res = res + (N - pos) + freq[0]+freq[1];
       
       if(val==2)
       {
           res = res - (freq[3] + freq[4]);
       }
       if(val==3)
       {
           res = res + freq[2];
       }
       return res;
    }
   long long countPairs(int X[], int Y[], int M, int N)
   {
       int freq[5] = {0};
       
       long long int count = 0;
       
       for(int i=0;i<N;i++)
       {
           if(Y[i]<5)
           {
               freq[Y[i]]++;
           }
       }
       
       sort(Y,Y+N);
       
       for(int i=0;i<M;i++)
       {
           count = count + Solve(X[i],Y,freq,M,N);
       }
       return count;
   }
};


// { Driver Code Starts.
int main()
{
	int T;
	cin>>T;
	while(T--)
	{
		int M,N;
		cin>>M>>N;
		int i,a[M],b[N];
		for(i=0;i<M;i++)
		{
			cin>>a[i];
		}
		for(i=0;i<N;i++)
		{
			cin>>b[i];
		}
		Solution ob;
		cout<<ob.countPairs(a, b, M, N)<<endl;
	}
}  // } Driver Code Ends