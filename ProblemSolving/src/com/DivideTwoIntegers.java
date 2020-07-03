package com;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if (divisor == 1) {
			return dividend;
		}
		boolean isAnsNegative = false;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isAnsNegative = true;
		}
		int dividentAbs = Math.abs(dividend);
		int divisorAbs = Math.abs(divisor);

		int count = 0;
		while (dividentAbs - divisorAbs >= 0) {
			if (count == Integer.MAX_VALUE) {
				return count;
			} else {
				count++;
			}
			dividentAbs -= divisorAbs;
		}
		if (isAnsNegative) {
			count = 0 - count;
		}
		return count;
	}

	public static void main(String[] args) {
		DivideTwoIntegers a = new DivideTwoIntegers();
		System.out.println(a.divide(-2147483648, 2));
	}
}
