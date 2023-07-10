package Easy;

import java.io.*;
import java.util.*;

public class MergeTwoSortedLists {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static ListNode ans = null;
    
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode (4, new ListNode (5, null)))));
        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode (7, new ListNode (8, new ListNode (10, null)))));
        ListNode ans = mergeTwoLists(l1, l2);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	ListNode head = new ListNode();
    	ListNode prev = new ListNode();
    	if(list1==null&&list2==null) {
    		return null;
    	}
    	if(list1==null) {
    		return list2;
    	}
    	if(list2==null) {
    		return list1;
    	}
    	if(list1.val <= list2.val) {
    		head = list1;
    		prev = head;
    		list1=list1.next;
    	}
    	else {
    		head = list2;
    		prev=head;
    		list2=list2.next;
    	}
    	while(list1!=null&&list2!=null) {
    		if(list1.val <= list2.val) {
        		prev.next = list1;
        		prev = prev.next;
        		list1=list1.next;
        	}
    		else {
    			prev.next = list2;
        		prev = prev.next;
        		list2=list2.next;
    		}
    	}
    	if(list1!=null) {
    		prev.next = list1;
    	}
    	if(list2!=null) {
    		prev.next = list2;
    	}
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