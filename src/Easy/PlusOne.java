package Easy;

import java.io.*;
import java.util.*;

public class PlusOne {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       
    }
    public static int[] plusOne(int[] digits) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        int carry = 0;
        digits[digits.length-1]++;
        for(int i = digits.length-1;i>=0; i--) {
        	tmp.add((digits[i]+carry)%10);
        	carry = (digits[i]+carry)/10;
        }
        if(carry!=0) tmp.add(carry);
        Collections.reverse(tmp);
        int ans[]  = new int[tmp.size()];
        for(int i = 0; i <tmp.size();i++) ans[i] = tmp.get(i);
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


