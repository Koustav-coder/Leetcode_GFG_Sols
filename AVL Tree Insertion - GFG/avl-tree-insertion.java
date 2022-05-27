// { Driver Code Starts
import java.io.*;
import java.util.*;

public class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[])
        {
            int ip[] = new int[2000];
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++)
                        {
                            ip[i] = sc.nextInt();
                        }
                        
                    Node root = null;
                    Solution obj = new Solution();
                    for(int i=0; i<n; i++)
                    {
                        root = obj.insertToAVL( root, ip[i] );
                        
                        if ( isBalancedBST(root) == false )
                            break;
                    }
                    
                    printInorder(root);
                    System.out.println();
                    
                }
            
                
        }
}// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    int height;
};
*/
class Solution {
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }
    
    static int calculateBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }
        
        return height(root.left) - height(root.right);
    }
    
    Node rotateRight(Node x) {
        if (x == null) {
            return x;
        }
        
        Node y = x.left;
        Node yR = y.right;
        
        // Perform rotation
        x.left = yR;
        y.right = x;
        
        // Update heights --> order of height updation is important
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        
        return y;
    }
    
    Node rotateLeft(Node x) {
        if (x == null) {
            return x;
        }
        
        Node y = x.right;
        Node yL = y.left;
        
        // Perform Rotation
        x.right = yL;
        y.left = x;
        
        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        
        return y;
    }
    
    
    public  Node insertToAVL(Node root, int data) {
        /* I. Apply Normal BST Insertion */
        
        // Base Case
        if (root == null) {
            return new Node(data);
        }
        
        if (data < root.data) {
            root.left = insertToAVL(root.left, data);
        } else if (data > root.data) {
            root.right = insertToAVL(root.right, data);
        } else { // data == root.data => duplicates are nt allowed
            return root;
        }
        
        /* II. Update current node's height */
        root.height = 1 + Math.max(height(root.left), height(root.right));
        
        /* III. Calculate the Balance Factor of the current node */
        int balance = calculateBalanceFactor(root);
        
        /* IV. Check for cases of rotation */
        
        // Left Imbalance
        if (balance > 1) {
            // Right GrandChild is Greater --> Left Right Imbalance
            if (data > root.left.data) {
                root.left = rotateLeft(root.left);
            }
            // Common step for both LL and LR
            return rotateRight(root);
        }
        
        // Right Imbalance
        if (balance < -1) {
            // Left Grandhild is Lesser --> Right Left Imbalance
            if (data < root.right.data) {
                root.right = rotateRight(root.right);
            }
            // Common step for both RR and RL
            return rotateLeft(root);
        }
        
        return root;
    }
} 