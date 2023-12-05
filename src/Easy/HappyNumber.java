package Easy;

import java.io.*;
import java.util.*;

public class HappyNumber {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(isHappy(19));
    	
    }
   
    public static boolean isHappy(int n) {
        HashSet<Integer> vis = new HashSet<Integer>();
        do {
        	int newN = 0;
        	while(n>0) {
        		newN += Math.pow(n%10,2);
        		n/=10;
        	}
        	n = newN;
        	if(vis.contains(newN)) break;
        	vis.add(newN);
        	
        }while(n!=1);
        
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


