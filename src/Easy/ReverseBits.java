package Easy;

import java.io.*;
import java.util.*;

public class ReverseBits {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(reverseBits(10));
    	
    }
    public static int reverseBits(int n) {
    	//Solution One: Use masking to shift a portion of the number, and mask out another portion and use OR to combine it
    	// with a different portion of the number, shifted into the masked part.
    	//Note that parantheses are important caues >>> has higher precedence than &
    	n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
    	n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
    	n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
    	n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
    	n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
    	return n;
    	
    	//Solution Two: Straightforward Int to Binary String
//        String str = Integer.toBinaryString(n);
//        while(str.length()<32) {
//        	str = "0"+str;
//        }
//        String strReversed = "";
//        for(int i =0; i < str.length();i++) {
//        	strReversed = str.charAt(i)+ strReversed;
//        }
//        if(strReversed.charAt(0)=='0') return Integer.parseInt(strReversed,2);
//        else {
//        	String posStr = "";
//        	for(int i =0; i < str.length();i++) {
//            	posStr += (Character.getNumericValue(strReversed.charAt(i))+1)%2;
//        	}
//        	return -1* Integer.parseInt(posStr,2)-1;
//        }
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


