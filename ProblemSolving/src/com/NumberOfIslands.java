package com;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int noOfIslands = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (!visited[i][j]) {
					List<Integer[]> noOfI = new ArrayList<>();
					traverse(i, j, grid, visited, noOfI);
					if (noOfI.size() > 0) {
						noOfIslands++;
					}
				}
				
			}
		}
		return noOfIslands;
	}

	private void traverse(int i, int j, char[][] grid, boolean[][] visited, List<Integer[]> noOfI) {
		visited[i][j] = true;
		if (grid[i][j] == '0') {
			return;
		}
		List<Integer[]> neighbours = findUnvisitedNeighbours(i, j, grid, visited);
		for (Integer[] neighbour : neighbours) {
			if (!visited[neighbour[0]][neighbour[1]]) {
				traverse(neighbour[0], neighbour[1], grid, visited, noOfI);
				visited[neighbour[0]][neighbour[1]] = true;
			}
		}
		noOfI.add(new Integer[] {i,j});
		
	}

	private List<Integer[]> findUnvisitedNeighbours(int i, int j, char[][] grid, boolean[][] visited) {
		List<Integer[]> out = new ArrayList<>();
		if (i > 0 && !visited[i - 1][j]) {
			out.add(new Integer[] { i - 1, j });
		}
		if (i < grid.length - 1 && !visited[i + 1][j]) {
			out.add(new Integer[] { i + 1, j });
		}
		if (j > 0 && !visited[i][j - 1]) {
			out.add(new Integer[] { i, j - 1 });
		}
		if (j < grid[0].length - 1 && !visited[i][j + 1]) {
			out.add(new Integer[] { i, j + 1 });
		}
		return out;
	}
}
