package Easy;

import java.io.*;
import java.util.*;

public class NumberOf1Bits {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(hammingWeight(10));
    	
    }
    public static int hammingWeight(int n) {
        int ans = 0;
        while(n!=0) {
        	ans+=(n & 1);
        	n >>>= 1;
        }
        return ans;
    	
    	
    	//Solution 2: Integer to String
//    	String str = Integer.toBinaryString(n);
//        int ans = 0;
//        for(int i =0; i < str.length();i++) {
//        	ans+=Character.getNumericValue(str.charAt(i));
//        }
//        return ans;
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


