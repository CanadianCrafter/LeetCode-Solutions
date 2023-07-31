package Medium;

import java.io.*;
import java.util.*;

public class MinimumPathSum {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	int a[][] ={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(a));
       
    }
    public static int minPathSum(int[][] grid) {
    	boolean vis[][]= new boolean[grid.length][grid[0].length];
    	int dis[][]= new int[grid.length][grid[0].length];
    	for(int i =0; i<dis.length;i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
    	dis[0][0] = grid[0][0];
    	
		//Dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue();
		pq.add(new Edge(0,0,grid[0][0]));
		
    	int direction[][] = {{0,1},{1,0}};

    	while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int r = e.r;
			int c = e.c;
			if(grid[r][c]>dis[r][c]) continue;
			for (int n = 0; n < direction.length; n++) {
				int r2 = direction[n][0] + r; //add change in row position to current row position
				int c2 = direction[n][1] + c; //add change in column position to current column position
				if (r2 < 0 || r2 >= grid.length || c2 < 0 || c2 >= grid[0].length)
					continue;
				
				if (dis[r2][c2] > grid[r2][c2]+dis[r][c]) {
					dis[r2][c2] = dis[r][c] + grid[r2][c2];
					pq.add(new Edge(r2,c2, dis[r2][c2]));
				}
			}
		}
    	for(int i = 0; i < grid.length;i++)System.out.println(Arrays.toString(dis[i]));
    	return dis[grid.length-1][grid[0].length-1];
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
    
    static class Edge implements Comparable<Edge> {
		int r; //this node
		int c;

		int w; // weight
		// constructor

		public Edge(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Edge x) {
			// sorts edges based on weight
			return Integer.compare(w, x.w);
		}

	}

}
