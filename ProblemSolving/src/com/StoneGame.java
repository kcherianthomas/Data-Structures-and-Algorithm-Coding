package com;

/*
 * Alex and Lee play a game with piles of stones.  There are an even number 
 * of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from 
 * either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person 
 * with the most stones wins.Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */

// I am going to have the scores also
public class StoneGame {

	public class Pair {
		int left;
		int right;
	}

	public boolean stoneGame(int[] piles) {
		Pair[][] dp = new Pair[piles.length][piles.length];
		for (int i = 0; i < piles.length; ++i) {
			for (int j = 0; j < piles.length; ++j) {
				dp[i][j] = new Pair();
			}
		}
		for (int i = 0; i < piles.length; ++i) {
			dp[i][i].left = piles[i];
		}
		for (int i = 2; i < piles.length; ++i) {
			for (int j = 0; j < piles.length - i; ++j) {
				int k = i - 1 + j;
				if (piles[j] + dp[j + 1][k].right > piles[k] + dp[j][k - 1].right) {
					dp[i][j].left = piles[j] + dp[j + 1][k].right;
					dp[i][j].right = dp[j][k - 1].left;
				} else {
					dp[j][k].left = piles[k] + dp[j][k - 1].right;
					dp[j][k].right = dp[j][k - 1].left;
				}
			}
		}
		return dp[piles.length - 1][piles.length - 1].left > dp[piles.length - 1][piles.length - 1].right;
	}
}
