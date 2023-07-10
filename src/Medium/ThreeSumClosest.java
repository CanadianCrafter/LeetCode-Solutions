package Medium;

import java.io.*;
import java.util.*;

public class ThreeSumClosest {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {

    	int arr[] = {4,0,5,-5,3,3,0,-4,-5};
    	System.out.println(threeSumClosest(arr,-2));
    	Arrays.sort(arr);
    	System.out.println(Arrays.toString(arr));

    }

    public static int threeSumClosest(int[] nums, int target) {
    	//Solution One: O(n^2)
    	int closest = Integer.MAX_VALUE;
    	int ans=0;
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length; i++) {
    		int left = i+1;
    		int right = nums.length-1;
    		while(left<right) {
    			int sum = nums[i]+nums[right]+nums[left];
    			int diff = sum-target;
    			if(Math.abs(diff)<closest) {
    				closest=Math.abs(diff);
    				ans = sum;
    			}
    			if(diff>0) right--;
    			else if(diff<0)left++;
    			else {
            		return target;
    			}
    		}
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
