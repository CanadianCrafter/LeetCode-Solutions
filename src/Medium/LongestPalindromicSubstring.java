package Medium;

import java.io.*;
import java.util.*;

public class LongestPalindromicSubstring {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       String ans = longestPalindrome("aaaa");
       System.out.println(ans);
        
       
    }
    public static String longestPalindrome(String s) {
        //Solution 1:
    	int maxLength = 0;
    	String maxString = "";
    	maxString += s.charAt(0);
        for(int i = 0; i < s.length();i++) {
        	int diff = 1;
        	int length = 1;
        	String tempStr = "";
        	tempStr += s.charAt(i);
        	while(i+diff<s.length()&&i-diff>=0) {
        		char c1 = s.charAt(i+diff);
        		char c2 = s.charAt(i-diff);
        		if(c1!=c2) {
        			break;
        		}
        		else {
        			length+=2;
        			tempStr = c2 + tempStr + c1;
        			diff++;
        		}
        	}
        	if(length>maxLength) {
        		maxString = tempStr;
        		maxLength = length;
        	}
        	
        	if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)) {
        		int diff2 = 1;
            	int length2 = 2;
            	String tempStr2 = "";
            	tempStr2 += s.charAt(i);
            	tempStr2 += s.charAt(i+1);
        		while(i+diff2+1<s.length()&&i-diff2>=0) {
            		char c1 = s.charAt(i+diff2+1);
            		char c2 = s.charAt(i-diff2);
            		if(c1!=c2) {
            			break;
            		}
            		else {
            			length2+=2;
            			tempStr2 = c2 + tempStr2 + c1;
            			diff2++;
            		}
            	}
        		if(length2>maxLength) {
            		maxString = tempStr2;
            		maxLength = length2;
            	}
        	}
        }
        
        //Solution 2:
//        int maxLength = 0;
//    	String maxString = "";
//        for(int i = 0; i < s.length();i++) {
//        	int start = i+maxLength;
//        	String temp = maxLength==0?"":s.substring(i,start-1);
//        	for(int j = start; j < s.length();j++) {
//        		temp += s.charAt(j);
//            	if(isPalindromic(temp)) {
//            		if(temp.length()>maxLength) {
//                		maxString = temp;
//                		maxLength = temp.length();
//                	}
//            	}
//            	
//            }
//        }
        
        return maxString;
    
    }
    
    public static boolean isPalindromic(String s) {
    	if(s.length()==0||s.length()==1)return true;
    	if(s.charAt(0)==s.charAt(s.length()-1)) return isPalindromic(s.substring(1,s.length()-1));
    	return false;
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


