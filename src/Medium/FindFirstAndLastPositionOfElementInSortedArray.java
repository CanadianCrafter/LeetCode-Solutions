package Medium;

import java.io.*;
import java.util.*;

public class FindFirstAndLastPositionOfElementInSortedArray {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int height[] = {1,2,3};
        System.out.println(Arrays.toString(searchRange(height,3)));
       
    }
    public static int[] searchRange(int[] nums, int target) {
    	int ans[] = {-1,-1};
    	if(nums.length==0) return ans;
    	int l = 0, r = nums.length-1;
    	int center = 0;
    	while(l<=r) {
    		int m = (l+r)/2;
    		if(nums[m]==target) {
    			center=m;
    			break;
    		}
    		else if(target>nums[m]){
    			l=m+1;
    		}
    		else {
    			r = m-1;
    		}
    	}
    	//find lower bound
    	l=0;
    	r = center;
    	int low = -1;
		while(l<=r) {
    		int m = (l+r)/2;
    		if(nums[m]==target&&m==0) {
    			low = m;
    			break;
    		}
    		else if(m>l&&nums[m]==target&&nums[m-1]<nums[m]) {
    			low = m;
    			break;
    		}
    		else if(m<r&&nums[m+1]==target&&nums[m+1]>nums[m]){
    			low = m+1;
    			break;
    		}
    		else if(nums[m]==target) {
    			r = m-1;
    		}
    		else {
    			l = m+1;
    		}
    	}
		//find higher bound
    	l=center;
    	r = nums.length-1;
    	int high = -1;
		while(l<=r) {
    		int m = (l+r)/2;
    		if(nums[m]==target&&m==nums.length-1) {
    			high=nums.length-1;
    			break;
    		}
    		else if(m<r&&nums[m]==target&&nums[m+1]>nums[m]) {
    			high = m;
    			break;
    		}
    		else if(m>l&&nums[m-1]==target&&nums[m-1]<nums[m]){
    			high = m-1;
    			break;
    		}
    		else if(nums[m]==target) {
    			l = m+1;
    		}
    		else {
    			r = m-1;
    		}
		}
		
		ans[0] = low;
		ans[1] = high;
    	
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
