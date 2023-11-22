package Medium;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class SingleNumberII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	int arr[] = {2,Integer.MIN_VALUE,2,2};
    	System.out.println(singleNumber(arr));
    	
    }
    public static int singleNumber(int[] nums) {
    	int ans[] = new int[32];
        for(int i = 0 ;i<nums.length;i++) {
        	String bin = Integer.toBinaryString(nums[i]);
        	int binLength = bin.length();
        	if(nums[i]>=0) {
        		for(int j =0; j< 32-binLength;j++) bin = "0"+bin;
        	}
        	else {
        		for(int j =0; j< 32-binLength;j++) bin = "1"+bin;
        	}
        	for(int j =0; j < 32; j++) {
        		ans[j] = (ans[j]+Character.getNumericValue(bin.charAt(j)))%3;
        	}
        }
        if (ans[0]==0) {
        	String result = "";
            for(int i = 0; i < 32; i++) {
            	result+=ans[i];
            }
            return Integer.parseInt(result, 2);
        }
        else {
        	String result = "";
            for(int i = 0; i < 32; i++) {
            	result+=(ans[i]+1)%2;
            }
            
            return -1*Integer.parseInt(result, 2)-1;
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


