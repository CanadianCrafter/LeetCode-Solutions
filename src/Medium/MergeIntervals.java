package Medium;

import java.io.*;
import java.util.*;

public class MergeIntervals {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int arr[][] = {{1,4},{4,5}};
    	int ans[][] = merge(arr);
    	for(int i = 0; i < ans.length;i++) {
    		for(int j = 0; j < ans[0].length;j++) {
    			System.out.print(ans[i][j] + " ");
    		}
    		System.out.println();
    	}
       
    }
    public static int[][] merge(int[][] intervals) {
    	Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
    	ArrayList<int[]> tmp = new ArrayList<>();
    	for(int i =0; i < intervals.length;i++) {
    		if(tmp.size()==0) {
    			tmp.add(intervals[i]);
    		}
    		else if(tmp.get(tmp.size()-1)[1]>=intervals[i][0]) {
    			tmp.get(tmp.size()-1)[1]=Math.max(intervals[i][1], tmp.get(tmp.size()-1)[1]);
    		}
    		else {
    			tmp.add(intervals[i]);
    		}
    	}
    	
    	int ans[][] = new int[tmp.size()][2];
    	for(int i =0; i < tmp.size();i++) {
    		ans[i][0]=tmp.get(i)[0];
    		ans[i][1]=tmp.get(i)[1];
    	}
    	return ans;
        
    }
    
    public static void generateParenthesis(int numLeft, int numRight, int n, List<String> ans, String s) {
    	if(numLeft==n&&numRight==n) {
    		ans.add(s);
    		return;
    	}
    	if(numLeft<n) {
    		generateParenthesis(numLeft+1, numRight, n, ans, s+"(");
    	}
    	if(numRight<numLeft) {
    		generateParenthesis(numLeft, numRight+1, n, ans, s+")");
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
