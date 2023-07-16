package Hard;

import java.io.*;
import java.util.*;

public class FirstMissingPositive {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static void main(String args[]) throws IOException {
    	int arr[]  = {3,4,-1,1,2,2,2,2};
    	System.out.println(firstMissingPositive(arr));
    }
    
    public static int firstMissingPositive(int[] nums) {
    	int n = nums.length;
    	int index = 0;
    	int num = nums[index];
        while(index<nums.length) {
        	if(num>n|| num<=0) {
        		nums[index] = -1;
        		index++;
        		if(index==nums.length) break;
        		num = nums[index];
        	}
        	else {
        		int tmp = nums[num-1];
        		nums[num-1] = num;
        		if(num!=tmp) {
        			num=tmp;
        		}
        		else {
        			index++;
        			if(index==nums.length) break;
            		num = nums[index];
        		}
        	
        		
        	}
        	
        }
//        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i ++) {
        	if(nums[i]!=i+1) return i+1;
        }
        return n+1;
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
