package com;

import java.util.Arrays;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int[][] output = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				checkNeighBours(i, j, board, m, n, output);
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = output[i][j];
			}
		}
	}

	private void checkNeighBours(int i, int j, int[][] board, int m, int n, int[][] output) {
		int count = 0;
		if (i + 1 < m) {
			if (board[i + 1][j] == 1) {
				count++;
			}
		}
		if (j + 1 < n) {
			if (board[i][j + 1] == 1) {
				count++;
			}
		}
		if (i + 1 < m && j + 1 < n) {
			if (board[i + 1][j + 1] == 1) {
				count++;
			}
		}
		if (i - 1 <= 0) {
			if (board[i - 1][j] == 1) {
				count++;
			}
		}
		if (j - 1 <= 0) {
			if (board[i][j - 1] == 1) {
				count++;
			}
		}
		if (i - 1 <= 0 && j - 1 <= 0) {
			if (board[i - 1][j - 1] == 1) {
				count++;
			}
		}
		if (i - 1 <= 0 && j + 1 < n) {
			if (board[i - 1][j + 1] == 1) {
				count++;
			}
		}
		if (j - 1 <= 0 && i + 1 < m) {
			if (board[i + 1][j - 1] == 1) {
				count++;
			}
		}
		if (board[i][j] == 0 && count == 3) {
			output[i][j] = 1;
		} else if (board[i][j] == 1 && (count == 2 || count == 3)) {
			output[i][j] = 1;
		} else {
			output[i][j] = 0;
		}
	}
}
