package com;

import java.util.HashSet;
import java.util.Set;
/*
 * A happy number is a number defined by the following process: Starting with any positive integer,
 *  replace the number by the sum of the squares of its digits, and repeat the process until the 
 *  number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 *  Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		// The set is created to check infinite loop
		Set<Integer> set = new HashSet<>();

		return isHappyWithSet(n, set);
	}

	public boolean isHappyWithSet(int n, Set<Integer> set) {
		set.add(n);
		int newNum = 0;
		//creating a copy of n
		int num = n;
		//getting sum of digits for newNum
		while (num != 0) {
			int digit = num % 10;
			newNum += digit * digit;
			num = num / 10;
		}
		//check infinite loop,ie the newNum is already in set
		if (set.contains(newNum)) {
			return false;
		} else if(newNum==1) {
			return true;
		}
		//recursive call
		return isHappyWithSet(newNum, set);
	}
}
