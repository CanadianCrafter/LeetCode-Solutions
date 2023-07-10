package Medium;

import java.io.*;
import java.util.*;

public class FourSum {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	
//    	int arr[] = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
    	int arr[] = {1000000000,1000000000,1000000000,1000000000};
    	List<List<Integer>> ans = fourSum(arr,-294967296);
    	for(int i = 0; i < ans.size(); i++) {
    		for(int j = 0; j < ans.get(i).size(); j++) {
    			System.out.print(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}

    	
    	
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	//Solution One: O(n^3)
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> element = new ArrayList<Integer>();
    	Arrays.sort(nums);
    	int prevValA = Integer.MAX_VALUE; //not safe, but probably fine
    	int prevValB = Integer.MAX_VALUE; //not safe, but probably fine
    	int prevValC = Integer.MAX_VALUE; //not safe, but probably fine
    	int prevValD = Integer.MAX_VALUE; //not safe, but probably fine
    	
    	boolean flag = false;
    	for(int j  = 0; j< nums.length; j++) {
    		if(prevValA==nums[j]) {
    			continue;
    		}
    		for(int i = j+1; i < nums.length; i++) {
        		if(prevValB==nums[i]) {
        			continue;
        		}
        		int left = i+1;
        		int right = nums.length-1;
        		while(left<right) {
        			if(flag&&prevValC==nums[left]&&prevValD==nums[right]) {
        				right--;
                    	left++;
                    	continue;
        			}
        			else {
        				flag=false;
        			}
        			prevValA = nums[j];
                	prevValB = nums[i];
                	prevValC = nums[left];
                	prevValD = nums[right];
        			long sum = (long)(nums[j])+(long)(nums[i])+(long)(nums[right])+(long)(nums[left]);
        			long diff = sum-(long)target;
        			if(diff>0) right--;
        			else if(diff<0)left++;
        			else {
        				element.add(nums[j]);
                		element.add(nums[i]);
                		element.add(nums[right]);
                		element.add(nums[left]);
                		ans.add(List.copyOf(element));
                		element.clear();
                    	right--;
                    	left++;
                    	flag=true;
        			}
        			
        		}
        		prevValC = Integer.MAX_VALUE; //not safe, but probably fine
            	prevValD = Integer.MAX_VALUE; //not safe, but probably fine
        	}
    		prevValB = Integer.MAX_VALUE;
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
