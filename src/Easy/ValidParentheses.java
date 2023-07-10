package Easy;

import java.io.*;
import java.util.*;

public class ValidParentheses {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(isValid("()()()())"));
       
    }
    public static boolean isValid(String s) {
    	Stack<Character> stack = new Stack <Character>();
    	
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(c=='('||c=='['||c=='{') {
    			stack.push(c);
    		}
    		else if(c==')'||c==']'||c=='}') {
    			if(stack.size()==0) return false;
    			char match = stack.pop();
    			if(match=='(') {
    				if(c!=')') return false;
    			}
    			else if(match=='[') {
    				if(c!=']') return false;
    			}
    			else if(match=='{') {
    				if(c!='}') return false;
    			}
    				
    		}
    	}
    	if(stack.size()!=0) return false;
    	return true;
    	
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


