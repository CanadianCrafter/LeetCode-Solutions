package Medium;

import java.io.*;
import java.util.*;

public class SpiralMatrixII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       int arr[][] = generateMatrix(3);
       for(int i =0; i < arr.length;i++) System.out.println(Arrays.toString(arr[i]));
    }
    public static int[][] generateMatrix(int n) {
    	int ans[][] = new int [n][n];
    	int d = 0;
    	int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    	int r =0;
    	int c= 0;
    	
    	for(int i = 1; i <=n*n; i++) {
    		ans[r][c] = i;
    		int nr = r + dir[d][0];
    		int nc = c +dir[d][1];
    		if(i == n*n) break;
    		while(nr>=n||nc>=n||nr<0||nc<0||ans[nr][nc]!=0) {
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
