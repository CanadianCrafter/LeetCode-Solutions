package Medium;

import java.io.*;
import java.util.*;

public class SumRootToLeafNumbers {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    static int ans = 0;
    
    public static void main(String args[]) throws IOException {
        TreeNode a = new TreeNode (4,new TreeNode(9, new TreeNode(5,null,null), new TreeNode(1,null,null)), new TreeNode(0,null,null));
        System.out.println(sumNumbers(a));
    }
    public static int sumNumbers(TreeNode root) {
    	sumNumbersRecurse(root, 0);
    	return ans;
    }
    public static void sumNumbersRecurse(TreeNode root, int sum) {
    	if(root==null) return ;
    	if(root.left==null&&root.right==null) {
    		ans+=sum*10+root.val;
    		return ;
    	}
    	int val = sum * 10 + root.val;
    	if(root.left!=null) sumNumbersRecurse(root.left, val);
    	if(root.right!=null) sumNumbersRecurse(root.right, val);
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
    
    static class Pair {
        TreeNode treeNode;
        int depth;
        Pair(TreeNode treeNode, int depth) { 
        	this.treeNode = treeNode;
        	this.depth = depth;
        }
     }
}