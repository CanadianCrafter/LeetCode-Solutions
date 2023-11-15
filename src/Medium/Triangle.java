package Medium;
import java.util.*;
import java.io.*;

public class Triangle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		List<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(4);
		List<Integer> c = new ArrayList<Integer>();
		c.add(6);
		c.add(5);
		c.add(7);
		List<Integer> d = new ArrayList<Integer>();
		d.add(4);
		d.add(1);
		d.add(8);
		d.add(3);
		triangle.add(a);
		triangle.add(b);
		triangle.add(c);
		triangle.add(d);
		System.out.println(minimumTotal(triangle));
		
		
		
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		
		//distance array
		List<List<Integer>> dis = new ArrayList<List<Integer>>();
		for(int i =0; i < triangle.size();i++) {
			List<Integer> row = new ArrayList<Integer>();
			for(int j = 0; j < i+1;j++) {
				row.add(Integer.MAX_VALUE);
			}
			dis.add(row);
		}
		dis.get(0).set(0, triangle.get(0).get(0)); //distance from starting node to itself is zero
		
		//priority queue
		PriorityQueue<Edge> pq = new PriorityQueue();
		pq.add(new Edge(0,0, triangle.get(0).get(0))); //add starting node
		

		// check all connected nodes
		while (!pq.isEmpty()) { 
			// the current node being checked
			Edge cur = pq.poll(); 
			// if the new distance is longer than the current distance, skip it
			if (cur.w > dis.get(cur.r).get(cur.c))	{
				continue; 
			}
			// check all nodes adjacent to the current node
			if(cur.r< triangle.size()-1) {	
				
				// check if the new distance is less than the old distance
				int leftBranch = triangle.get(cur.r+1).get(cur.c);
				if (dis.get(cur.r+1).get(cur.c) > dis.get(cur.r).get(cur.c) + leftBranch) { 
					// update distance
					dis.get(cur.r+1).set(cur.c,dis.get(cur.r).get(cur.c) + leftBranch); 	
					// add new node to be checked
					pq.add(new Edge(cur.r+1, cur.c, dis.get(cur.r+1).get(cur.c))); 
				}
				
				int rightBranch = triangle.get(cur.r+1).get(cur.c+1);
				if (dis.get(cur.r+1).get(cur.c+1) > dis.get(cur.r).get(cur.c) + rightBranch) { 
					// update distance
					dis.get(cur.r+1).set(cur.c+1,dis.get(cur.r).get(cur.c) + rightBranch); 	
					// add new node to be checked
					pq.add(new Edge(cur.r+1, cur.c+1, dis.get(cur.r+1).get(cur.c+1))); 
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<dis.get(dis.size()-1).size();i++) {
			ans = Math.min(ans, dis.get(dis.size()-1).get(i));
		}
		return ans;
	}

	static class Edge implements Comparable<Edge> {
		int r; //row
		int c; //col
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

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
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

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}

}
