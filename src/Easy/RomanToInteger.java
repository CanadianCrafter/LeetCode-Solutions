package Easy;

import java.io.*;
import java.util.*;

public class RomanToInteger {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	int ans = romanToInt("MCMXCIV");
    	System.out.println(ans);
        
       
    }
    public static int romanToInt(String s) {
    	int ans = 0;

    	for(int i = 0; i < s.length();i++) {
    		if(i<s.length()-1) {
    			if(s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')) {
    				ans-=1;
    				continue;
    			}
    			else if(s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')) {
    				ans-=10;
    				continue;
    			}
    			else if(s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')) {
    				ans-=100;
    				continue;
    			}
    			
    		}
    		if(s.charAt(i)=='I') ans+=1;
			else if(s.charAt(i)=='V') ans+=5;
			else if(s.charAt(i)=='X') ans+=10;
			else if(s.charAt(i)=='L') ans+=50;
			else if(s.charAt(i)=='C') ans+=100;
			else if(s.charAt(i)=='D') ans+=500;
			else if(s.charAt(i)=='M') ans+=1000;
    		
    		
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


