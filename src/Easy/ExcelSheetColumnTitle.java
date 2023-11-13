package Easy;

import java.io.*;
import java.util.*;

public class ExcelSheetColumnTitle  {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String args[]) throws IOException {
    	System.out.println(convertToTitle(28));
    	
    }

    public static String convertToTitle(int columnNumber) {
    	String ans = "";
    	while(columnNumber>0) {
    		columnNumber--;
    		ans= (char)((int)('A') + (columnNumber%26))+ans;
    		columnNumber/=26;
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
