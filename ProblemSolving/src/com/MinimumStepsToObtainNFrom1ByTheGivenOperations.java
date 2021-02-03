package com;

/*
 * Given an integer N, the task is to find the minimum number of operations needed to obtain the number N starting from 1. 
 * Below are the operations: 
 * Add 1 to the current number.
 * Multiply the current number by 2.
 * Multiply the current number by 3.
*/
public class MinimumStepsToObtainNFrom1ByTheGivenOperations {

	public static int find_sequence(int n) {
		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; ++i) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(MinimumStepsToObtainNFrom1ByTheGivenOperations.find_sequence(7));

	}

}
