package com;

import java.util.PriorityQueue;

public class KThSmallestElementInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				minHeap.add(matrix[i][j]);
			}
		}
		int temp = 0;
		while (k > 0) {
			temp = minHeap.remove();
			k--;
		}
		return temp;
	}
}
