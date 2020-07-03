package com;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
 * Do it in-place.
 */
public class SetMatrixZero {
	// we are assuming one dummy is available to set the value to
	final int DUMMY = -10000;
	public void setZeroes(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[i][j] == 0) {
					setRowColumnZero(i, j, matrix);
				}
			}
		}
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[i][j] == DUMMY) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private void setRowColumnZero(int i, int j, int[][] matrix) {
		int k = 0;
		while (k < matrix[0].length) {
			if (matrix[i][k] != 0) {
				matrix[i][k] = DUMMY;
			}
			k++;
		}
		k = 0;
		while (k < matrix.length) {
			if (matrix[k][j] != 0) {
				matrix[k][j] = DUMMY;
			}
			k++;
		}
	}
}
