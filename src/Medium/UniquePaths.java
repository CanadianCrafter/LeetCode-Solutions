package Medium;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class UniquePaths {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	System.out.println(uniquePaths(23,12));
    }
    public static int uniquePaths(int m, int n) {
        return nCr(m-1+n-1,Math.min(m, n)-1).intValue();
    }
    
    public static BigInteger nCr (int n, int r) {
    	return factorial(n).divide(factorial(r).multiply(factorial(n-r)));
    }
    
	private static BigInteger factorial(int n) {
		if(n==0) return new BigInteger("1");
		return factorial(n-1).multiply(BigInteger.valueOf(n));
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
