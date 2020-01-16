package com;

public class PowerOfThreeADifferentIntution {
	/*
	 * We know that the maximum signed int value(Integer.MAX_VALUE) is 2147483647.
	 * log3(2147483647) = 19.56 Therefore max power of three is 19 for 4 byte
	 * integer If we divide 3^19 which is equal to 1162261467 by N and remainder is
	 * 0 then it is a power of three
	 */

	public boolean isPowerOfThree(int n) {
		// Condition to handle negative and zero input
		return (n >= 1 && (1162261467 % n) == 0) ;
		/* You can also use the below logic to check the power of n
		 * we take log10(n)/lof10(3) and check if its divisible by 1
		 * which means that it has no fractional part
		 * return (n >= 1 && (Math.log10(n)/Math.log10(3))%1 == 0) 
		*/
	}
}
