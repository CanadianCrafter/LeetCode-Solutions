package Easy;

import java.io.*;
import java.util.*;

public class TwoSum {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
        int nums[] = {3,2,4};
        int target = 6;
        int ans[] = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
       
    }
    private static int[] twoSum(int[] nums, int target) {
    	int ans[] = new int[2];
    	
    	//Solution 1: Using a Hashmap O(n)
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i =0; i< nums.length;i++) {
    		map.put(nums[i], i);
    	}
    	for(int i =0; i< nums.length;i++) {
    		int complement = target - nums[i];
    		if(map.containsKey(complement)&&map.get(complement)!=i) {
    			ans[0]=i;
				ans[1]=map.get(complement);
				return ans;
    		}   		
    	}
		
//    	//Solution 2: Bruteforce O(n^2)
//		for(int i = 0;i<nums.length-1;i++) {
//			for(int j = i+1;j<nums.length;j++) {
//				if(nums[i]+nums[j]==target) {
//					ans[0]=i;
//					ans[1]=j;
//					return ans;
//				}
//			}
//		}
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
