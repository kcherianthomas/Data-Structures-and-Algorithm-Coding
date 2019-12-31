package com;


/*
 * Given an integer n, return any array containing n 
 * unique integers such that they add up to 0.
 */
public class NUniqueIntegerSumZero {
	public int[] sumZero(int n) {
		if (n == 1) {
			return new int[] { 0 };
		}
		int[] arr = new int[n];
		if (n % 2 == 0) {
			for (int i = 1, j = 0; i <= n / 2; i++) {
				arr[j] = i;
				arr[j + 1] = i * -1;
				j += 2;
			}

		} else {
			arr[0] = 0;
			for (int i = 1, j = 1; i <= n / 2; i++) {
				arr[j] = i;
				arr[j + 1] = i * -1;
				j += 2;
			}
		}

		return arr;

	}
}
