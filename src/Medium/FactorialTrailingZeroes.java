package Medium;

import java.io.*;
import java.util.*;

public class FactorialTrailingZeroes {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {

    	System.out.println(trailingZeroes(6));
    	
    }
    
    public static int trailingZeroes(int n) {
        //Legendre's Formula on 5 since that is the limiting factor (since 2's are always more common than 5's)
    	int ans = 0;
    	int index = 1;
    	while(n>=Math.pow(5, index)) {
    		ans += Math.floorDiv(n, (int) Math.pow(5, index));
    		index++;
    	}
    	return ans;
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
