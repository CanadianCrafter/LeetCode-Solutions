package Medium;

import java.io.*;
import java.util.*;

public class RemoveNthNodeFromEndOfList {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static ListNode ans = null;
    
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode (4, new ListNode (5, null)))));
        ListNode ans = removeNthFromEnd(l1, 3);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	ans = head;
    	recurse(head, null, n);
		return ans;
        
    }
    public static int recurse(ListNode cur, ListNode prev, int n) {
    	if(cur==null)return 0;
    	int val = recurse(cur.next, cur, n)+1;
    	if(val==n) {
    		if(prev==null) {
    			ans = cur.next;
    		}else {
    			prev.next=cur.next;
    		}
    	}
		return val;
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