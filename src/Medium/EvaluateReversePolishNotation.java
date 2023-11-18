package Medium;

import java.io.*;
import java.util.*;

public class EvaluateReversePolishNotation {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    
    public static void main(String args[]) throws IOException {

    	String tokens[] = {"2","1","+","3","*"};
    	System.out.println(evalRPN(tokens));
    }
    
    public  static int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<Integer>();
        for(int i =0; i < tokens.length;i++) {
        	if(tokens[i].equals("+")) {
        		int sum = 0;
        		sum += stack.pop();
        		sum += stack.pop();
        		stack.push(sum);
        	}
        	else if(tokens[i].equals("-")) {
        		int diff = 0;
        		diff -= stack.pop();
        		diff += stack.pop();
        		stack.push(diff);
        	}
        	else if(tokens[i].equals("*")) {
        		int prod = 1;
        		prod *= stack.pop();
        		prod *= stack.pop();
        		stack.push(prod);
        	}
        	else if(tokens[i].equals("/")) {
        		int den = 1;
        		int num = 1;
        		den = stack.pop();
        		num = stack.pop();
        		int div = num / den;
        		stack.push(div);
        	}
        	else {
        		stack.push(Integer.parseInt(tokens[i]));
        	}
        }
        return stack.pop();
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
