package Medium;

import java.io.*;
import java.util.*;

public class SimplifyPath {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(simplifyPath("/home//foo/"));
       
    }
    public static String simplifyPath(String path) {
    	String arr[] = path.split("/");
    	Stack<String> stack = new Stack <String>();
    	
    	for(int i = 0; i < arr.length; i++) {
    		String s = arr[i];
    		if(s.equals("..")) {
    			if(stack.isEmpty())continue;
    			stack.pop();
    		}
    		else if(s.equals(".")||s.length()==0) {
    			continue;
    		}
    		else {
    			stack.add(s);
    		}
    		
    	}
    	String ans = "";
    	if(stack.isEmpty()) ans = "/";
    	while(!stack.isEmpty()) {
    		ans="/" + stack.pop() + ans;
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
    
}


