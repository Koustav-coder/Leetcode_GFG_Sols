// { Driver Code Starts
// Initial Template for Java

import java.util.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // Iterating over testcases
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Geeks obj = new Geeks();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

// Helper class to find largest number with minimum frequency
class Geeks {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
         int i = 1;
        int a = arr[0];
        while(i < n)
        {
            if(a < arr[i])
            {
                a = arr[i];
            }
            i++;
        }
        return a;
    }
}