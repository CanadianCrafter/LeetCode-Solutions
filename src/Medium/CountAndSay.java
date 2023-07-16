package Medium;

import java.io.*;
import java.util.*;

public class CountAndSay {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        if(n == 1) return "1";
        
        String str = countAndSay(n-1);
        String output = "";
        char prevChar = '*';
        int prevCount = 0;
        for(int i = 0; i < str.length(); i++) {
        	if(prevChar==str.charAt(i)) prevCount++;
        	else if(prevChar=='*') {
        		prevCount++;
        	}
        	else {
        		output+= prevCount;
        		output+= str.charAt(i-1);
        		prevCount=1;
        	}
        	prevChar = str.charAt(i);
        }
        output+= prevCount;
		output+= str.charAt(str.length()-1);
		return output;
        
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
