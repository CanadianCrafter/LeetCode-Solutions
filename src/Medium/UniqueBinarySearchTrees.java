package Medium;

import java.io.*;
import java.util.*;

public class UniqueBinarySearchTrees {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {

    	System.out.println(numTrees(19));
    }
    
    public static int numTrees(int n) {
        //Calculate catalan number of n+1
    	double ans = 1;
    	for(int i = 1, j = 2*n; i <=n;i++, j--) {
    		if(j>n+1) ans*= j;
    		ans/=i;
    	}
    	return (int) ans;
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
