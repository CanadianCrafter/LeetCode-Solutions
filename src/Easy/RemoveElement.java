package Easy;

import java.io.*;
import java.util.*;

public class RemoveElement {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       int arr[] = {1,1,2};
       System.out.println(removeElement(arr,1));
       System.out.println(Arrays.toString(arr));
       
    }
    public static int removeElement(int[] nums, int val) {
    	int insertIndex = 0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i]!=val) {
    			nums[insertIndex]=nums[i];
    			insertIndex++;
    		}
    	}
    	return insertIndex;
    	
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


