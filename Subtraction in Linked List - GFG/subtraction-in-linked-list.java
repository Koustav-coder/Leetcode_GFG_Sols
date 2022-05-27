// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    static Node removeLeadingZeros(Node a)
   {
       if (a != null && a.data == 0)
           return removeLeadingZeros(a.next);
       else
           return a;
   }

   static Node reverse(Node head)
   {
       Node prev = null, curr = head, ptr = null;
       while(curr!=null)
       {
           ptr = curr.next;
           curr.next = prev;
           prev = curr;
           curr = ptr;
       }
       return prev;
   }
   
   static Node subLinkedList(Node head1, Node head2)
   {
       head1 = removeLeadingZeros(head1);
       head2 = removeLeadingZeros(head2);
       Node temp1 = head1, temp2 = head2;
       
       // checking which LL represents larger number
       int l1=0, l2=0;
       while(temp1!=null)
       {
           l1++;
           temp1 = temp1.next;
       }
       while(temp2!=null)
       {
           l2++;
           temp2 = temp2.next;
       }
       temp1 = head1; temp2 = head2;
       
       if(l1>l2)
       {
           temp1 = head1;
           temp2 = head2;
       }
       else if(l1<l2)
       {
           temp1 = head2;
           temp2 = head1;
       }
       else // if both have equal length
       {
           while (temp1 != null && temp2 != null)
           {
               if (temp1.data > temp2.data)
               {
                   temp1 = head1;
                   temp2 = head2;
                   break;
               }
               else if(temp1.data < temp2.data)
               {
                   temp1 = head2;
                   temp2 = head1;
                   break;
               }
               temp1 = temp1.next;
               temp2 = temp2.next;
           }
           
           if(temp1==null && temp2==null) return new Node(0); // both represents equal number
       }
       
       // subtraction code
       temp1 = reverse(temp1);
       temp2 = reverse(temp2);
       
       Node dummy = new Node(-1);
       Node t = dummy;
       
       int borrow=0, subtraction, temp1data;
       while(temp1!=null)
       {
           temp1data = temp1.data;
           if(borrow==1)
           {
               temp1data = temp1.data - 1;
               borrow = 0;
           }
           if(temp1data < (temp2!=null ? temp2.data : 0))
           {
               temp1data = temp1data + 10;
               borrow = 1;
           }
           
           subtraction = temp1data - (temp2!=null ? temp2.data : 0);
           
           t.next = new Node(subtraction);
           t = t.next;
           
           temp1 = temp1.next;
           if(temp2!=null) temp2 = temp2.next;
       }
       
       dummy = dummy.next;
       dummy = reverse(dummy);
       dummy = removeLeadingZeros(dummy);

       return dummy;
   }
}