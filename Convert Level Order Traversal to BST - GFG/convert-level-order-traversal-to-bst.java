// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GFG 
{
   public Node constructBST(int[] arr)
   {
       TreeMap<Integer,Node> m = new TreeMap<>(); 
       Node root=new Node(arr[0]);  
       m.put(arr[0],root); 
       int i=1;
       
       while(i<arr.length)
     {
         Node s = new Node(arr[i]);
         
         if(m.lowerKey(arr[i])!=null)
         {
             Map.Entry<Integer,Node> me= 
                           m.lowerEntry(arr[i]);
              
             if(me.getValue().right==null)
                  {
                   me.getValue().right=s;
                   m.put(arr[i],s);
                   i++;
                   continue;
                  }
         }
         
         Map.Entry<Integer,Node> me=
                         m.higherEntry(arr[i]);
         
         if(arr[i]<me.getValue().data)
              me.getValue().left=s;
         else
              me.getValue().right=s;
              
              m.put(arr[i],s);         
              i++;
     }
       return root;
   }
}