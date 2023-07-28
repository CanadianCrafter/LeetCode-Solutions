package Medium;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class UniquePathsII {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
//    	int arr[][] = {{0,0,0},{0,1,0},{0,0,0}};
    	int arr[][] = {{1}};
    	System.out.println(uniquePathsWithObstacles(arr));
    			
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	for(int i = 0; i < obstacleGrid.length;i++) {
    		for(int j =0; j< obstacleGrid[0].length;j++) {
    			obstacleGrid[i][j] *= -1;
    		}
    	}
    	
    	// BFS
		Queue<Integer> queRow = new LinkedList<Integer>(); //Queue for rows
		Queue<Integer> queColumn = new LinkedList<Integer>(); //Queue for columns
		int direction[][] = {{ 0, 1 }, { 1, 0 } }; //change in position from current position
		queRow.add(0);
		queColumn.add(0);
		boolean vis[][] = new boolean[obstacleGrid.length][obstacleGrid[0].length];
		vis[0][0] = true;
		if(obstacleGrid[0][0]!=-1)obstacleGrid[0][0] = 1;
		while (!queRow.isEmpty()) {
			int r = queRow.poll();
			int c = queColumn.poll();
			for (int n = 0; n < 2; n++) {
				int r2 = direction[n][0] + r; //add change in row position to current row position
				int c2 = direction[n][1] + c; //add change in column position to current column position
				if (r2 < 0 || r2 >= obstacleGrid.length || c2 < 0 || c2 >= obstacleGrid[0].length || obstacleGrid[r2][c2]==-1)
					continue;
				if (!vis[r2][c2]) {
					queRow.add(r2);
					queColumn.add(c2);
					vis[r2][c2] = true;
					
					int r3 = r2-1;
					int c4 = c2-1;
					int top = 0;
					int left = 0;
					if(r3<0||obstacleGrid[r3][c2]==-1) top = 0;
					else top = obstacleGrid[r3][c2];
					if(c4<0||obstacleGrid[r2][c4]==-1) left = 0;
					else left = obstacleGrid[r2][c4];
					
					obstacleGrid[r2][c2] = top+left;
				}
			}
		}
		
//		for(int i = 0; i < obstacleGrid.length;i++) {
//    		for(int j =0; j< obstacleGrid[0].length;j++) {
//    			System.out.print(obstacleGrid[i][j] + " ");
//    		}
//    		System.out.println();
//    	}
		
		return Math.max(0, obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]);
        
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
