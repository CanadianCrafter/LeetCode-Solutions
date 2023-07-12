package Hard;

import java.io.*;
import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static HashSet<String> wordCombos;
    public static HashMap<String, Integer> wordsHS;
    
    public static void main(String args[]) throws IOException {

    	String arr[] = {"word","good","best","good"};
    	System.out.println(findSubstring("wordgoodgoodgoodbestword",arr));
    }
    
    public static List<Integer> findSubstring(String s, String[] words) {
    	wordsHS = new HashMap<String,Integer>();
    	for(int i =0;i<words.length;i++) wordsHS.put(words[i],wordsHS.containsKey(words[i])?wordsHS.get(words[i])+1:1);
    	
    	List<Integer> ans = new ArrayList<Integer>();
    	int len = words.length*words[0].length();
    	
    	for(int i =0; i<s.length()-len+1;i++) {
    		if(isValid(s.substring(i,i+len),words[0].length(), words.length)) {
    			ans.add(i);
    		}
    	}
    	return ans;
    	
    	
    }
    
    private static boolean isValid(String substring, int length, int  n) {
    	HashMap<String, Integer> check = new HashMap<String,Integer>();;
		for(int i =0; i < n; i ++) {
			String subStr = substring.substring(i*length,(i+1)*length);
//			if(wordsHS.containsKey(subStr)&&(checkRepeat.containsKey(subStr)?checkRepeat.get(subStr):0)<wordsHS.get(subStr)) {
//				checkRepeat.put(subStr,checkRepeat.containsKey(subStr)?checkRepeat.get(subStr)+1:1);
//			}
//			else {
//				return false;
//			}
			check.put(subStr, check.containsKey(subStr)?check.get(subStr)+1:1);
		}
		return check.equals(wordsHS);
    
    }

//	public static void wordCombinations(List<String> words, String str) {
//    	if(words.size()==0) {
//    		wordCombos.add(str);
//    	}
//    	
//    	for(int i = 0; i <words.size(); i++) {
//    		String word = words.get(i);
//    		List<String> newWords = new ArrayList<>(words);
//    		newWords.remove(i);
//    		wordCombinations(newWords, str+word);
//    	}
//        
//    }
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
