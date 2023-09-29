package Medium;

import java.io.*;
import java.util.*;

public class SortColours {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       int nums[] = {2,0,2,1,1,0};
       sortColors(nums);
       System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int counts[] = new int[3];
    	for(int i = 0; i < nums.length; i++) {
        	counts[nums[i]]++;
        }
    	int index = 0;
    	for(int i = 0; i < counts.length; i++) {
    		for(int j = 0; j < counts[i]; j++) {
    			nums[index]=i;
    			index++;
            }
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
