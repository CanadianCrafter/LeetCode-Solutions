package Medium;

import java.io.*;
import java.util.*;

public class ShortestPathInBinaryMatrix {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int a[][] ={{1,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(a));
       
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
    	boolean vis[][]= new boolean[grid.length][grid[0].length];
    	int dis[][]= new int[grid.length][grid[0].length];
		
		//BFS
		Queue<Integer> queRow = new LinkedList<Integer>();
    	Queue<Integer> queColumn = new LinkedList<Integer>();
    	int direction[][] = {{-1,0},{0,1},{0,-1},{1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
    	if(grid[0][0]==0) {
    		queRow.add(0);
        	queColumn.add(0);
        	vis[0][0]=true;
        	dis[0][0]=1;
    	}
    	while (!queRow.isEmpty()) {
			int r = queRow.poll();
			int c = queColumn.poll();
			for (int n = 0; n < 8; n++) {
				int r2 = direction[n][0] + r; //add change in row position to current row position
				int c2 = direction[n][1] + c; //add change in column position to current column position
				if (r2 < 0 || r2 >= grid.length || c2 < 0 || c2 >= grid[0].length || grid[r2][c2]==1)
					continue;
				if (!vis[r2][c2]) {
					queRow.add(r2);
					queColumn.add(c2);
					vis[r2][c2] = true;
					dis[r2][c2] = dis[r][c] + 1;
				}
			}
		}
    	return dis[grid.length-1][grid[0].length-1]==0?-1:dis[grid.length-1][grid[0].length-1];
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
