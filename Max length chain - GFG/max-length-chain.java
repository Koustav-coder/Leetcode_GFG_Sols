// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}
// } Driver Code Ends


/*class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}*/

class GfG
{
   int maxLen(int ind, int mini, Pair[]arr, int n, int[]dp){
        if(ind>=n){
            return 0;
        }

        if(dp[ind]!=-1){
            return dp[ind];
        }

        int take=0;
        if(arr[ind].x > mini){
            take = 1 + maxLen(ind+1, arr[ind].y, arr, n, dp);
        }

        int not = maxLen(ind+1, mini, arr, n, dp);

        return dp[ind] = Math.max(take, not);
    }
    
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
        Arrays.sort(arr,(a,b)->a.y-b.y);
       
        int[]dp = new int[arr.length];

        Arrays.fill(dp, -1);
        
        return maxLen(0, Integer.MIN_VALUE, arr, n, dp);
    }
}