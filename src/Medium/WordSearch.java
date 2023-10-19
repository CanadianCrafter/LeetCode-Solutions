package Medium;

import java.io.*;
import java.util.*;

public class WordSearch {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static char board[][];
    static String word;
    public static void main(String args[]) throws IOException {
    	char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	char board2[][] = {{'A','B'},{'C','D'}};
    	char board3[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	char board4[][] = {{'A','B','C','E'},
    						{'S','F','E','S'},
    						{'A','D','E','E'}};
    	String word = "ABCD";
    	String word3 = "ABCCED";
    	String word4 = "ABCESEEEFS";
    	System.out.println(exist(board4, word4));
       
    }
    
    public static boolean exist(char[][] grid, String search) {
        board = grid;
        word = search;
    	for(int row = 0; row <board.length; row++) {
    		for(int col = 0; col < board[0].length; col++) {
    			boolean vis[][]= new boolean[board.length][board[0].length];
    			int dis[][]= new int[board.length][board[0].length];
    	    	
    			//initial starting
            	if(board[row][col]==word.charAt(0)) {
                	vis[row][col]=true;
                	dis[row][col]=0;
                	if(dis[row][col]+1==word.length()) return true;
                	if(dfs(row, col, vis, dis)) return true;
            	}
            	else {
            		continue;
            	}
    		}
    		
    		
    	}
    	return false;
		
    }
    
    public static boolean dfs(int r, int c, boolean[][] vis, int [][] dis) {
		if(dis[r][c]+1>=word.length()) return false;
		int direction[][] = {{-1,0},{0,1},{0,-1},{1,0}};
		for (int n = 0; n < 4; n++) {
			int r2 = direction[n][0] + r; //add change in row position to current row position
			int c2 = direction[n][1] + c; //add change in column position to current column position
			if (r2 < 0 || r2 >= board.length || c2 < 0 || c2 >= board[0].length)
				continue;
			if (!vis[r2][c2] && board[r2][c2]==word.charAt(dis[r][c]+1)) {
				vis[r2][c2] = true;
				dis[r2][c2] = dis[r][c]+1;
				if(dis[r2][c2]+1==word.length()) return true;
				if(dfs(r2, c2, vis, dis)) return true;
				vis[r2][c2]=false;
				dis[r2][c2]=0;
				
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
