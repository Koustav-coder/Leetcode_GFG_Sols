// { Driver Code Starts
//Initial Template for Java
import java.util.*;

class GFG 
{
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++)
		     arr[i] = sc.nextInt();
		     
		    Geeks obj = new Geeks();
		    obj.SortedDuplicates(arr, n);
		    System.out.println();  // print the newline
		    
		}
	}
}




 // } Driver Code Ends
//User function Template for Java

/* Helper class containing function SortedDuplicates
containg arguments
arr[]: the duplicated array
n: size of the array
*/
class Geeks
{
    // print the elements which appear more than
    // once in the array in sorted order
    public static void SortedDuplicates(int arr[], int n)
    {
        //Your code here
       TreeSet<Integer> tree=new TreeSet<>();
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               if(arr[i]==arr[j]){
                   tree.add(arr[i]);
               }
           }
       }
       if(tree.isEmpty()){
           System.out.print(-1);
       }
       else{
       for(int it:tree)
           System.out.print(it+" ");
       }
     }
    
}
   

// { Driver Code Starts.
  // } Driver Code Ends