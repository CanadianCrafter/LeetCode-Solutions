package Hard;

import java.io.*;
import java.util.*;

import javax.swing.event.ListSelectionEvent;


public class MergeKSortedLists {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
//        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode (4, null)));
//        ListNode l2 = new ListNode(2, new ListNode(2, new ListNode (7, null)));
    	ListNode l1 = new ListNode(1, null);
        ListNode lists[] = new ListNode[1];
        lists[0] = l1;
//        lists[1]=l2;
        ListNode ans = mergeKLists(lists);
        while(ans!=null) {
        	System.out.print(ans.val + ", ");
        	ans = ans.next;
        }
        
       
    }
    public static ListNode mergeKLists(ListNode[] lists) {
    	ListNode head = new ListNode();
    	ListNode prev = new ListNode();
    	lists =removeNullLists(lists);
    	if(lists.length==0) {
    		return null;
    	}
    	int minIndex = getIndexOfMin(lists);
    	head = lists[minIndex];
		prev = head;
		lists[minIndex]=lists[minIndex].next;
		lists=removeNullLists(lists);
    	while(lists.length!=0) {
    		minIndex = getIndexOfMin(lists);
    		prev.next = lists[minIndex];
    		prev = prev.next;
    		lists[minIndex]=lists[minIndex].next;
    		lists=removeNullLists(lists);
    	}
    	return head;
        
    }
	private static ListNode[] removeNullLists(ListNode[] lists) {
		ArrayList<ListNode> temp = new ArrayList<ListNode>();
		for(int i =0; i < lists.length; i++) {
			if(lists[i]!=null) {
				temp.add(lists[i]);
			}
		}
		ListNode nullFreeLists[] = temp.toArray(new ListNode[0]);
		
		return nullFreeLists;
	}
	public static int getIndexOfMin (ListNode[] lists) {
		int min=Integer.MAX_VALUE;
		int index=-1;
		for(int i =0; i < lists.length; i++) {
			if(lists[i].val<min) {
				min = lists[i].val;
				index=i;
			}
		}
		return index;
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