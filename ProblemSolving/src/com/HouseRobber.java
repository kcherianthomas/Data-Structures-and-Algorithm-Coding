package com;

/*You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 */
public class HouseRobber {
	/* This is a dynamic programming question. The solution in built
	 * in a bottom up manner
	 */
	public int rob(int[] nums) {
		//Handling the base cases
		if(null==nums || nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		if(nums.length==2) {
			return Math.max(nums[0], nums[1]);
		}
		int [] dp = new int[nums.length];
		//dp[0] tells when only 1 house rob that house
		dp[0]=nums[0];
		//dp[1] tells when there are two houses rob max of these house
		dp[1]=Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;++i) {
			/* for i+1 houses, the optimal solution would be optimal
			 * solution for the i-1 houses + the money is this house
			 * or the optimal solution for i houses, whichever is greater.
			 */
			dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
		}
		return dp[nums.length-1];
	}
}
