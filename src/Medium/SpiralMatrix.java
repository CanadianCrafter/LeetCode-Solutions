package Medium;

import java.io.*;
import java.util.*;

public class SpiralMatrix {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
       System.out.println(spiralOrder(arr).toString());
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
    	boolean vis[][] = new boolean [matrix.length][matrix[0].length];
    	int d = 0;
    	List<Integer> ans = new ArrayList<Integer>();
    	int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    	int r =0;
    	int c= 0;
    	
    	for(int i = 0; i <matrix.length*matrix[0].length; i++) {
    		ans.add(matrix[r][c]);
    		vis[r][c]=true;
    		int nr = r + dir[d][0];
    		int nc = c +dir[d][1];
    		if(i == matrix.length*matrix[0].length-1) break;
    		while(nr>=matrix.length||nc>=matrix[0].length||nr<0||nc<0||vis[nr][nc]) {
    			d=(d+1)%4;
    			nr = r + dir[d][0];
        		nc = c +dir[d][1];
    		}
    		r =nr;
    		c =nc;
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
