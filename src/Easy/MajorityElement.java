package Easy;

import java.io.*;
import java.util.*;

public class MajorityElement  {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String args[]) throws IOException {
    	int a[] = {1,2,3,4,1,1,1,1};
    	System.out.println(majorityElement(a));
    	
    }
    //Implement Boyer-Moore Majority Vote Algorithm
    public static int majorityElement(int[] nums) {
        int ans =0;
        int counter = 0;
        for(int i =0; i < nums.length;i++) {
        	if(counter==0) {
        		ans = nums[i];
        	}
        	if(nums[i]==ans) {
        		counter++;
        	}
        	else {
        		counter--;
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
