package Easy;

import java.io.*;
import java.util.*;

public class MinimumDepthOfBinaryTree {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
    	TreeNode a = new TreeNode (1, new TreeNode(2, null, null), new TreeNode(2,new TreeNode(4,null,null),null));
        System.out.println(minDepth(a));
    }
    
    public static int minDepth(TreeNode root) {
    	if(root==null)return 0;
    	return minDepthRecurse(root);
    }
    
    public static int minDepthRecurse(TreeNode root) {
    	if(root==null)return Integer.MAX_VALUE;
    	if(root.left==null && root.right==null) {
    		return 1;
    	}
    	return Math.min(minDepthRecurse(root.left), minDepthRecurse(root.right))+1;
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
