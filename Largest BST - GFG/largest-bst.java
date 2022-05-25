// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    int max = Integer.MIN_VALUE;
    // Return the size of the largest sub-tree which is also a BST
    int largestBst(Node root)
    {
        // Write your code here
        
        postOrder(root);
        return max<0 ? 0 : max;
    }
    int[] postOrder(Node root) {
        int arr[] = new int[3];
        if(root==null) {
            arr[0] = Integer.MAX_VALUE;
            arr[1] = Integer.MIN_VALUE;
            arr[2] = 0;
            return arr;
        }
        int left[] = postOrder(root.left);
        int right[] = postOrder(root.right);
        
        if(root.data>left[1]&&root.data<right[0]) {
            max = Math.max(max,1+left[2]+right[2]);
            arr[0] = Math.min(root.data,left[0]);
            arr[1] = Math.max(root.data,right[1]);
            arr[2] = 1+left[2]+right[2];
        }
        else {
            arr[0] = Integer.MIN_VALUE;
            arr[1] = Integer.MAX_VALUE;
            arr[2] = 0;
        }
        return arr;
    }
    
}