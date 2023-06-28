package Easy;

import java.io.*;
import java.util.*;

public class PalindromeNumber {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
        System.out.println(isPalindrome(123454321));
       
    }
    public static boolean isPalindrome(int x) {
    	String xStr = Integer.toString(x);
    	for(int i = 0; i < xStr.length();i++) {
    		if(xStr.charAt(i)!=xStr.charAt(xStr.length()-1-i))return false;
    	}
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
