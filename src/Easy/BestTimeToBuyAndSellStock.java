package Easy;

import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStock  {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String args[]) throws IOException {
    	int arr[] = {7,6,4,3,1};
    	System.out.println(maxProfit(arr));
    }
    
    public static int maxProfit(int[] prices) {
        
        int max = 0;
        int minSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
        	minSoFar = Math.min(minSoFar, prices[i]);
        	max = Math.max(prices[i]-minSoFar, max);
        }
        return max;
        
        
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
