package Medium;

import java.io.*;
import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static String map[][] = {{},
    		{},
    		{"a","b","c"},
    		{"d","e","f"},
    		{"g","h","i"},
    		{"j","k","l"},
    		{"m","n","o"},
    		{"p","q","r","s"},
    		{"t","u","v"},
    		{"w","x","y","z"}};
    		
    
    public static void main(String args[]) throws IOException {

    	String digits = "23";
    	System.out.println(letterCombinations(digits).toString());

    }
    
    public static List<String> letterCombinations(String digits) {
    	List<String> ans = new ArrayList<String>();
    	
		if(digits.length()==0) {
			return ans;
		}
		List<String> rec = new ArrayList<String>();
    	rec = letterCombinations(digits.substring(1));
    	if(rec.size()==0) {
    		String str = "";
    		rec.add(str);
    	}
		int digit = Character.getNumericValue(digits.charAt(0));
		for(int j = 0; j< rec.size();j++) {
			for(int i = 0; i<map[digit].length;i++) {
				 ans.add(map[digit][i] + rec.get(j));
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
