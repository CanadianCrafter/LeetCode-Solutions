package Medium;

import java.io.*;
import java.util.*;

public class SwapNodesInPairs {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode (4, new ListNode(5, null)))));
        ListNode ans =swapPairs(l1);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode swapPairs(ListNode head) {
    	
    	if(head==null||head.next==null) {
    		return head;
    	}
    	
    	ListNode unchanged = head.next.next;
    	
    	ListNode newHead = head.next;
    	
    	head.next.next = head;
    	
    	head.next = swapPairs(unchanged);
    	
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