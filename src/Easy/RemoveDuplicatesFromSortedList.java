package Easy;

import java.io.*;
import java.util.*;

public class RemoveDuplicatesFromSortedList {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode (2, new ListNode (3, new ListNode (3, null)))));
        ListNode ans = deleteDuplicates(l1);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode deleteDuplicates(ListNode head) {
		ListNode start = head;
		int prevVal = Integer.MAX_VALUE;
		ListNode prevNode = null;
		
		
		while(head!=null) {
			if(head.val!=prevVal) {
				if(prevNode==null) prevNode = head;
				else {
					prevNode.next = head;
					prevNode = head;
				}
			}
			prevVal = head.val;
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