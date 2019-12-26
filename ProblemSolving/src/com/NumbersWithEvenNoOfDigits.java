package com;

/* This is a program to count
 * no of integers with even no
 * of digits.
 */
public class NumbersWithEvenNoOfDigits {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (Integer temp : nums) {
			/*
			 * Have used log(n) to count the digits to reduce time complexity to n. Please
			 * understand its constraints.
			 */
			if (((int) (Math.log10(temp) + 1)) % 2 == 0) {
				count++;
			}
		}
		return count;
	}
}
