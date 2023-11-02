package Medium;

import java.io.*;
import java.util.*;

public class PartitionList {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode (3, new ListNode(5, new ListNode(6, new ListNode (4, null))))));
        ListNode l2 = new ListNode(1, null);
        ListNode ans = partition(l2, 0);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
	public static ListNode partition(ListNode head, int x) {
		if(head==null) return null;
		ListNode lowerHead = null;
		ListNode higherHead = null;
		ListNode lower = null;
		ListNode higher = null;
        while(head!=null) {
        	if(head.val < x) {
        		if(lowerHead==null) {
        			ListNode newNode = new ListNode(head.val);
        			lower = newNode;
        			lowerHead = lower;
        		}
        		else {
        			ListNode newNode = new ListNode(head.val);
        			lower.next = newNode;
        			lower = lower.next;
        		}
        	}
        	else {
        		if(higherHead==null) {
        			ListNode newNode = new ListNode(head.val);
        			higher = newNode;
        			higherHead = higher;
        		}
        		else {
        			ListNode newNode = new ListNode(head.val);
        			higher.next = newNode;
        			higher = higher.next;
        		}
        	}
        	head = head.next;
        }
        ListNode ans= new ListNode();
        if(lowerHead==null&&higherHead==null) return null;
        if(lowerHead!=null) {
        	ans = lowerHead;
        	lower.next = higherHead;
        }
        else if(higherHead!=null){
        	ans = higherHead;
        }
    	return ans;
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