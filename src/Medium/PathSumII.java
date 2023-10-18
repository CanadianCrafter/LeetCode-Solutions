package Medium;

import java.io.*;
import java.util.*;

public class PathSumII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        TreeNode a = new TreeNode (3, new TreeNode(5, new TreeNode(6, null, null), new TreeNode(4, null, null)), new TreeNode(2,null,new TreeNode(1, null, null)));

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans= pathSum(a,6);
        
        for(int i = 0; i < ans.size();i++) {
        	for(int j = 0; j < ans.get(i).size();j++) {
        		System.out.print(ans.get(i).get(j) + " ");
        	}
        	System.out.println();
        }
       
    }
    
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null)return ans;
        List<Integer> temp = new ArrayList<Integer>();
        pathSumRecursion(ans, root, 0, targetSum, temp);
        return ans;
    }
    
    public static void pathSumRecursion(List<List<Integer>> ans, TreeNode root, int curSum, int targetSum, List<Integer> tempAns) {
    	if(root==null) return;
    	curSum+=root.val;
    	tempAns.add(root.val);
    	if(root.left==null&&root.right==null) {
    		if(curSum==targetSum) {
    			List<Integer> copy = new ArrayList(tempAns);
    			ans.add(copy);
    		}
        	return;
        }
        
        pathSumRecursion(ans, root.left, curSum, targetSum, tempAns);
        if(root.left!=null)tempAns.remove(tempAns.size()-1);
        pathSumRecursion(ans, root.right, curSum, targetSum, tempAns);
        if(root.right!=null)tempAns.remove(tempAns.size()-1);
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