// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    


void rearrange(int arr[], int n) {
      ArrayList<Integer> positive = new ArrayList<>();
 ArrayList<Integer> negative = new ArrayList<>();
 for(int i =0;i<n;i++) {
  if(arr[i]>=0) {
   positive.add(arr[i]);
  }else {
   negative.add(arr[i]);
  }
 }
 int pos =0;
 int neg = 0;
 for(int j =0;j<n;j++) {
  if(j==0) {
      if(positive.size()>0){
       arr[j] = positive.get(pos++);
      }else{
          arr[j] = negative.get(neg++);
      }
  }else if(j%2 !=0 && neg<negative.size()) {
   arr[j] = negative.get(neg++);
  }else if(j%2 == 0 && pos<positive.size()) {
   arr[j] = positive.get(pos++);
  }else if(pos==positive.size() && neg<negative.size()) {
   arr[j] = negative.get(neg++);
  }else if(neg == negative.size() && pos<positive.size()) {
   arr[j] = positive.get(pos++);
  }
 }
   }
}