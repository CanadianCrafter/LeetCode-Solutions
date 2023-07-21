package Medium;

import java.util.*;
import java.io.*;

public class JumpGameII {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int nums[] = {2,3,1,1,4};
		System.out.println(jump(nums));
		
	}
	
	public static int jump(int[] nums) {
		
		Queue<Integer> queue = new LinkedList<Integer>(); //Queue 
		queue.add(0);
		boolean vis[] = new boolean [nums.length];
		int dis[] = new int [nums.length];
		vis[0] = true;
		dis[0] = 0;
		while (!queue.isEmpty()) {
			int index = queue.poll();
			for (int n = 0; n <= nums[index]; n++) {
				int index2 = index + n;
				if (index2<0 ||index2>=nums.length)
					continue;
				if (!vis[index2]) {
					queue.add(index2);
					vis[index2] = true;
					dis[index2] = dis[index] + 1;
				}
			}
		}
		return dis[nums.length-1];
        
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
