package Hard;

import java.io.*;
import java.util.*;

public class NQueens {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static boolean rows[];
    public static boolean columns[];
    public static boolean rD[];
    public static boolean lD[];
    public static void main(String args[]) throws IOException {
    	List<List<String>> ans = solveNQueens(4);
    	System.out.println(ans.size());
    	for(int i = 0; i < ans.size(); i++) {
    		for(int j = 0; j < ans.get(i).size(); j++) {
    			System.out.println(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    }
    
    public static List<List<String>> solveNQueens(int n) {
    	rows=new boolean[n];
    	columns=new boolean[n];
    	rD=new boolean[2*n-1];
    	lD=new boolean[2*n-1];
    	Arrays.fill(rows, false);
    	Arrays.fill(columns, false);
    	Arrays.fill(rD, false);
    	Arrays.fill(lD, false);
    	char[][] soFar = new char[n][n];
    	for(int i =0; i<n;i++)Arrays.fill(soFar[i], '.');
    	List<List<String>> ans = new ArrayList<List<String>>();
    	recurse(ans, n, 0, soFar);
    	return ans;
    }
    
    public static void recurse(List<List<String>> ans, int n, int col, char[][] soFar) {
    	if(col==n) {
    		List<String> tmp = new ArrayList<String>();
    		for(int i =0; i < n; i ++) {
    			String str = new String(soFar[i]);
    			tmp.add(str);
    		}
    		ans.add(tmp);
    	}
    	for(int row = 0; row < n; row++) {
    		if(rows[row]||columns[col]||lD[row+col]||rD[row-col-1+n]) continue;
    		columns[col] = lD[row+col] = rD[row-col-1+n] = rows[row] = true;
    		soFar[row][col] = 'Q';
    		recurse(ans, n,col+1,soFar);
    		columns[col] = lD[row+col] = rD[row-col-1+n] = rows[row] = false;
    		soFar[row][col] = '.';
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
