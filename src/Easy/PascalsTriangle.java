package Easy;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class PascalsTriangle {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	List<List<Integer>> ans = generate(5);
    	for(int i = 0; i < ans.size(); i++) {
    		for(int j = 0; j < ans.get(i).size(); j++) {
    			System.out.print(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i =0; i <numRows; i++) {
        	List<Integer> row = new ArrayList<Integer>();
        	for(int j =0; j <=i; j++) {
            	row.add(nCr(i,j).intValue());
            }
        	ans.add(row);
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


