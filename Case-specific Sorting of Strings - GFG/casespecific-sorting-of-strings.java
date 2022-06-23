// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


 // } Driver Code Ends


class Solution
{
   //Function to perform case-specific sorting of strings.
   public static String caseSort(String str)
   {
       // Your code here
       
          char c[]=str.toCharArray();
      Arrays.sort(c);
      String s="";
      int j=0;
      String s1=String.valueOf(c);
      for(;j<s1.length();j++){
          if(s1.charAt(j)>='a'&&s1.charAt(j)<='z')
          break;
      }
      int k=0;
      for(int i=0;i<str.length();i++){
          if(str.charAt(i)>=65&&str.charAt(i)<=91){
              s+=c[k];
              k++;
          }
          else{
              s+=c[j];
              j++;
          }
      }
      return s;


   }
}

// { Driver Code Starts.

class GFG {
    
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        System.out.println(sortedStr);
    	    }
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
  // } Driver Code Ends