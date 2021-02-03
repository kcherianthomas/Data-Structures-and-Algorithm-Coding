package com;

public class MatrixPrefixSum {
	// Finding the prefix sum
	static int[][] matrixPrefixSum(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		int[][] preSum = new int[r][c];
		preSum[0][0] = mat[0][0];
		for (int i = 1; i < r; ++i) {
			preSum[i][0] = preSum[i - 1][0] + mat[i][0];
		}
		for (int j = 1; j < c; ++j) {
			preSum[0][j] = preSum[0][j - 1] + mat[0][j];
		}
		for (int i = 1; i < r; ++i) {
			for (int j = 1; j < c; ++j) {
				preSum[i][j] = mat[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
			}
		}
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				System.out.print(preSum[i][j] + " ");
			}
			System.out.print("\n");
		}
		return preSum;
	}

	
	public static void main(String[] args) {
	//	int[][] mtrx = { { 1, 7, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 9, 6, 7, 3 }, { 4, 3, 2, 4, 5 },
		//		{ 5, 1, 5, 3, 1 } };
		int[][] mtrx = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 }};

		// Print total number of sub matrix
		int[][] prefix = matrixPrefixSum(mtrx);
		
	}

}
