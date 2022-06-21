// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> findSubarray(int a[], int n) {
        ArrayList<Integer> tmp = new ArrayList<>();
        long sum = 0;
        long maxS = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){if(a[i]<0) {
                if(sum>=maxS){
                ans = new ArrayList<>(tmp);
                }
                tmp.clear();
                sum = 0;
                continue;    
            }else{
            tmp.add(a[i]);
            sum+=a[i];
            maxS = Math.max(sum,maxS);
            }
        }
        if(sum>=maxS){
            ans = new ArrayList<>(tmp);
        }
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
}