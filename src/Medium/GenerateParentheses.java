package Medium;

import java.io.*;
import java.util.*;

public class GenerateParentheses {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	System.out.println(generateParenthesis(3).toString());
       
    }
    public static List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<String>();
    	generateParenthesis(0,0,n,ans,"");
    	return ans;
    	
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
