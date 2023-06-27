package Medium;

import java.io.*;
import java.util.*;

public class AddTwoNumbers {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode (3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode (4, null)));
        ListNode ans = addTwoNumbers(l1, l2);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = null;
		ListNode head = null;
		int carry = 0;
		
		while(l1!=null || l2!=null ||carry!=0) {
			ListNode digit = new ListNode();
			
			int l1val, l2val;
			l1val = l2val = 0;
			if(l1!=null)l1val=l1.val;
			if(l2!=null)l2val=l2.val;
			
			digit.val=(l1val+l2val+carry)%10;
			carry = (l1val+l2val+carry)/10;
			if(ans==null) {
				ans = digit;
				head = ans;
			}
			else {
				head.next = digit;
				head = digit;
			}
			
			
			l1 = (l1==null ? null:l1.next);
			l2 = (l2==null ? null:l2.next);	
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


