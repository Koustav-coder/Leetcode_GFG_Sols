// { Driver Code Starts
import java.util.*;
 
class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
public class TrieTest
{   private static TrieNode root;
    TrieTest(){
        root = new TrieNode(' '); 
		}
    public static void main(String[] args)
    {   Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		TrieTest z=new TrieTest(); 
		Solution g = new Solution();
		int n=sc.nextInt();
		ArrayList<String> keys=new ArrayList<String>();
		for(int i=0;i<n;i++){
			keys.add(sc.next());}
		for(int i = 0; i < keys.size(); i++)
		{
			insert(keys.get(i));
		}
		String abc=sc.next();
		g.deleteKey(root,abc.toCharArray());
		if(ifExsist(abc)==false)
		    System.out.println("1");
		else
			System.out.println("0");
		}
	}		
	public static boolean ifExsist(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
	public static void insert(String word)
    {
        if (ifExsist(word) == true) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
}// } Driver Code Ends


/*Complete the function below
Node is as follows:
class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}*/
class Solution
{
   
   private static boolean isEmpty(TrieNode root) {
       
       for(int i=0; i<26; i++) {
           if(root.subNode((char)((int)'a'+i)) != null) {
               return false;
           }
       }
       
       return true;
       
   }
   
   private static TrieNode solve(TrieNode root, char[] key, int i) {
       
       //base case
       if(root == null) {
           return null;
       }
       
       if(i== key.length) {
           
           root.isEnd = false;
           if(isEmpty(root)) {
               root = null;
           }
           
           return root;
       }
       
       TrieNode node = root.subNode(key[i]);
       solve(node, key, i+1);
       
       if(isEmpty(root) && !root.isEnd) {
           root = null;
       }
       
       return root;
       
   } 
   
   public static void deleteKey(TrieNode root,char[] key) {
       
       solve(root, key, 0);
       
   }
}