package com;


/*
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 */
public class BalancedStringSplit {
	public int balancedStringSplit(String s) {
		int count = 0;
		int lcount=0;
		int rcount=0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == 'L') {
				lcount++;
			} else if (s.charAt(i) == 'R')  {
				rcount++;
			} 
			if((s.charAt(i) == 'R' || s.charAt(i) == 'L') && lcount==rcount) {
				count++;
			}
		}
		return count;

	}
}
