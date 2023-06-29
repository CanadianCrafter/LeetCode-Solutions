package Easy;

import java.io.*;
import java.util.*;

public class LongestCommonPrefix {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	String arr[] = {"hi","hil","hirkhi"};
    	System.out.println(longestCommonPrefix(arr));
        
       
    }
    public static String longestCommonPrefix(String[] strs) {
    	String commonPrefix = "";
    	for(int j = 0; j< strs[0].length();j++) {
    		for(int i =0; i< strs.length;i++) {
    			if(j>=strs[i].length()) return commonPrefix;
        		if(strs[i].charAt(j)!=strs[0].charAt(j)) {
        			return commonPrefix;
        		}
        	}
    		commonPrefix+=strs[0].charAt(j);
    	}
    	return commonPrefix;
        
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


