package Medium;

import java.io.*;
import java.util.*;

public class PowXN {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	System.out.println(myPow(10,-2));
       
    }
    public static double myPow(double x, int n) {
    	if(n==Integer.MIN_VALUE) return myPow2(1/x,x, n+1);
        return myPow2(1, x, n);
        
    }
    public static double myPow2(double y, double x, int n) {
        if(n<0) {
        	return myPow2(y, 1/x, -n);
        }
    	else if(n==0) return y;
        else if((((n%2)+2)%2)==0) {
        	return myPow2(y, x*x, n/2);
        }
        else {
        	return myPow2(x*y, x*x, (n-1)/2);
        }
        
    }
    
    public static void generateParenthesis(int numLeft, int numRight, int n, List<String> ans, String s) {
    	if(numLeft==n&&numRight==n) {
    		ans.add(s);
    		return;
    	}
    	if(numLeft<n) {
    		generateParenthesis(numLeft+1, numRight, n, ans, s+"(");
    	}
    	if(numRight<numLeft) {
    		generateParenthesis(numLeft, numRight+1, n, ans, s+")");
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
