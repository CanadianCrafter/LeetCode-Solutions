package Easy;

import java.io.*;
import java.util.*;

public class MergeSortedArray {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    
    public static void main(String args[]) throws IOException {
        
       
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int temp[] = new int[m+n];
    	int index=0;
        int index1  = 0;
        int index2 = 0;
        while(index1 <m && index2<n) {
        	if(nums1[index1]<=nums2[index2]) {
        		temp[index]=nums1[index1];
        		index1++;
        	}
        	else {
        		temp[index]=nums2[index2];
        		index2++;
        	}
        	index++;
        }
        if(index1<m) {
        	temp[index]=nums1[index1];
    		index1++;
    		index++;
        }
        if(index2<n) {
        	temp[index]=nums2[index2];
    		index2++;
    		index++;
        }
        for(int i = 0; i < m+n; i ++) {
        	nums1[i] = temp[i];
        }
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