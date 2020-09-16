package com;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> out = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return out;
		}
		int columnLow = 0;
		int rowLow = 0;
		int rowHigh = matrix.length - 1;
		int columnHigh = matrix[0].length - 1;
		while (rowLow <= rowHigh && columnLow <= columnHigh) {
			for (int j = columnLow; j <= columnHigh; ++j) {
				out.add(matrix[rowLow][j]);
			}
			rowLow = rowLow + 1;

			for (int i = rowLow; i <= rowHigh; ++i) {
				out.add(matrix[i][columnHigh]);
			}
			columnHigh = columnHigh - 1;
			if (rowHigh >= rowLow && columnHigh >= columnLow) {

				for (int j = columnHigh; j >= columnLow; --j) {
					out.add(matrix[rowHigh][j]);
				}

				rowHigh = rowHigh - 1;
				for (int i = rowHigh; i >= rowLow; --i) {
					out.add(matrix[i][columnLow]);
				}

				columnLow = columnLow + 1;
			}
		}
		return out;
	}
}
