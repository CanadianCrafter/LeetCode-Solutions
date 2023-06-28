package Medium;

import java.io.*;
import java.util.*;

public class ReverseInteger {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	int ans = reverse(-2147483412);
    	System.out.println(ans);
        
       
    }
    public static int reverse(int x) {
    	int ans = 0;
    	String xStr = Integer.toString(Math.abs(x));
    	String ansStr = "";
    	if(x<0) {
    		ansStr+="-";
    	}
    	if(reversible(x)) {
    		for(int i = xStr.length()-1; i >=0; i--) {
    			ansStr += xStr.charAt(i);
    		}
    	}
    	
    	
    	ans = (ansStr.equals("")||ansStr.equals("-"))?0:Integer.valueOf(ansStr);
    	return ans;
    	
    }
    public static boolean reversible(int x) {
    	String xStr = Integer.toString(Math.abs(x));
    	if(xStr.length()<=9) return true;
    	else if(xStr.length()>10) return false;
    	else {
    		String cmp="";
    		if(x>=0) {
    			cmp = "2147483647";
    		}
    		else {
    			cmp = "2147483648";
    		}
    		for(int i = 0;i<xStr.length();i++) {
    			if(xStr.charAt(xStr.length()-i-1)>cmp.charAt(i)) {
    				return false;
    			}
    			if(xStr.charAt(xStr.length()-i-1)<cmp.charAt(i)) {
    				return true;
    			}
    		}
    		return true;
    		
    	}
    	
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


