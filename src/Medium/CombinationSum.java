package Medium;

import java.io.*;
import java.util.*;

public class CombinationSum {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int arr[] = {2,3,6,7};
//    	int arr[] = {-1,0,1,2,-1,-4};
    	List<List<Integer>> ans = combinationSum(arr ,7);
    	for(int i = 0; i < ans.size(); i++) {
    		for(int j = 0; j < ans.get(i).size(); j++) {
    			System.out.print(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> soFar = new ArrayList<Integer>();
        recurse(ans, 0, soFar, candidates, target,0);
        return ans;
    }
    
    public static void recurse(List<List<Integer>> ans,  int sum, List<Integer> soFar, int[] candidates, int target, int indexStart) {
        if(sum==target) {
        	ans.add(new ArrayList<>(soFar));
        	return;
        }
        for(int i = indexStart; i < candidates.length; i++) {
        	if((sum+candidates[i])<=target) {
        		soFar.add(candidates[i]);
        		recurse(ans, sum+candidates[i],soFar, candidates, target, i);
        	}
        	else {
        		continue;
        	}
        	soFar.remove(soFar.indexOf(candidates[i]));
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
