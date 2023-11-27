package Medium;

import java.io.*;
import java.util.*;

public class GrayCode {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
       List<Integer> ans = grayCode(16);
       for(int i =0; i < ans.size();i++) System.out.println(ans.get(i));
       
    }
    public static List<Integer> grayCode(int n) {
    	List <Integer> ans = new ArrayList<Integer>();
    	HashSet<Integer> set = new HashSet<Integer>();
    	int prev = 0;
        ans.add(prev);
        set.add(prev);
        for(int i =0; i < Math.pow(2, n)-1;i++) {
        	int msb = n-1;
        	int newNum;
        	do {
        		newNum = prev ^ (1 << msb);
        		msb--;
        	}while(set.contains(newNum));
        	prev = newNum;
        	ans.add(newNum);
        	set.add(newNum);
        }
        return ans;
    	
    	//Solution 2: Too slow
//    	List <String> bin = new ArrayList<String>();
//    	List <Integer> ans = new ArrayList<Integer>();
//        String prev = "";
//        for(int i =0; i < n; i++) prev+="0";
//        bin.add(prev);
//        ans.add(0);
//        for(int i =0; i < Math.pow(2, n)-1;i++) {
//        	int msb = n-1;
//        	String newStr = "";
//        	do {
//        		if(msb<n-1) newStr = prev.substring(0,msb)+ Integer.toString((Character.getNumericValue(prev.charAt(msb))+1)%2) + prev.substring(msb+1);
//        		else newStr = prev.substring(0,msb)+ Integer.toString((Character.getNumericValue(prev.charAt(msb))+1)%2);
//        		msb--;
//        	}while(bin.contains(newStr));
//        	bin.add(newStr);
//        	prev = newStr;
//        	ans.add(Integer.parseInt(newStr,2));
//        }
//        return ans;
    }
    
    public static int toInt(BitSet bitSet) {
        int intValue = 0;
        for (int bit = 0; bit < bitSet.length(); bit++) {
            if (bitSet.get(bit)) {
                intValue |= (1 << bit);
            }
        }
        return intValue;
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
