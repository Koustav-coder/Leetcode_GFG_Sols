// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int pageFaults(int n, int c, int []arr){
        int i,k;
        
        int res = 0;

        ArrayList<Integer> a = new ArrayList<>();
        for(i=0;i<n;i++){
            int no = a.size();
            //System.out.println(no);
            for(k=0;k<no;k++){
                if(a.get(k)==arr[i]){
                    a.remove(k);
                    break;
                }
            }
            
            if(k!=no)
                a.add(arr[i]);
            else if(no<c){
                a.add(arr[i]);
                res++;
            }
            else{
                a.remove(0);
                a.add(arr[i]);
                res++;
            }
        }
        return res;
    }
}