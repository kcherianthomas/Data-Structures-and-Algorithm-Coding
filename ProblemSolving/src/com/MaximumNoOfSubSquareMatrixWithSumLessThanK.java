package com;

/*
 * we have the matrix and the maxSum. We need to find maximum number of sub
 * square matrix with sum less than given sum
 */
public class MaximumNoOfSubSquareMatrixWithSumLessThanK {
	public int maximumNoOfSubSquareMatrixWithSumLessThanK(int[][] mtrx, int maxSum) {
		int[][] preSum = matrixPrefixSum(mtrx);
		return noOfSquareSubMatrixWithMaxSum(preSum, maxSum);
	}

	public int[][] matrixPrefixSum(int[][] mat) {
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

	private int noOfSquareSubMatrixWithMaxSum(int[][] prefix, int maxSum) {
		int count = 0;
		int r = prefix.length;
		int c = prefix[0].length;
		int maxSquareDimention = Math.min(r, c);
		for (int k = maxSquareDimention; k >= 1; --k) {
			for (int i = k - 1; i < r; ++i) {
				for (int j = k - 1; j < c; ++j) {
					int sum = prefix[i][j];
					if (i - k >= 0 && j - k >= 0) {
						sum = sum - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
					} else if (i - k >= 0) {
						sum = sum - prefix[i - k][j];
					} else if (j - k >= 0) {
						sum = sum - prefix[i][j - k];
					}
					if (sum < maxSum) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
