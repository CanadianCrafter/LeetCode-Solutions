package Medium;

import java.io.*;
import java.util.*;

public class RotateList {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode (4, new ListNode (5, null)))));
        ListNode ans = rotateRight(l1, 10);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode rotateRight(ListNode head, int k) {
        int len = listLength(head, 0);
        if(len==0) return head;
        int rot = len-1-k%len;
        ListNode originalHead=head;
        
        for(int i =0; i < rot; i++) {
        	head = head.next;
        }
        ListNode newHead = head.next;
        ListNode mid = head.next;
        head.next = null;
        while(mid!=null&&mid.next!=null) {
        	mid = mid.next;
        }
        
        if(newHead!=null) {
        	mid.next = originalHead;
        	return newHead;
        }
        else {
        	return originalHead;
        }
    }
    
    public static int listLength (ListNode head, int n) {
    	if(head==null) return n;
    	return listLength(head.next, n+1);
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