package com;

public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[] {};
		}
		int maxRows = matrix.length - 1;
		int maxCol = matrix[0].length - 1;
		int[] out = new int[(maxRows + 1) * (maxCol + 1)];
		boolean goDown = false;
		int curRow = 0;
		int curCol = 0;
		int i = 0;
		while (curCol <= maxCol && curRow <= maxRows) {
			out[i++] = matrix[curRow][curCol];
			if (goDown) {
				if (curCol == 0) {
					if (curRow < maxRows) {
						curRow += 1;
						goDown = false;
					} else {
						curCol += 1;
						goDown = false;
					}
				} else if (curRow == maxRows) {
					curCol += 1;
					goDown = false;
				} else {
					curRow += 1;
					curCol -= 1;
				}
			} else {
				if (curRow == 0) {
					if (curCol < maxCol) {
						curCol += 1;
						goDown = true;
					} else {
						curRow += 1;
						goDown = true;
					}
				} else if (curCol == maxCol) {
					curRow += 1;
					goDown = true;
				} else {
					curRow -= 1;
					curCol += 1;
				}
			}
		}
		return out;
	}
}
