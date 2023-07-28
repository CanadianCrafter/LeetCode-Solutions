package Medium;

import java.io.*;
import java.util.*;

public class InsertInterval {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
//    	int arr[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//    	int arr[][] = {{2,4},{5,7},{8,10},{11,13}};
//    	int arr[][] = {{1,5}};
    	int arr[][] = {{0,1},{2,6},{9,11}};
    	int arr2[] = {5,10};
    	int ans[][] = insert(arr, arr2);
    	for(int i = 0; i < ans.length; i++) {
    		for(int j = 0; j < ans[0].length; j++) {
    			System.out.print(ans[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
    	if(intervals.length==0) {
    		int tmp[][] = {newInterval};
    		return tmp;
    	}
    	
    	
    	int l = 0;
    	int r = intervals.length-1;
    	int m =0;
    	while(l<=r) {
    		m = (l+r)/2;
    		if(intervals[m][1]==newInterval[0]) {
    			break;
    		}
    		if(intervals[m][1]>newInterval[0]) {
    			r= m-1;
    		}
    		else {
    			l=m+1;
    		}
    	}
    	int leftBound = m;
    	if(intervals[m][1]<newInterval[0]&&leftBound!=intervals.length-1)leftBound++;
    	
    	l = 0;
    	r = intervals.length-1;
    	while(l<=r) {
    		m = (l+r)/2;
    		if(intervals[m][0]==newInterval[1]) {
    			break;
    		}
    		if(intervals[m][0]>newInterval[1]) {
    			r= m-1;
    		}
    		else {
    			l=m+1;
    		}
    	}
    	int rightBound = m;
    	if(intervals[m][0]>newInterval[1]&&rightBound!=0)rightBound--;
    	
    	
    	ArrayList<int[]> lis = new ArrayList<int[]>();
    	for(int i = 0; i < leftBound;i++) {
    		lis.add(intervals[i]);
    	}
//    	System.out.println(leftBound + "  " + rightBound);
    	
    	int newLeft =0;
    	int newRight = 0;
    	boolean mergeLeft = false;
    	boolean mergeRight =false;
    	if(intervals[leftBound][1]>=newInterval[0]) {
    		newLeft = Math.min(intervals[leftBound][0],newInterval[0]);
    		mergeLeft = true;
    	}
    	else {
    		newLeft = newInterval[0];
    	}
    	if(intervals[rightBound][0]<=newInterval[1]) {
    		newRight = Math.max(intervals[rightBound][1],newInterval[1]);
    		mergeRight = true;
    	}
    	else {
    		newRight =  newInterval[1];
    		
    	}
    	
//    	System.out.println(mergeLeft);
//    	System.out.println(mergeRight);
    	if(!mergeLeft) lis.add(intervals[leftBound]);
    	
    	int tmp[] = {newLeft, newRight};
    	lis.add(tmp);
    	if(!mergeRight) lis.add(intervals[rightBound]);
    	for(int i = rightBound+1; i < intervals.length;i++) lis.add(intervals[i]);
    	
    	int ans[][] = new int[lis.size()][2];
    	for(int i =0; i < lis.size();i++) {
    		ans[i][0]=lis.get(i)[0];
    		ans[i][1]=lis.get(i)[1];
    	}
    	return ans;
        
    }
    
    public static void recurse(List<List<Integer>> ans,  int sum, List<Integer> soFar, int[] candidates, int target, int indexStart) {
        if(sum==target) {
        	ans.add(new ArrayList<>(soFar));
        	return;
        }
        for(int i = indexStart; i < candidates.length; i++) {
        	if((sum+candidates[i])<=target) {
        		soFar.add(candidates[i]);
        		recurse(ans, sum+candidates[i],soFar, candidates, target, i);
        	}
        	else {
        		continue;
        	}
        	soFar.remove(soFar.indexOf(candidates[i]));
        }
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
