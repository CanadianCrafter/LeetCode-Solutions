package Medium;

import java.io.*;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
       int ans = lengthOfLongestSubstring("ggububgvfk");
       System.out.println(ans);
        
       
    }
    public static int lengthOfLongestSubstring(String s) {
        //Solution 1:
    	int maxLength = 0;
        String temp = "";
        for(int i = 0; i < s.length();i++) {
        	char c = s.charAt(i);
        	int index = temp.indexOf(c);
        	if(index!=-1) {
        		temp = temp.substring(index+1);
        	}
        	temp+=c;
        	maxLength = Math.max(temp.length(), maxLength);
        }
        
        return maxLength;
    		
    	
//    	//Solution 2:
//    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int maxLength = 0;
//        for(int i =0; i< s.length();i++) {
//        	char c = s.charAt(i);
//        	if(map.containsKey(c)) {
//        		int diff = map.get(c)+1;
//        		
//        		Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
//        		while(iter.hasNext()) {
//        			Map.Entry<Character, Integer> entry = iter.next();
//        			entry.setValue(entry.getValue()-diff);
//                    if(entry.getValue()<0) {
//                    	iter.remove();
//                    }
//                }
//        		map.put(c,map.size());
//        	}
//        	else {
//        		map.put(c,map.size());
//        	}
//        	maxLength = Math.max(map.size(), maxLength);
//        	
//        }
//        return maxLength;
        
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


