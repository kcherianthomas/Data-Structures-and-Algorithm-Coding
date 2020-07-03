package com;

/* Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchATwoDMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Base condition
		if (matrix.length == 0) {
			return false;
		}
		int i = 0;
		int j = (matrix[0].length) - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
}
