package Medium;

import java.io.*;
import java.util.*;

public class ContainerWithMostWater {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int height[] = {1,2,1};
        System.out.println(maxArea(height));
       
    }
    public static int maxArea(int[] height) {
    	//Solution 1: O(n)
    	int max = 0;
    	int left = 0;
    	int right = height.length-1;
    	while(right>left) {
    		max = Math.max(max, (Math.abs(right-left))*Math.min(height[left], height[right]));
    		if(height[left]>=height[right]) right--;
			else left++;
    	}
    	return max;
    	
    	//Solution 2: O(n^2)
//    	int max = 0;
//    	for(int i = 0; i < height.length;i++) {
//    		if(height[i]*height.length<max) continue;
//    		for(int j = i; j < height.length;j++) {
//    			max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
//    		}
//    	}
//    	return max;
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
