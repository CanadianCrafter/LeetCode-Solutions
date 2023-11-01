package Easy;

import java.io.*;
import java.util.*;


public class LinkedListCycle {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	ListNode l2 = new ListNode(5, null);
    	ListNode l1 = new ListNode(2, new ListNode(4, new ListNode (3, l2)));
    	l2.next = l1;
        
        System.out.println(hasCycle(l1));
    }
    public static boolean hasCycle(ListNode head) {
    	
    	while(head!=null) {
    		if(head.val==10001) {
    			//10001 is a visited flag and outside the valid range of values
    			return true;
    		}
    		head.val = 10001;
    		head = head.next;
    	}
    	return false;
        
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