package Easy;

import java.io.*;
import java.util.*;

public class PowerOfThree {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       System.out.println(isPowerOfThree(243));
    }
    public static boolean isPowerOfThree(int n) {
    	//Solution One: 3^19 = 1162261467. its factors are all the valid powers of three 
    	return n>0 && (1162261467%n==0);
    	
    	//Solution Two: Log(n) I think
//    	double log = Math.log(n)/Math.log(3);
//        return Math.abs(log - Math.round(log))<0.0000000001;
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


