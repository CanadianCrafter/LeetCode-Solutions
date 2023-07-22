package Medium;

import java.io.*;
import java.util.*;

public class GroupAnagrams {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	
    	String arr[] = {"eat","tea","tan","ate","nat","bat"};
    	List<List<String>> ans = groupAnagrams(arr);
    	for(int i = 0; i < ans.size(); i++) {
    		for(int j = 0; j < ans.get(i).size(); j++) {
    			System.out.print(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}

    	
    	
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i ++) {
        	char[] tmp = strs[i].toCharArray();
        	Arrays.sort(tmp);
        	String key = new String(tmp);
        	if(map.containsKey(key)) {
        		map.get(key).add(strs[i]);
        	}
        	else {
        		List<String> lis = new ArrayList<String>();
        		lis.add(strs[i]);
        		map.put(key, lis);
        	}
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
        	Map.Entry entry = (Map.Entry)  iter.next();
        	ans.add((List<String>) entry.getValue());
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
