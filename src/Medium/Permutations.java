package Medium;

import java.io.*;
import java.util.*;

public class Permutations {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {

    	int arr[] = {1,1,2};
    	List<List<Integer>> ans = permute(arr);
    	for(int i = 0; i < ans.size(); i++) {
    		for(int j = 0; j < ans.get(i).size(); j++) {
    			System.out.print(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    	
    }
    
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
        do {
        	List<Integer> temp = new ArrayList<Integer>();
        	for(int i = 0; i < nums.length; i ++) temp.add(nums[i]);
			ans.add(temp);
		}while(nextPermutation(nums));
        return ans;
    }
    
    public static boolean nextPermutation(int[] nums) {
    	if(nums.length <= 1) return false;
		int p = nums.length - 2, q = nums.length - 1;
		while(p >= 0 && nums[p] >= nums[p+1]) p--;
		if(p < 0) return false;
		while(nums[q] <= nums[p]) q--;
		int tmp = nums[p]; nums[p] = nums[q]; nums[q] = tmp;
		for(int l=p+1, r= nums.length-1; l<r; l++, r--) {
			tmp = nums[l]; nums[l] = nums[r]; nums[r] = tmp;
		}
		return true;
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
