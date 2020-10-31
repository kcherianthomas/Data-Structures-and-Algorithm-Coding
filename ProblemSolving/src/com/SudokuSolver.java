package com;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solve(board);
	}

	private boolean solve(char[][] board) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; ++k) {
						if (isValid(board, i, j, k)) {
							board[i][j] = k;
							if (solve(board)) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;

	}

	private boolean isValid(char[][] board, int row, int column, char k) {
		for (int i = 0; i < 9; ++i) {
			if (board[i][column] == k && i != row) {
				return false;
			}

			if (board[row][i] == k && i != column) {
				return false;
			}

			if (board[((row / 3) * 3) + (i / 3)][((column / 3) * 3) + (i % 3)] == k
					&& (((row / 3) * 3) + (i / 3) != row && ((column / 3) * 3) + (i % 3) != column)) {
				return false;
			}
		}

		return true;
	}
}
