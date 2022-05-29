// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   public int findOccurrence(char mat[][], String target)
   {
       int count=0;
        for(int i=0;i<mat.length;i++)
      {
          for(int j=0;j<mat[0].length;j++)
          {
               count += helper(target,i,j,mat,mat.length-1,mat[0].length-1,0);
              
            
          }}
          return count;
   }
  public static int  helper(String target,int i,int j,char [][] mat,int row,int col,int idx){
      int count = 0;
      if(i >= 0 && i <= row && j >= 0 && j <= col && target.charAt(idx) == mat[i][j])
      {
          char temp = target.charAt(idx) ;
          idx += 1;
          
          mat[i][j] = 0;
          if(idx==target.length())
              count = 1;
          else
          {
              count += helper(target,i,j+1,mat,row,col,idx);
              count += helper(target,i,j-1,mat,row,col,idx);
              count += helper(target,i+1,j,mat,row,col,idx);
              count += helper(target,i-1,j,mat,row,col,idx);
          }
          
          mat[i][j] = temp;
      }
      return count;
  }
}