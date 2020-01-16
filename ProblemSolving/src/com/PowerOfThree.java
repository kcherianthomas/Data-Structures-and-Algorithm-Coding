package com;
/*
 * Given an integer, write a function to determine if it is a power of three.
 */
public class PowerOfThree {
	//The below program has a logarithmic time complexity
	public boolean isPowerOfThree(int n) {
		//Condition to handle negative and zero input
		if (n <= 0) {
			return false;
		}
		while (n > 1) {
			if (n % 3 != 0) {
				return false;
			}
			n /= 3;
		}
		return true;
	}
}
