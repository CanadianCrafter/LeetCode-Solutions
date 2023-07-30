package Easy;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class PascalsTriangleII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	List<Integer> ans = getRow(3);
		for(int j = 0; j < ans.size(); j++) {
			System.out.print(ans.get(j)+" ");
		}
		System.out.println();
    }
    public static List<Integer> getRow(int rowIndex) {
        
        	List<Integer> ans = new ArrayList<Integer>();
        	for(int j =0; j <=rowIndex; j++) {
            	ans.add(nCr(rowIndex,j).intValue());
            }
        	return ans;
        
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


