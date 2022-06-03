// { Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
  static long[][] dp=new long[1001][1001];
  static long  m=1000000007;
  static long solve (String str,int i,int j){
      if(i>j)
      return 0;
      if(i==j)
      return 1;
       if(dp[i][j]!=-1)
        return dp[i][j];
      
       if(str.charAt((int)i)==str.charAt((int)j))
       return dp[i][j]=(solve(str,i+1,j)+solve(str,i,j-1)+1)%m;
       else
        return dp[i][j]=(m+solve(str,i+1,j)%m+solve(str,i,j-1)%m-solve(str,i+1,j-1)%m)%m;
       
   }
  static long countPS(String str)
   {
     for(long[] a:dp)
      Arrays.fill(a,-1);
     return solve(str,0,str.length()-1);  
   }
}