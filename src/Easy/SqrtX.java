package Easy;

import java.io.*;
import java.util.*;

public class SqrtX {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
    	System.out.println(mySqrt(4));
    	System.out.println(mySqrt(9));
    	System.out.println(mySqrt(0));
    	System.out.println(mySqrt(1));
    	System.out.println(mySqrt(2147395600));
    	
    }
    public static int mySqrt(int x) {
    	if(x==0)return 0;
    	int ans = 1;
        for(int i = 1; i <=x;i++) {
        	int tmp = x/i;
        	if(Math.abs(x/ans-ans)>=Math.abs(i-tmp)) {
        		ans = tmp;
        	}
        	else {
        		break;
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


