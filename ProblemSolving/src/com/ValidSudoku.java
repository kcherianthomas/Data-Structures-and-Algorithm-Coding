package com;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; ++i) {
			boolean[] rowCheck = new boolean[9];
			boolean[] columnCheck = new boolean[9];
			boolean[] gridCheck = new boolean[9];
			for (int j = 0; j < 9; ++j) {
				if ((board[j][i] != '.')) {
					if (rowCheck[board[j][i] - '1']) {
						return false;
					} else {
						rowCheck[board[j][i] - '1'] = true;
					}
				}
				if ((board[i][j] != '.')) {
					if (columnCheck[board[i][j] - '1']) {
						return false;
					} else {
						columnCheck[board[i][j] - '1'] = true;
					}
				}
				int gridRow = (i / 3) * 3 + j / 3;
				int gridCol = (i % 3) * 3 + j % 3;
				if (board[gridRow][gridCol] != '.') {
					if (gridCheck[board[gridRow][gridCol] - '1']) {
						return false;
					} else {
						gridCheck[board[gridRow][gridCol] - '1'] = true;
					}
				}
			}
		}
		return true;
	}

}
