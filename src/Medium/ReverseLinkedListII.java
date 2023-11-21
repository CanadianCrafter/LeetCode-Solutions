package Medium;

import java.io.*;
import java.util.*;

import Medium.AddTwoNumbers.ListNode;

public class ReverseLinkedListII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	ListNode l1 = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode(4, new ListNode(5, null)))));
        ListNode ans = reverseBetween(l1,1,5);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
       
    }
    public static ListNode reverseList(ListNode head) {
    	
		ListNode cur = head;
		ListNode prev = null;
		ListNode next = null;

		while(cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;
		return head;
        
    }
    
    public static ListNode reverseBetween(ListNode head, int left, int right) {
    	ListNode cur = head;
    	int index = 1;
    	for(;index < left-1; index++) {
    		cur = cur.next;
    	}
    	ListNode prefixEnd = cur;
    	ListNode newHead = cur.next;
    	if(left==1) newHead = cur;
    	for(;index < right;index++) {
    		cur = cur.next;
    	}
    	ListNode suffix = cur.next;
    	cur.next = null;
    	
    	ListNode reversed = reverseList(newHead);
    	if(left==1) {
    		head= reversed;
    	}
    	else {
    		prefixEnd.next = reversed;
    	}
    	
    	
    	ListNode suffixHead = head;
    	while(suffixHead.next!=null) {
    		suffixHead = suffixHead.next;
    	}
    	suffixHead.next = suffix;
    	
    	return head;
    	
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