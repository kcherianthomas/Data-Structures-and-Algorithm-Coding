package com;

//Implement pow(x, n), which calculates x raised to the power n (xn).
public class PowX_N {
	public double myPow(double x, int n) {
		if (n < 0) {
			/*
			 * we need to handle condition for overflow
			 * when Integer.min = n
			 * that is n= -2147483648 -n is also -2147483648
			 * therefore we add+1 to N and then take opposite sign
			 * we multiply with 1/x to equal the -1 added
			 */
			return 1 / x * 1 / Power(x, -(n + 1));
		}
		return Power(x, Math.abs(n));
	}

	private double Power(double x, int n) {

		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		}
		if (n % 2 == 0) {
			double half = myPow(x, n / 2);
			return half * half;

		} else {
			double half = myPow(x, n / 2);
			return half * half * x;

		}
	}
}
