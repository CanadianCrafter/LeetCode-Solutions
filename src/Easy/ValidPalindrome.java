package Easy;

import java.io.*;
import java.util.*;

public class ValidPalindrome {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
       
    }
    public static boolean isPalindrome(String s) {
    	//Solution Two: Two Pointers, One Pass
    	int left = 0, right = s.length()-1;
    	while(left<=right) {
    		char cl = s.charAt(left);
    		char cr = s.charAt(right);
    		if(!(('0'<=cl&&cl<='9')||('A'<=cl&&cl<='Z') || ('a'<=cl&&cl<='z'))) {
    			left++;
    			continue;
    		}
    		if(!(('0'<=cr&&cr<='9')||('A'<=cr&&cr<='Z') || ('a'<=cr&&cr<='z'))) {
    			right--;
    			continue;
    		}
    		if('0'<=cl&&cl<='9') {
    			if(cl!=cr) return false;
    			left++;
    			right--;
    		}
    		else {
    			if(!String.valueOf(cl).equalsIgnoreCase(String.valueOf(cr))) {
    				return false;
    			}
    			left++;
    			right--;
    		}
    	}
    	return true;
    	
    	
    	//Solution One: (Two Passes)
//    	String cleanStr = "";
//    	for(int i = 0; i < s.length(); i ++) {
//    		char c = s.charAt(i);
//    		if('0'<=c&&c<='9') {
//    			cleanStr+=c;
//    		}
//    		else if('A'<=c&&c<='Z'){
//    			cleanStr+= (char)(((int) c)-((int) 'A') + ((int)'a'));
//    		}
//    		else if('a'<=c&&c<='z'){
//    			cleanStr+= c;
//    		}
//    	}
//    	for(int i = 0; i < cleanStr.length();i++) {
//    		if(cleanStr.charAt(i)!=cleanStr.charAt(cleanStr.length()-1-i))return false;
//    	}
//    	return true;
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
