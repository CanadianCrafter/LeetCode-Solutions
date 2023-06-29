package Medium;

import java.io.*;
import java.util.*;

public class AddTwoNumbers {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    public static void main(String args[]) throws IOException {
        System.out.println(intToRoman(399));
        
       
    }
    public static String intToRoman(int num) {
		String numStr = Integer.toString(num);
		String ans ="";
		for(int i =0; i<numStr.length();i++) {
			int val = Character.getNumericValue(numStr.charAt(i));
			if(i==numStr.length()-1) {
				if(val==4) ans+="IV";
				else if(val==9) ans+= "IX";
				else {
					if(val>=5) {
						ans+="V";
						val-=5;
					}
					for(int j =0; j<val;j++) {
						ans+="I";
					}
				}
			}
			else if(i==numStr.length()-2) {
				if(val==4) ans+="XL";
				else if(val==9) ans+= "XC";
				else {
					if(val>=5) {
						ans+="L";
						val-=5;
					}
					for(int j =0; j<val;j++) {
						ans+="X";
					}
				}
			}
			else if(i==numStr.length()-3) {
				if(val==4) ans+="CD";
				else if(val==9) ans+= "CM";
				else {
					if(val>=5) {
						ans+="D";
						val-=5;
					}
					for(int j =0; j<val;j++) {
						ans+="C";
					}
				}
			}
			else if(i==numStr.length()-4) {
				for(int j =0; j<val;j++) {
					ans+="M";
				}
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


