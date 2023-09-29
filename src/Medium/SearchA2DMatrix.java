package Medium;

import java.io.*;
import java.util.*;

public class SearchA2DMatrix {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    	int matrix2[][] = {{1,1}};
        System.out.println(searchMatrix(matrix2, 2));
       
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int l = 0, r = matrix.length*matrix[0].length-1;
    	int m = 0;
    	while(l<=r) {
    		m = (l+r)/2;
    		if(matrix[m/matrix[0].length][m%matrix[0].length]==target) {
    			return true;
    		}
    		else if(target>matrix[m/matrix[0].length][m%matrix[0].length]){
    			l=m+1;
    		}
    		else {
    			r = m-1;
    		}
    	}
    	return false;
        
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
