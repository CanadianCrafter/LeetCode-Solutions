package Medium;

import java.io.*;
import java.util.*;

public class RemoveDuplicatesFromSortedListII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode (1, new ListNode (2, new ListNode (3, null)))));
        ListNode ans = deleteDuplicates(l1);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode deleteDuplicates(ListNode head) {
		ListNode start = null;
		int prevVal = Integer.MAX_VALUE;
		ListNode prevNode = null;
		ListNode prevPrevNode = null;
		
		HashSet blacklist = new HashSet<Integer>();
		
		
		while(head!=null) {
			
			if(!blacklist.contains(head.val)) {
				if(head.val!=prevVal) {
			
					if(start==null||prevNode==null) {
						prevNode = head;
						start=head;
					}
					else {
						prevPrevNode = prevNode;
						prevNode.next = head;
						prevNode = head;
					}
					prevVal = head.val;
				}
				else {
					if(prevPrevNode==null) start=null;
					prevVal = prevPrevNode==null?Integer.MAX_VALUE:prevPrevNode.val;
					prevNode = prevPrevNode;
					if(prevNode!=null)prevNode.next = null;
					blacklist.add(head.val);
				}
			}
			
			head=head.next;
		}
		if(prevNode!=null)prevNode.next = null;
		return start;
        
    }
	static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}