package Medium;

import java.io.*;
import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        TreeNode a = new TreeNode (1, null, new TreeNode(2,new TreeNode(3,null,null),null));
        List<List<Integer>> ans = levelOrderBottom(a);
       for(int j =0; j<ans.size(); j++) {
    	   for(int i = 0 ; i < ans.get(j).size(); i++) {
    		   System.out.println(ans.get(j).get(i));
    	   }
       }
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	if(root==null) return ans;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root,0));
        int maxDepthSoFar = 0;
        while(!queue.isEmpty()) {
        	Pair front = queue.poll();
        	maxDepthSoFar= Math.max(maxDepthSoFar, front.depth);
        	if(ans.size()<front.depth+1) {
        		List<Integer> newLevel  = new ArrayList<Integer>();
        		newLevel.add(front.treeNode.val);
        		ans.add(0, newLevel);
        	}
        	else {
        		ans.get(maxDepthSoFar-front.depth).add(front.treeNode.val);
        	}
        	if(front.treeNode.left!=null) queue.add(new Pair(front.treeNode.left, front.depth+1));
        	if(front.treeNode.right!=null) queue.add(new Pair(front.treeNode.right, front.depth+1));
        	
        }
    	return ans;
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