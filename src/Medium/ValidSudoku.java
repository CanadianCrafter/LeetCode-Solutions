package Medium;

import java.io.*;
import java.util.*;

public class ValidSudoku {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       
    }
    public static boolean isValidSudoku(char[][] board) {
    	//check rows
    	for(int i = 0; i< board.length; i++) {
    		int arr[]  =new int [9];
    		for(int j = 0; j< board[i].length;j++) {
    			if(board[i][j]!='.') arr[Character.getNumericValue(board[i][j])-1]++;
    		}
    		for(int j = 0; j< arr.length;j++) {
    			if(arr[j]>1) return false;
    		}
    	}
    	//check cols
    	for(int i = 0; i< board[0].length; i++) {
    		int arr[]  =new int [9];
    		for(int j = 0; j< board.length;j++) {
    			if(board[j][i]!='.') arr[Character.getNumericValue(board[j][i])-1]++;
    		}
    		for(int j = 0; j< arr.length;j++) {
    			if(arr[j]>1) return false;
    		}
    	}
    	//check box
    	for(int row = 0; row <board.length; row+=3) {
    		for(int col = 0; col <board[0].length; col+=3) {
    			int arr[]  =new int [9];
    			for(int i = 0; i< 3; i++) {
    	    		for(int j = 0; j< 3;j++) {
    	    			if(board[row+i][col+j]!='.') arr[Character.getNumericValue(board[row+i][col+j])-1]++;
    	    		}
    	    	}
    			for(int j = 0; j< arr.length;j++) {
	    			if(arr[j]>1) return false;
	    		}
    			
        	}
    	}
    	
    	return true;
    	
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
