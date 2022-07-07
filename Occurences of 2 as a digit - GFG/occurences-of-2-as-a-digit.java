// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            GfG gfg = new GfG();
            long res = gfg.count2s(n);
            System.out.println(res);
        }
        
    }
}
// } Driver Code Ends


class GfG
{
    public static long count2s(long n)
    {
        // Your code here
        int count=0;
        for(int i=2;i<=n;i++){
            count+=count2sinRangeAtDigit(i);
        }
        return count;
        
    }
    
    public static long count2sinRangeAtDigit(long n)
    {
        //Your code here too
        int c=0;
        while(n>0){
            if(n%10==2){
                c++;
            }
            n=n/10;
        }
        return c;
    }
}