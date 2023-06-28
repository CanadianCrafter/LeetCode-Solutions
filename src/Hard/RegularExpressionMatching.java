package Hard;

import java.io.*;
import java.util.*;

public class RegularExpressionMatching {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    
    static ArrayList<Edge> adj[];
    static int numNodes=1;
    
    public static void main(String args[]) throws IOException {
    	System.out.println(isMatch("aa","a*"));
       
    }
    public static boolean isMatch(String s, String oldp) {
    	String p ="";
    	for(int i = 0; i<oldp.length();i++) {
    		if(i>=2&&i<oldp.length()-2&&oldp.charAt(i+1)=='*'&&oldp.charAt(i+1)==oldp.charAt(i-1)&&oldp.charAt(i)==oldp.charAt(i-2)) {
    			i+=1;
    		}
    		else {
    			p+=oldp.charAt(i);
    		}
    	}
    	
    	for(int i = 0; i<p.length();i++) {
    		if(p.charAt(i)!='*')numNodes++;
    	}
    	
    	//adjacency list
		adj = new ArrayList[numNodes];
		for (int i = 0; i < numNodes; i++) adj[i] = new ArrayList<Edge>();
		
		int adjIndex = 0;
		for(int i = 0; i<p.length();i++) {
	    	char pc = p.charAt(i);
	    	if('a'<=pc&&pc<='z') {
    			adj[adjIndex].add(new Edge(adjIndex+1, pc));
	    		adjIndex++;
	    	}
	    	else if(pc=='.') {
    			adj[adjIndex].add(new Edge(adjIndex+1, pc));
	    		adjIndex++;
	    	}
	    	else if(pc=='*') {
	    		if(notRepeat(adjIndex-1, adjIndex, p.charAt(i-1))) {
	    			adj[adjIndex-1].add(new Edge(adjIndex, p.charAt(i-1)));
	    		}
	    		if(notRepeat(adjIndex-1, adjIndex, '*')) {
	    			adj[adjIndex-1].add(new Edge(adjIndex, '*'));
	    		}
	    		if(notRepeat(adjIndex-1, adjIndex-1, p.charAt(i-1))) {
	    			adj[adjIndex-1].add(new Edge(adjIndex-1, p.charAt(i-1)));
	    		}
	    		
	    		
	    	}
	    	
    	}
		for(int i = 0; i < numNodes;i++) {
			System.out.print(i+": " );
			for(int j = 0; j< adj[i].size();j++) {
				System.out.print(String.valueOf(adj[i].get(j).v) + " " + adj[i].get(j).c+"; ");
			}
			System.out.println();
		}
		System.out.println();
    	
    	return isMatchRecursion(s, 0);
    }
    private static boolean notRepeat(int node, int v, char c) {
    	for(int j = 0; j< adj[node].size();j++) {
			if(adj[node].get(j).v==v&&adj[node].get(j).c==c) return false;
		}
    	return true;
	}
	public static boolean isMatchRecursion(String s, int currentState) {
		System.out.println(s+" "+String.valueOf(currentState));
    	if(s.length()==0&&(currentState==numNodes-1)) return true;
    	if(currentState==numNodes) return false;
    	
    	if(s.length()==0) {
    		for(int i =0; i< adj[currentState].size();i++) {
    			if(adj[currentState].get(i).c=='*') {
    				return isMatchRecursion(s, adj[currentState].get(i).v);
    			}
    		}
    		return false;
    	}
    	
    	char sc = s.charAt(0);
    	boolean ans = false;
    	for(int i =0; i< adj[currentState].size();i++) {
    		if(adj[currentState].get(i).c==sc||adj[currentState].get(i).c=='.') {
    			ans=ans||(isMatchRecursion(s.substring(1), adj[currentState].get(i).v));
    		}
    		if(adj[currentState].get(i).c=='*') {
    			ans=ans||(isMatchRecursion(s, adj[currentState].get(i).v));
    		}
    	}

    	return ans;
    }
    
	static class Edge {
		int v; // destination node
		char c; // dfa edge 

		public Edge(int v, char c) {
			this.v = v;
			this.c = c;
		}

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
    
}


