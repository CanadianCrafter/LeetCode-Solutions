package Easy;

import java.io.*;
import java.util.*;

public class AddBinary {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       System.out.println(addBinary("1010","1011"));
    }
    public static String addBinary(String a, String b) {
        String ans = "";
        
        int carry = 0;
        int index = 0;
        while(index<a.length()&&index<b.length()) {
        	int n = Character.getNumericValue(a.charAt(a.length()-1-index))+Character.getNumericValue(b.charAt(b.length()-1-index))+carry;
        	carry = n/2;
        	ans = n%2 + ans;
        	index++;
        }
        while(index<a.length()) {
        	int n = Character.getNumericValue(a.charAt(a.length()-1-index))+carry;
        	carry = n/2;
        	ans = n%2 + ans;
        	index++;
        }
        while(index<b.length()) {
        	int n = Character.getNumericValue(b.charAt(b.length()-1-index))+carry;
        	carry = n/2;
        	ans = n%2 + ans;
        	index++;
        }
        if(carry!=0)ans = carry + ans;
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


