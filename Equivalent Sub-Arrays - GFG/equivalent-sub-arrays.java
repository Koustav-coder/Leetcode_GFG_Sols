// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
   static int countDistinctSubarray(int arr[], int n) 
    { 
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) set.add(arr[i]);
        
        int distinct = set.size();
        
        int start = 0, end = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(end<n)
        {
           if(map.containsKey(arr[end])) {
               map.put(arr[end],map.get(arr[end])+1);
           }else map.put(arr[end],1);
           
           if(map.size() == distinct)
           {
                count += n - end;
                
                while(map.size()== distinct)
                {
                    int get = map.get(arr[start]);
                    get--;
                    if(get==0) map.remove(arr[start]);
                    else {
                        map.put(arr[start],get);
                        count += n - end;
                    }
                    start++;
                }
           }
           end++;
        }
        return count;
    }
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends