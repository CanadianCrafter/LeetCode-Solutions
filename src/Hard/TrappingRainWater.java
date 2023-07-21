package Hard;

import java.io.*;
import java.util.*;

public class TrappingRainWater {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       
    }
    public static int trap(int[] height) {
    	int maxLeft[] = new int[height.length];
    	int max = 0;
    	for(int i = 0; i < height.length; i++) {
    		maxLeft[i] = max;
    		max = Math.max(height[i], max);
    	}
    	
    	int maxRight[] = new int[height.length];
    	max = 0;
    	for(int i = height.length-1; i >=0 ; i--) {
    		maxRight[i] = max;
    		max = Math.max(height[i], max);
    	}
    	int ans = 0;
    	for(int i = 0; i < height.length; i++) {
    		ans += Math.max(0, Math.min(maxLeft[i], maxRight[i])-height[i]);
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
