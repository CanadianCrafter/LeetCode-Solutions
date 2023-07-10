package Medium;

import java.io.*;
import java.util.*;

public class ThreeSum {
    
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[]) throws IOException {
    	
//    	int arr[] = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
    	int arr[] = {-1,0,1,2,-1,-4};
    	List<List<Integer>> ans = threeSum(arr);
    	for(int i = 0; i < ans.size(); i++) {
    		for(int j = 0; j < ans.get(i).size(); j++) {
    			System.out.print(ans.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}

    	
    	
    }

    public static List<List<Integer>> threeSum(int[] nums) {
    	//Solution One: O(n^2)
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> element = new ArrayList<Integer>();
    	Arrays.sort(nums);
    	int prevVala = Integer.MAX_VALUE; //not safe, but probably fine
    	int prevValb = Integer.MAX_VALUE; //not safe, but probably fine
    	int prevValc = Integer.MAX_VALUE; //not safe, but probably fine
    	boolean flagA = false;
    	boolean flagBC = false;
    	for(int i = 0; i < nums.length; i++) {
    		if(flagA&&prevVala==nums[i]) {
    			continue;
    		}
    		else {
    			flagA=false;
    		}
    		int left = i+1;
    		int right = nums.length-1;
    		while(left<right) {
    			if(flagBC&&prevValb==nums[left]&&prevValc==nums[right]) {
    				right--;
                	left++;
                	continue;    				
    			}{
    				flagBC=false;
    			}
    			int sum = nums[i]+nums[right]+nums[left];
    			if(sum>0) right--;
    			else if(sum<0)left++;
    			else {
            		element.add(nums[i]);
            		element.add(nums[right]);
            		element.add(nums[left]);
            		ans.add(List.copyOf(element));
            		element.clear();
            		flagA = true;
            		flagBC = true;
                	prevVala = nums[i];
                	prevValb = nums[left];
                	prevValc = nums[right];
                	right--;
                	left++;
    			}
    		}
    		prevValb = Integer.MAX_VALUE; //not safe, but probably fine
        	prevValc = Integer.MAX_VALUE; //not safe, but probably fine
    		flagBC=false;
    	}
    	return ans;
    	
//    	//Solution 2 Also TLE ToT:
//    	ArrayList<Integer> pos = new ArrayList<Integer>();
//    	ArrayList<Integer> neg = new ArrayList<Integer>();
//    	ArrayList<Integer> zero = new ArrayList<Integer>();
//    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
//    	for(int i =0;i<nums.length;i++) {
//    		if(nums[i]>0) {
//    			pos.add(nums[i]);
//    		}
//    		else if(nums[i]<0) {
//    			neg.add(nums[i]);
//    		}
//    		else {
//    			zero.add(nums[i]);
//    		}
//    	}
//    	if(zero.size()>=3) {
//    		List<Integer> zeroCase = new ArrayList<Integer>();
//    		zeroCase.add(0);
//    		zeroCase.add(0);
//    		zeroCase.add(0);
//    		ans.add(zeroCase);
//    	}
//    	for(int i = 0; i < pos.size();i++) {
//    		for(int j = 0; j<neg.size();j++) {
//    			int sum = pos.get(i);
//        		List<Integer> element = new ArrayList<Integer>();
//    			element.add(pos.get(i));
//    			int sum2 = sum+neg.get(j);
//    			if(sum2==0) {
//    				if(zero.size()>0) {
//    					element.add(0);
//    					element.add(neg.get(j));
//    					Collections.sort(element);
//    					boolean skip = false;
//    					for(int l = 0; l < ans.size();l++) {
//    						if(element.get(0)==ans.get(l).get(0) &&element.get(1)==ans.get(l).get(1)&&element.get(2)==ans.get(l).get(2)){
//    							skip= true;
//    							break;
//    						}
//    					}
//    					
//    					if(!skip) {
//    						ans.add(List.copyOf(element));
//    					}
//    					element.clear();
//						element.add(pos.get(i));
//    				}
//    			}
//    			else if(sum2<0) {
//    				for(int k = 0; k < pos.size();k++) {
//    					if(k==i) continue;
//    					if(pos.get(k)==-1*sum2) {
//    						element.add(neg.get(j));
//    						element.add(pos.get(k));
//        					Collections.sort(element);
//        					boolean skip = false;
//        					for(int l = 0; l < ans.size();l++) {
//        						if(element.get(0)==ans.get(l).get(0) &&element.get(1)==ans.get(l).get(1)&&element.get(2)==ans.get(l).get(2)){
//        							skip= true;
//        							break;
//        						}
//        					}
//        					if(!skip) {
//        						ans.add(List.copyOf(element));
//        					}
//        					element.clear();
//    						element.add(pos.get(i));
//    					}
//    					
//    				}
//    			}
//    			else if(sum2>0) {
//    				for(int k = 0; k < neg.size();k++) {
//    					if(k==j) continue;
//    					if(neg.get(k)==-1*sum2) {
//    						element.add(neg.get(j));
//    						element.add(neg.get(k));
//        					Collections.sort(element);
//        					boolean skip = false;
//        					for(int l = 0; l < ans.size();l++) {
//        						if(element.get(0)==ans.get(l).get(0) &&element.get(1)==ans.get(l).get(1)&&element.get(2)==ans.get(l).get(2)){
//        							skip= true;
//        							break;
//        						}
//        					}
//        					if(!skip) {
//        						ans.add(List.copyOf(element));
//        					}
//        					element.clear();
//    						element.add(pos.get(i));    					}
//    					
//    				}
//    			}
//    		}
//    	}
//    	for(int m = 0; m < 3; m++) {
//			System.out.print(ans.get(0).get(m)+" ");
//		}
//		System.out.println();
//    	return ans;
    	
    	
    	
    	//Solution 3: O(n^3) TLE
//    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
//    	for(int i =0; i < nums.length;i++) {
//    		for(int j = i+1; j< nums.length;j++) {
//    			for (int k = j+1; k<nums.length;k++) {
//    				if(nums[i]+nums[j]+nums[k]==0) {
//    					
//    					List<Integer> element = new ArrayList<Integer>();
//    					element.add(nums[i]);
//    					element.add(nums[j]);
//    					element.add(nums[k]);
//    					Collections.sort(element);
//    					boolean skip = false;
//    					for(int l = 0; l < ans.size();l++) {
//    						if(element.get(0)==ans.get(l).get(0) &&element.get(1)==ans.get(l).get(1)&&element.get(2)==ans.get(l).get(2)){
//    							skip= true;
//    							break;
//    						}
//    					}
//    					if(!skip) {
//    						ans.add(element);
//    					}
//    						
//    				}
//    			}
//    		}
//    	}
//    	return ans;
        
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
