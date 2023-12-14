package Easy;

import java.io.*;
import java.util.*;

public class UglyNumber {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       System.out.println(isUgly(-35));
    }
    public static boolean isUgly(int n) {
    	if(n==0) return false;
    	if(n==1) return true;
    	while(n%2==0) {
    		n/=2;
    	}
    	while(n%3==0) {
    		n/=3;
    	}
    	while(n%5==0) {
    		n/=5;
    	}
    	return n==1;
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


