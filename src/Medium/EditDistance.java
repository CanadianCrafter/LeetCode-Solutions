package Medium;

import java.io.*;
import java.util.*;

public class EditDistance {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(minDistance("intention", "execution"));
       
    }
	public static int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		
		for(int row=0; row < word1.length()+1; row++) {
			dp[row][0]=row;
		}
		for(int col=0; col < word2.length()+1; col++) {
			dp[0][col]=col;
		}
		
		for(int row = 1; row < word1.length()+1; row++) {
			for(int col = 1; col < word2.length()+1; col++) {
				if(word1.charAt(row-1)==word2.charAt(col-1)) {
					dp[row][col] = Math.min(dp[row-1][col-1], Math.min(dp[row][col-1],dp[row-1][col])+1);
				}
				else {
					dp[row][col] = Math.min(dp[row-1][col-1], Math.min(dp[row][col-1],dp[row-1][col]))+1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
		
		
		
		//Solution 2: (Too slow)
//		if(word1.length()==0||word2.length()==0) {
//			return Math.abs(word1.length()-word2.length());
//		}
//		if(word1.charAt(0)==word2.charAt(0)) return minDistance(word1.substring(1),word2.substring(1));
//		int v1 = 0, v2 = 0, v3 = 0;
//		v1 = minDistance(word1,word2.substring(1));
//		v2 = minDistance(word1.substring(1),word2);
//		v3 = minDistance(word1.substring(1),word2.substring(1));
//			       
//       return 1+Math.min(v1,Math.min(v2, v3));
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


