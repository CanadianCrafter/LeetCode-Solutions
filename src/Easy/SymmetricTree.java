package Easy;

import java.io.*;
import java.util.*;

public class SymmetricTree {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        TreeNode a = new TreeNode (1, new TreeNode(2, null, null), new TreeNode(2,null,null));
        System.out.println(isSymmetric(a));
       
    }
    
    public static boolean isSymmetric(TreeNode root) {
    	if(root==null) return true;
    	return isSymmetricBranches(root.right, root.left);
    }
    
    public static boolean isSymmetricBranches(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        
        return isSymmetricBranches(p.right, q.left) && isSymmetricBranches(p.left, q.right);
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