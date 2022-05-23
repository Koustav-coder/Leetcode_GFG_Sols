// { Driver Code Starts
import java.util.*;


 // } Driver Code Ends


class Solution
{
    //Function to find the smallest positive number missing from the array.
     static int missingNumber(int arr[], int size)
    {
        int validIndex = 0;
        int max = 0;
        // Discard 0, -ve, a[i]>size of array
        for (int i=0; i<size; i++) {
            if (arr[i]>0 && arr[i]<=size) {
                arr[validIndex++] = arr[i];
                max = Math.max(max, arr[i]);
            }
        }
        // Now add max+1 to corresponding indices
        for (int i=0; i<validIndex; i++) {
            int index = arr[i]%(max+1);
            arr[index-1] += max+1;
        }
        // Divide by max+1 and if it's 0 that means
        // item missing return that index +1
        for (int i=0; i<validIndex; i++) {
            arr[i] /= max+1;
            if (arr[i]==0) return i+1;
        }
        // Since, it's 0 based indexing and we did not
        // find missing return validIndex+1
        return validIndex+1;
    }
}


// { Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

  // } Driver Code Ends