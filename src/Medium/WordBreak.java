package Medium;

import java.io.*;
import java.util.*;

public class WordBreak {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static char board[][];
    static String word;
    public static void main(String args[]) throws IOException {
    	List<String> wordDict = new ArrayList<String>();
    	wordDict.add("leet");
    	wordDict.add("code");
    	System.out.println(wordBreak("leetcode",wordDict));
    }
    
    public static boolean wordBreak(String s, List<String> wordDict) {
    	boolean dp[] = new boolean[s.length()+1];
    	dp[0]=true;
    	for(int i = 0; i <= s.length();i++) {
    		for(int j =i; j>=0;j--) {
    			if(dp[j]&&wordDict.contains(s.substring(j,i))) {
    				dp[i]=true;
    				break;
    			}
    		}
    	}
    	return dp[s.length()];
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
