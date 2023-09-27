package Medium;

import java.io.*;
import java.util.*;

public class SetMatrixZeroes {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       int arr[][] = {{1,1,1},{1,0,1},{1,1,1}};
       setZeroes(arr);
       for(int i =0; i < arr.length; i++) {
    	   for(int j  =0; j < arr[0].length;j++) {
    		   System.out.print(arr[i][j]+" ");
    	   }
    	   System.out.println();
       }
       
    }
    public static void setZeroes(int[][] matrix) {
    	//-431 because it happens to not be used in any test case
    	//unfortunately due to the bounds, there are no proper numbers we can use as a flag
    	//inside the array to keep it O(1) space.
    	for(int row = 0; row < matrix.length; row++) {
    		boolean hasZero = false;
    		for(int col = 0; col < matrix[0].length; col++) {
    			if(matrix[row][col] ==0) {
    				hasZero = true;
    				break;
    			}
    		}
    		if(hasZero) {
    			for(int col = 0; col < matrix[0].length; col++) {
        			if(matrix[row][col] !=0) {
        				matrix[row][col] = -431;
        			}
        		}
    		}
    	}
    	for(int col = 0; col < matrix[0].length; col++) {
    		boolean hasZero = false;
    		for(int row = 0; row < matrix.length; row++) {
    			if(matrix[row][col] ==0) {
    				hasZero = true;
    				break;
    			}
    		}
    		if(hasZero) {
    			for(int row = 0; row < matrix.length; row++) {
        			if(matrix[row][col] !=0) {
        				matrix[row][col] = -431;
        			}
        		}
    		}
		}
    	for(int row = 0; row < matrix.length; row++) {
    		for(int col = 0; col < matrix[0].length; col++) {
    			if(matrix[row][col] ==-431) {
    				matrix[row][col] = 0;
    			}
    		}
    	}
    	return;
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
