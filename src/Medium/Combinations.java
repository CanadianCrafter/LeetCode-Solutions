package Medium;

import java.io.*;
import java.util.*;

public class Combinations {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {

    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	ans = combine(5, 3);
    	for(int i = 0; i < ans.size();i++) {
    		for(int j  = 0; j < ans.get(i).size();j++) {
    			System.out.print(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    }
    
    public static List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> temp = new ArrayList<Integer>();
    	combination(ans, temp, 0, n-1, 0, k);
    	return ans;
    }
    
    
    public static void combination(List<List<Integer>> ans,List<Integer> temp, int start, int end, int index, int k) {
    	if(index==k) {
    		List<Integer> copy = new ArrayList<Integer>(temp);
    		ans.add(copy);
    		return;
    	}
    	for(int i = start; i <=end && end-i+1 >=k-index;i++) {
    		temp.add(index, i+1);
    		combination(ans, temp, i+1, end, index+1, k);
    		temp.remove(temp.size()-1);
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
