package Easy;

import java.io.*;
import java.util.*;

public class PowerOfTwo {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       System.out.println(isPowerOfTwo(268435457));
    }
    public static boolean isPowerOfTwo(int n) {
    	//Solution One: O(1);
    	//This works since in binary, every power of two is in the form 0b10000..
    	//and that minus one, is in the form 0b0111111...
    	//So their conjunction is 0. no, non power of two has this property
    	return n>0 && (n & n-1)==0;
    	
    	//Solution Two: Log(n) I think
//    	double log = Math.log(n)/Math.log(2);
//        return Math.abs(log - Math.floor(log))<0.0000000000001;
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


