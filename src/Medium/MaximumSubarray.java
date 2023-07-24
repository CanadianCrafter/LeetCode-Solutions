package Medium;

import java.io.*;
import java.util.*;

public class MaximumSubarray {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String args[]) throws IOException {
    	int arr[] = {1,2,-1,-2,2,1,-2,1,4,-5,4};
    	System.out.println(maxSubArray(arr));
    }
    
    public static int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 0; i < nums.length; i++) {
        	tmp += nums[i];
        	max = Math.max(tmp, max);
        	tmp = Math.max(0, tmp);
        }
        return max;
        
        
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
