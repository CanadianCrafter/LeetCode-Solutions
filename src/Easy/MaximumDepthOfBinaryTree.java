package Easy;

import java.io.*;
import java.util.*;

public class MaximumDepthOfBinaryTree {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    static int maxDepth;
    public static void main(String args[]) throws IOException {
        TreeNode a = new TreeNode (1, null, new TreeNode(2,new TreeNode(3,null,null),null));
        System.out.println(maxDepth(a));
    }
    
	
	public static int maxDepth(TreeNode root) {
		maxDepthRecursion(root, 1);
		return maxDepth;
    }
	private static void maxDepthRecursion(TreeNode root, int curDepth) {
		if(root==null)	return;
		maxDepthRecursion(root.left, curDepth+1);
		maxDepth = Math.max(maxDepth, curDepth);
		maxDepthRecursion(root.right, curDepth+1);
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
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { 
        	this.val = val; 
        	this.left = left; 
        	this.right = right;
        }
     }
}