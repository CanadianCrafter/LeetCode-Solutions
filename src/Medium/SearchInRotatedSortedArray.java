package Medium;

import java.io.*;
import java.util.*;

public class SearchInRotatedSortedArray {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int height[] = {3,1};
        System.out.println(search(height,3));
       
    }
    public static int search(int[] nums, int target) {
    	int l = 0, r = nums.length-1;
    	int pivot = nums.length-1;
    	if(r==l) {
    		pivot = r;
    	}
    	else {
    		while(l<=r) {
        		int m = (l+r)/2;
        		if(m>l&&nums[m-1]>nums[m]) {
        			pivot = m-1;
        			break;
        		}
        		else if(m<r&&nums[m+1]<nums[m]){
        			pivot = m;
        			break;
        		}
        		else if(nums[l]>=nums[m]) {
        			r = m-1;
        		}
        		else {
        			l = m+1;
        		}
        	}
    	}

    	if(target<nums[0]) {
    		l = pivot+1;
    		r = nums.length-1;
    	}
    	else {
    		l = 0;
    		r = pivot;
    	}
    	while(l<=r) {
    		int m = (l+r)/2;
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
    	return -1;
        
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
