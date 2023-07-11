package Easy;

import java.io.*;
import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       int arr[] = {1,1,2};
       System.out.println(removeDuplicates(arr));
       System.out.println(Arrays.toString(arr));
       
    }
    public static  int removeDuplicates(int[] nums) {
    	HashSet<Integer> hs = new HashSet<Integer>();
    	for(int i = 0; i< nums.length; i++) hs.add(nums[i]);
    	Iterator<Integer> it = hs.iterator();
    	
    	int size = hs.size();
    	int index=0;
    	while(it.hasNext()) {
    		nums[index]=it.next();
    		index++;
    	}
    	while(index<nums.length) {
    		nums[index]=Integer.MAX_VALUE;
    		index++;
    	}
    	Arrays.sort(nums);
    	
    	return size;
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


