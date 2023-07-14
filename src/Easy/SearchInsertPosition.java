package Easy;

import java.io.*;
import java.util.*;

public class SearchInsertPosition {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int height[] = {1,3,5,6};
        System.out.println(searchInsert(height,0));
       
    }
    public static int searchInsert(int[] nums, int target) {
    	int l = 0, r = nums.length-1;
    	int m = 0;
    	while(l<=r) {
    		m = (l+r)/2;
    		if(nums[m]==target) {
    			return m;
    		}
    		else if(target>nums[m]){
    			l=m+1;
    		}
    		else {
    			r = m-1;
    		}
    	}
    	return nums[m]>=target?m:m+1;
        
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
