package Hard;

import java.io.*;
import java.util.*;

public class PermutationSequence {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {

    	System.out.println(getPermutation(3,3));
    	
    }
    
    public static String getPermutation(int n, int k) {
    	int arr[] = new int[n];
    	for(int i =1;i<=n;i++)arr[i-1]=i;
        for(int i = 0; i<k-1;i++) {
        	nextPermutation(arr);
        }
        String str = "";
        for(int i =0;i<n;i++)str+=arr[i];
        return str;
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
