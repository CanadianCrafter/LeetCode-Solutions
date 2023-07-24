package Medium;

import java.util.*;
import java.io.*;

public class JumpGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int nums[] = {3,2,1,0,4};
		System.out.println(canJump(nums));
		
	}
	
	public static boolean canJump(int[] nums) {
		
		if (nums.length<=1)return true;
		
		int lastValid = nums.length-1;
		for(int i = nums.length-1; i>=0; i--) {
			if(i+nums[i]>=lastValid) {
				lastValid = i;
			}
		}
		return lastValid==0;
		
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
