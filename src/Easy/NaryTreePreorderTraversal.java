package Easy;

import java.io.*;
import java.util.*;

public class NaryTreePreorderTraversal {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        Node a = new Node (1, new ArrayList<Node>());
        a.children.add(new Node(3, null));
        a.children.add(new Node(4, null));
        a.children.add(new Node(5, null));
        List<Integer> ans = preorder(a);
        for(int i = 0; i < ans.size();i++) {
        	System.out.print(ans.get(i)+" ");
        }
    }
    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        preorderRecursion(root, ans);
    	return ans;
    }
	private static void preorderRecursion(Node root, List<Integer> ans) {
		if(root==null)	return;
		ans.add(root.val);
		if(root.children!=null) {
			for(int i =0; i < root.children.size();i++) {
				if(root.children.get(i)!=null)preorderRecursion(root.children.get(i), ans);
			}
		}
		return;		
		
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
    
    static class Node {
        int val;
        List<Node> children;
        Node() {};
        Node(int val) { this.val = val;}
        Node(int val, List<Node> children) { 
        	this.val = val; 
        	this.children = children;
        }
     }
    
    static class Pair {
        Node node;
        int depth;
        Pair(Node node, int depth) { 
        	this.node = node;
        	this.depth = depth;
        }
     }
}