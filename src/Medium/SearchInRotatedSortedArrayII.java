package Medium;

import java.io.*;
import java.util.*;

public class SearchInRotatedSortedArrayII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int height[] = {2,5,6,0,0,1,2};
        System.out.println(search(height,0));
       
    }
    public static boolean search(int[] nums, int target) {
    	int l = 0, r = nums.length-1;
    
    	while(l<=r) {
    		int m = (l+r)/2;
    		if(nums[m]==target) {
    			return true;
    		}
    		if(nums[m]==nums[l]&&nums[m]==nums[r]) {
    			l++;
    			r--;
    			System.out.println(1);
    		}
    		else if(nums[l]<=nums[m]) {
    			if(target>=nums[l]&&target<nums[m]) {
    				r=m-1;
    			}
    			else {
    				l=m+1;
    			}
    		}
    		else {
    			if(target<=nums[r]&&target>nums[m]) {
    				l=m+1;
    			}
    			else {
    				r=m-1;
    			}
    		}
    	}
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
