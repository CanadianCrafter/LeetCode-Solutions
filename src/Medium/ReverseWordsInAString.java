package Medium;

import java.io.*;
import java.util.*;

public class ReverseWordsInAString {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {
    	String s = "the     sky is blue";
    	System.out.println(reverseWords(s));
    }
    
    public static String reverseWords(String s) {
        String arr[] = s.split(" +");
        String ans = "";
        for(int i = arr.length-1 ; i >=0 ; i--) {
        	ans+=arr[i];
        	ans+=" ";
        }
        return ans.trim();
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
