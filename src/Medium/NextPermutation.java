package Medium;

import java.io.*;
import java.util.*;

public class NextPermutation {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {

    	int arr[] = {5,4,3,2};
    	nextPermutation(arr);
    	System.out.println(Arrays.toString(arr));
    }
    
    public static void nextPermutation(int[] nums) {
    	if(nums.length <= 1) return;
		int p = nums.length - 2, q = nums.length - 1;
		while(p >= 0 && nums[p] >= nums[p+1]) p--;
		if(p < 0) {
			//reverse nums to get smallest
			for(int i = 0; i < nums.length/2;i++) {
				int swap = nums[i];
				nums[i] = nums[nums.length-1-i];
				nums[nums.length-1-i] = swap;
			}
			return;
		}
		while(nums[q] <= nums[p]) q--;
		int tmp = nums[p]; nums[p] = nums[q]; nums[q] = tmp;
		for(int l=p+1, r= nums.length-1; l<r; l++, r--) {
			tmp = nums[l]; nums[l] = nums[r]; nums[r] = tmp;
		}
		return;
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
