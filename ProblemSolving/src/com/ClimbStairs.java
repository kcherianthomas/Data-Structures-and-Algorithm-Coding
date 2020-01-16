package com;

/*You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {
	/* This is a problem on dynamic programming where we use a 
	 * bottom-up approach to built our optimal solution.
	 */
	public int climbStairs(int n) {
		//Base cases
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] dp = new int[n];
		//No of ways to climb 1 step
		dp[0] = 1;
		//No of ways to climb two steps
		dp[1] = 2;
		for (int i = 2; i < n; ++i) {
			/* No of ways to climb i+1th step is no of ways to climb
			 * ith step + no of ways to climb i-1th step
			 */
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n-1];
	}
}
