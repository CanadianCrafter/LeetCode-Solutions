package Easy;

import java.io.*;
import java.util.*;

public class AverageOfLevelsInBinaryTree {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        TreeNode a = new TreeNode (3, new TreeNode(9, null, null), new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null)));
    	System.out.println( averageOfLevels(a));
    }
    
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        List<Long> sum = new ArrayList<Long>();
        List<Integer> numOfEach = new ArrayList<Integer>();
        if(root==null) return ans;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		while(!queue.isEmpty()) {
			Pair front = queue.poll();
			if(sum.size()<=front.depth) {
				sum.add(front.depth, (long) front.treeNode.val);
				numOfEach.add(front.depth, 1);
			}
			else {
				sum.set(front.depth,sum.get(front.depth)+front.treeNode.val);
				numOfEach.set(front.depth,numOfEach.get(front.depth)+1);
				
			}
			if(front.treeNode.left!=null) queue.add(new Pair (front.treeNode.left, front.depth+1));
			if(front.treeNode.right!=null) queue.add(new Pair (front.treeNode.right, front.depth+1));
			
		}
		for(int i =0; i<sum.size(); i++) {
			ans.add(((double) sum.get(i))/ numOfEach.get(i));
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