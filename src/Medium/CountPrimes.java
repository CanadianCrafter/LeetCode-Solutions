package Medium;

import java.io.*;
import java.util.*;

public class CountPrimes {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        boolean arr[] = new boolean[n];
        if(arr.length>0) arr[0]=true;
        if(arr.length>1) arr[1]=true;
        for(int i =2; i*i<=n-1;i++) {
        	for(int j=2*i; j<n;j+=i) {
        		arr[j]=true;
        	}
        }
        int ans =0;
        for(int i =0; i < n; i++) {
        	if(!arr[i]) ans++;
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
