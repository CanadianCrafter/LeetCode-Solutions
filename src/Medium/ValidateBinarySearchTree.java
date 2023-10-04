package Medium;

import java.io.*;
import java.util.*;

public class ValidateBinarySearchTree {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    static TreeNode prev;
    
    public static void main(String args[]) throws IOException {
//        TreeNode a = new TreeNode (0, new TreeNode(4, null, null), new TreeNode(6,new TreeNode(3,null,null),new TreeNode(7,null,null)));
    	TreeNode a = new TreeNode (1, new TreeNode(1, null, null), null);
        System.out.println(isValidBST(a));
       
    }

    public static boolean isValidBST(TreeNode root) {
    	if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(prev!=null&&root.val <= prev.val) {
        	return false;
        }
        prev = root;
        boolean right = isValidBST(root.right);

        return left&& right;
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