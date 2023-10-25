package Easy;

import java.io.*;
import java.util.*;

public class SingleNumber {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	int arr[] = {1,2,3,4,3,4,2};
    	System.out.println(singleNumber(arr));
    	
    }
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0 ;i<nums.length;i++) {
        	ans ^= nums[i];
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


