package Medium;

import java.io.*;
import java.util.*;

public class ZigZagConversion {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       String ans = convert("PAYPALISHIRING",1);
       System.out.println(ans);
        
       
    }
    public static String convert(String s, int numRows) {
    	if(numRows==1) return s;
    	
        String[] rows = new String[numRows];
        for(int i =0; i < numRows;i++) rows[i] = "";
        int row = 0;
        int increment = 1;
        for(int i = 0; i < s.length(); i++) {
        	rows[row]+=s.charAt(i);
        	
        	if(row+increment<0)increment=1;
        	if(row+increment==numRows)increment=-1;
        	row+=increment;        	        		
        	
        }
        String ans = "";
        for(int i = 0; i < numRows; i ++) {
        	ans+=rows[i];
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


