package Medium;

import java.io.*;
import java.util.*;

public class NaryTreeLevelOrderTraversal {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        Node a = new Node (1, new ArrayList<Node>());
        a.children.add(new Node(3, null));
        a.children.add(new Node(4, null));
        a.children.add(new Node(5, null));
        List<List<Integer>> ans = levelOrder(a);
       for(int j =0; j<ans.size(); j++) {
    	   for(int i = 0 ; i < ans.get(j).size(); i++) {
    		   System.out.println(ans.get(j).get(i));
    	   }
       }
    }
    public static List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	if(root==null) return ans;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()) {
        	Pair front = queue.poll();
        	if(ans.size()<front.depth+1) {
        		List<Integer> newLevel  = new ArrayList<Integer>();
        		newLevel.add(front.node.val);
        		ans.add(newLevel);
        	}
        	else {
        		ans.get(front.depth).add(front.node.val);
        	}
        	if(front.node.children!=null) {
        		for(int i = 0 ; i< front.node.children.size();i++) {
            		if(front.node.children.get(i)!=null) {
            			queue.add(new Pair(front.node.children.get(i), front.depth+1));
            		}
            	}
        	}
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
    
    static class Node {
        int val;
        List<Node> children;
        Node() {};
        Node(int val) { this.val = val;}
        Node(int val, List<Node> children) { 
        	this.val = val; 
        	this.children = children;
        }
     }
    
    static class Pair {
        Node node;
        int depth;
        Pair(Node node, int depth) { 
        	this.node = node;
        	this.depth = depth;
        }
     }
}