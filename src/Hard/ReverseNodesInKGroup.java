package Hard;

import java.io.*;
import java.util.*;

public class ReverseNodesInKGroup {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode (4, new ListNode(5, new ListNode(6, null))))));
        ListNode ans =reverseKGroup(l1, 3);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
    	
    	if(head==null||head.next==null) {
    		return head;
    	}
    	ListNode nullCheck = head;
    	for(int i = 0; i < k; i++) {
    		if(nullCheck==null) return head;
    		nullCheck = nullCheck.next;
    	}
    	
    	ListNode prev = null;
    	ListNode next = null;
    	ListNode cur = head;
    	for(int i = 0; i < k; i++) {
    		next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	
    	ListNode unchanged = nullCheck;
    	
    	ListNode newHead = prev;
    
    	nullCheck = head;
    	
    	head.next = reverseKGroup(unchanged,k);
    	
    	return newHead;
    	
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