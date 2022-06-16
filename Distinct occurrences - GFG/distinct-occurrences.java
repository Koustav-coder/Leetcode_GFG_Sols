// { Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int  subsequenceCount(String S, String T)
    {
	// Your code here	
	int dp[][] = new int[S.length()+1][T.length()+1];
	int m = S.length();
	int n = T.length();
	dp[m][n] = 1;
	for(int i=m-1;i>=0;i--) {
	    dp[i][n] = 1;
	    for(int j=n-1;j>=0;j--) {
	        if(S.charAt(i)==T.charAt(j)) {
	            dp[i][j] = (dp[i+1][j] + dp[i+1][j+1])%(1000000007);
	        }
	        else
	        dp[i][j] = dp[i+1][j];
	    }
	}
	return dp[0][0];
    }
}