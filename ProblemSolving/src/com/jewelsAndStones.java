package com;

import java.util.HashSet;
import java.util.Set;
/**
 * Code to find no of jewels from stones
 * J contains all the Stones that are jewels
 * and S contains all the stones
 * The time complexity is O(J.length()+S.length())
 */
public class jewelsAndStones {
	 public int numJewelsInStones(String J, String S) {
		 	int count =0;
	        Set<String> jewels = new HashSet<>();
	        for(int i=0;i<J.length();++i) {
	            jewels.add(String.valueOf(J.charAt(i)));
	        }
	        for(int i=0;i<S.length();++i) {
	            if(jewels.contains(String.valueOf(S.charAt(i)))) {
	            	count++;
	            }
	        }
	        return count;
	    }
}
