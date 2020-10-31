package com;

import java.util.Arrays;




/*
 * Alexa is given n piles of equal or unequal heights. 
 * In one step, Alexa can remove any number of boxes from the pile which
 * has the maximum height and try to make it equal to the one which is just lower than the maximum height of the stack.
 * Determine the minimum number of steps required to make all of the piles equal in height.
 */
public class MinimumStepsToMakePilesEqual {
	public  int step(Integer[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}
		int count =0;
		Arrays.sort(input,(o2,o1)->o2-o1);
		for(int i=1;i<input.length;++i) {
			if(input[i]!=input[i-1]) {
				count += i;
			}
		}
		return count;
	}
}

