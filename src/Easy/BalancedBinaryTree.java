package Easy;

import java.io.*;
import java.util.*;

public class BalancedBinaryTree {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
    	TreeNode a = new TreeNode (1, new TreeNode(2, null, null), new TreeNode(2,null,null));
        System.out.println(isBalanced(a));
    }
    
    public static boolean isBalanced(TreeNode root) {
    	if(root==null)return true;
    	if(root.left==null && root.right==null) {
    		root.val = 1;
    		return true;
    	}
    	boolean children = isBalanced(root.left) && isBalanced(root.right);
    	int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;
        if(Math.abs(left-right)>1) return false;
        else {
        	root.val = Math.max(left, right)+1;
        	return children;
        }
    	
    }
    
//    public static boolean isBalanced(TreeNode root) {
//    	if(root==null) return true;
//        setHeights(root);
//        int left = root.left == null ? 0 : root.left.val;
//        int right = root.right == null ? 0 : root.right.val;
//        if(Math.abs(left-right)>1) return false;
//        else {
//        	return isBalanced(root.left) && isBalanced(root.right);
//        }
//    }
//    
//    public static void setHeights(TreeNode root) {
//    	if(root.left==null && root.right==null) {
//    		root.val = 1;
//    		return;
//    	}
//    	if(root.left!=null)setHeights(root.left);
//    	if(root.right!=null)setHeights(root.right);
//    	int left = root.left == null ? 0 : root.left.val;
//        int right = root.right == null ? 0 : root.right.val;
//    	root.val = Math.max(left,right)+1;
//    	return;
//    }
    
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
