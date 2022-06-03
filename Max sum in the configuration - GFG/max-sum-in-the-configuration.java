// { Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}
// } Driver Code Ends


class GfG
{
    int max_sum(int a[],int n)
{
    int sumArr=0,kq=0;
    for(int i=0;i<n;i++){
        sumArr+=a[i];
        kq+=i*a[i];
    }
    int Max=kq;
    for(int i=1;i<n;i++){
        kq=kq-sumArr+n*a[i-1];
        if(kq>Max)
            Max=kq;
    }
    return Max;
}
}
