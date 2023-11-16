package Medium;

import java.io.*;
import java.util.*;

public class MaxAreaOfIsland {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static boolean rows[];
    public static boolean columns[];
    public static boolean rD[];
    public static boolean lD[];
    public static void main(String args[]) throws IOException {
    	int[][] a = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    	System.out.println(maxAreaOfIsland(a));
    }
    
    public static int maxAreaOfIsland(int[][] grid) {
		int ans = 0;
    	for(int sR =0; sR <grid.length;sR++) {
    		for(int sC = 0; sC < grid[0].length;sC++) {
    			if(grid[sR][sC]==0) continue;
    			else {
    				// BFS
    				Queue<Integer> queRow = new LinkedList<Integer>(); //Queue for rows
    				Queue<Integer> queColumn = new LinkedList<Integer>(); //Queue for columns
    				int direction[][] = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } }; //change in position from current position
    				queRow.add(sR);
    				queColumn.add(sC);
    				int size = 1;
    				grid[sR][sC]=0;
    				while (!queRow.isEmpty()) {
    					int r = queRow.poll();
    					int c = queColumn.poll();
    					for (int n = 0; n < 4; n++) {
    						int r2 = direction[n][0] + r; //add change in row position to current row position
    						int c2 = direction[n][1] + c; //add change in column position to current column position
    						if (r2 < 0 || r2 >= grid.length || c2 < 0 || c2 >= grid[0].length || grid[r2][c2]==0)
    							continue;
							queRow.add(r2);
							queColumn.add(c2);
							grid[r2][c2] = 0;
							size++;
    					}
    				}
    				ans = Math.max(ans,  size);
    			}
    		}
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
