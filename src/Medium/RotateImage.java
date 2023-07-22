package Medium;

import java.io.*;
import java.util.*;

public class RotateImage {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
    	rotate(matrix);
    	for(int i = 0; i < matrix.length; i ++) System.out.println(Arrays.toString(matrix[i]));
    	
    }
    public static void rotate(int[][] matrix) {
        for(int row = 0; row<Math.round((double) (matrix.length) /2);row++) {
        	for(int col = row; col < matrix[row].length-row -1;col++){
        		int tmp = matrix[row][col];
        		matrix[row][col] = matrix[matrix.length-col-1][row];
        		matrix[matrix.length-col-1][row] = matrix[matrix.length-row-1][matrix.length-col-1];
				matrix[matrix.length-row-1][matrix.length-col-1] = matrix[col][matrix[0].length-1-row];
        		matrix[col][matrix[0].length-1-row] = tmp;
        	}
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
