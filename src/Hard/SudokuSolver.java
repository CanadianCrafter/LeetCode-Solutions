package Hard;

import java.io.*;
import java.util.*;

public class SudokuSolver {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static void main(String args[]) throws IOException {
    	char board[][] = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        for(int i = 0; i< board.length; i++) {
    		for(int j = 0; j< board[i].length;j++) {
    			System.out.print(board[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    public static void solveSudoku(char[][] board) {
    	solveSudokuRecurse(board);
    }
    public static boolean solveSudokuRecurse(char[][] board) {

    	int numEmpty = 0;
    	for(int i = 0; i< board.length; i++) {
    		for(int j = 0; j< board[i].length;j++) {
    			if(board[i][j]=='.')numEmpty++;
    		}
    	}
    	if(numEmpty==0) return true;
    	
    	int row = 0;
    	int col = 0;
    	boolean breakFlag = false;
    	for(row = 0; row< board.length; row++) {
    		for(col = 0; col< board[row].length;col++) {
    			if(board[row][col]=='.') {
    				breakFlag = true;
    				break;
    			}
    		}
    		if(breakFlag) break;
    	}
    	
    	ArrayList<Integer> available = new ArrayList<Integer>();
		for(int i = 1; i <= 9; i++) available.add(i);
		
		//rows
		for(int i = 0; i< board[row].length;i++) {
			int val =Character.getNumericValue(board[row][i]);
			if(val!='.') {
				if(available.contains(val)){
					available.remove(available.indexOf(val));
				}
			}
		}
		
		//cols
		for(int i = 0; i< board.length;i++) {
			int val =Character.getNumericValue(board[i][col]);
			if(val!='.') {
				if(available.contains(val)){
					available.remove(available.indexOf(val));
				}
			}
		}
		
		//box;
		int topLeftCornerRow = row - (row%3);
		int topLeftCornerCol = col - (col%3);
		for(int i = 0; i< 3; i++) {
    		for(int j = 0; j< 3;j++) {
    			int val = Character.getNumericValue(board[topLeftCornerRow+i][topLeftCornerCol+j]);
    			if(val!='.') {
    				if(available.contains(val)){
    					available.remove(available.indexOf(val));
    				}
    			}
    		}
    	}
		for(int i = 0; i < available.size();i++) {
			board[row][col] = available.get(i).toString().charAt(0);
			if(solveSudokuRecurse(board)) return true;
			board[row][col]='.';
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
