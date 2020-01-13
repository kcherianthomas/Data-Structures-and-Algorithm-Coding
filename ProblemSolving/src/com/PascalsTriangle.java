package com;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalsTriangle {
	/*
	 * This is not the most optimized code. The time complexity is O(n^2)
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> finalList = new ArrayList<>();
		if(numRows==0) {
			return finalList;
		}
		// 1st row of PT
		List<Integer> rowList = new ArrayList<>();
		rowList.add(1);
		finalList.add(rowList);
		//getting values for PT from second row
		for (int i = 2; i <= numRows; ++i) {
			//getting values from previous row
			List<Integer> listForRow = finalList.get(i - 2);
			rowList = new ArrayList<>();
			for (int j = 1; j <= i; ++j) {
				//first and last element always one
				if (j == 1 || j == i) {
					rowList.add(1);
				} else {
					//each number is sum of two numbers always above it
					rowList.add(listForRow.get(j - 2) + listForRow.get(j - 1));
				}
			}
			//Adding that row to final List
			finalList.add(rowList);
		}
	return finalList;
	}
}