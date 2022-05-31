// { Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}// } Driver Code Ends


class Solution
{
    int wildCard(String p, String s)
    {
        int n=p.length();
        int m=s.length();
        
        boolean dp[][]=new boolean[n+1][m+1];
        
       //  for(Boolean a[]: dp)Arrays.fill(a,null);
     
     dp[0][0]=true;
     
    for(int j=1;j<=m;j++){
        dp[0][j]=false;
    }
    
    for(int i=1;i<=n;i++){
        if(p.charAt(i-1)=='*')dp[i][0]=true;
        else break;
    }
    
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            
            if(p.charAt(i-1)==s.charAt(j-1)|| p.charAt(i-1)=='?'){
                 dp[i][j]= dp[i-1][j-1];
            }else if(p.charAt(i-1)=='*'){
              dp[i][j]=(dp[i-1][j] || dp[i][j-1]);
          }else  dp[i][j]= false;
          
            }            
        }
        
        
        return dp[n][m]==true?1:0;
    
    }     
        
}
