// { Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method */

class Solution
{   static boolean ans;
    public void solve(int a[], int start,int[] subsets,int s,int n,int nes){
        //if(start>a.length) return;
        for(int l = 0;l<subsets.length;l++){
            if(subsets[l]>s){
                return;          // for optimization
            }
        }
        if(start==a.length){
            if(nes==subsets.length){  // check number of non empty sets equal to partion length
                for(int l = 0;l<nes;l++){
                    if(subsets[l]!=s){
                        ans = false;
                        return;
                    }
                }
                ans = true;
            }
            return;
        }
        for(int i = 0;i<subsets.length;i++){
           if(subsets[i]==0){
               subsets[i]+=a[start];
               solve(a,start+1,subsets,s,n,nes+1);
               subsets[i]-=a[start];
           }else{
               subsets[i]+=a[start];
               solve(a,start+1,subsets,s,n,nes);
               subsets[i]-=a[start];
           }
        }
    }
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
		ans = false;
		
		int sum = 0,max = 0;
		if(k==1) return true;
		if(k>n) return false;
	    for(int i: a){
	        sum+=i;
	        if(i>max){
	            max = i;
	        }
	    }
	    int s = sum/k;
	    if(sum%k!=0 || max>s) return false;
	    int[] subsets = new int[k];
		solve(a,0,subsets,s,n,0);
		return ans;
    }
}
