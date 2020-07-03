package com;
//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
public class PerfectSquares {
public int numSquares(int n) {
        int size = (int) Math.sqrt(n);
        int []perfSquarArr = new int[size];
        for(int i=0;i<perfSquarArr.length;++i) {
        	perfSquarArr[i] = (i+1)*(i+1);
        }
        int []dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;++i) {
        	dp[i] = 0;
        }
        for(int i=2;i<=n;++i) {
        	dp[i] = findLeastPerfectSq(perfSquarArr,dp,i);
        }
        return dp[n];
    }

private int findLeastPerfectSq(int[] perfSquarArr, int[] dp, int i) {
	if(dp[i]!=0) {
		return dp[i];
	}
	int min = Integer.MAX_VALUE;
	int k=0;
	while( k<perfSquarArr.length && i>=perfSquarArr[k]) {
		min = Math.min(min, 1+dp[i-perfSquarArr[k]]);
		k++;
	}
	return min;
}
}
