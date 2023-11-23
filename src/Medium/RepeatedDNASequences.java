package Medium;

import java.io.*;
import java.util.*;

public class RepeatedDNASequences {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {
    	String str = "AAAAAAAAAAA";
    	List<String> ans = findRepeatedDnaSequences(str);
    	for(int i =0; i <ans.size();i++){
    		System.out.println(ans.get(i)+" ");
    	}
    }
    
    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap <String, Integer> map = new HashMap<String,Integer>();
        for(int i =0; i <= s.length()-10;i++) {
        	String substr = s.substring(i,i+10);
        	map.put(substr, map.getOrDefault(substr, 0)+1);
        	
        }
        List<String> ans = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
        	if(entry.getValue()>=2) {
        		ans.add(entry.getKey());
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
