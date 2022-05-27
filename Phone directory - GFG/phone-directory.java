// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Node {
	Node links[];
	boolean flag;
	ArrayList<Integer> index;
	public Node() {
		links=new Node[26];
		flag=false;
		index=new ArrayList<>();
	}
	void putIndex(int i){
        index.add(i);
    }
    ArrayList<Integer> getIndexes(){
        return index;
    }
	boolean contains(char c) {
		return links[c-'a']!=null;
	}
	
	void put(char c, Node node) {
		links[c-'a']=node;
	}
	
	Node get(char c) {
		return links[c-'a'];
	}
	
	void setEnd() {
		flag=true;
	}
	
	boolean getEnd() {
		return flag;
	}
}

class Pair{
	boolean isMatch;
	ArrayList<Integer> idxs;
	public Pair(boolean isMatch, ArrayList<Integer> idxs) {
		this.isMatch=isMatch;
		this.idxs=idxs;
	}
}
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String str)
    {
        Node root = new Node();
		int i = 0;
		for (String s : contact) {
			insert(s, root, i++);
		}
		int len = str.length();
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for (i = 1; i <= len; i++) {
			Set<String> ll = new TreeSet<>();
			Pair p=search(str.substring(0, i), root);
			if (p.isMatch) {
				for(int idx: p.idxs) {
					ll.add(contact[idx]);
				}
			}
			if(ll.isEmpty()) ll.add("0");
			list.add(new ArrayList<>(ll));
		}
		return list;
    }
    static void insert(String s, Node root, int i) {
		Node node = root;
		for (char c : s.toCharArray()) {
			if (!node.contains(c))
				node.put(c, new Node());
			node = node.get(c);
			node.putIndex(i);
		}
		node.setEnd();
	}

	static Pair search(String s, Node root) {
		Node node = root;
		for (char c : s.toCharArray()) {
			if (!node.contains(c))
				return new Pair(false, new ArrayList<Integer>());
			node = node.get(c);
		}
		return new Pair(true, node.getIndexes());
	}
}