package Hard;

import java.io.*;
import java.util.*;


public class LongestValidParentheses {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(longestValidParentheses(""));
       
    }
    public static int longestValidParentheses(String s) {
    	int maxLength = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i)==')') continue;
    		else {
    			maxLength = Math.max(maxLength, longestValid(s.substring(i)));
    		}
    	}
    	return maxLength;
        
    }
    
    public static int longestValid(String s) {
    	int numLeft = 0;
    	int numRight = 0;
    	int length = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i)==')') numRight++;
    		else numLeft++;
    		if(numRight>numLeft) return length;
    		if(numRight==numLeft) length = numLeft*2;
    	}
    	return length;
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
   
    static class ListNode {
        int val1;
        int val2;
        ListNode(int val1, int val2) { this.val1 = val1; this.val2 = val2; }
    }
    
}


