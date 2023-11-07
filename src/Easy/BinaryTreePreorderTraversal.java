package Easy;

import java.io.*;
import java.util.*;

public class BinaryTreePreorderTraversal {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        TreeNode a = new TreeNode (1, null, new TreeNode(2,new TreeNode(3,null,null),null));
       List<Integer> ans = preorderTraversal(a);
       for(int i = 0 ; i < ans.size(); i++)System.out.println(ans.get(i));
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        preorderTraversalRecursion(root, ans);
    	return ans;
    }
	private static void preorderTraversalRecursion(TreeNode root, List<Integer> ans) {
		if(root==null)	return;
		ans.add(root.val);
		preorderTraversalRecursion(root.left, ans);
		preorderTraversalRecursion(root.right, ans);
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