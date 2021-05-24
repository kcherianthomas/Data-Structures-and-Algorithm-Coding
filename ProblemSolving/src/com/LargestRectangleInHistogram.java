package com;

import java.util.Stack;

/*Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
	// [2,1,5,6,2,3].
	//i 0 1 2 3 4 5
	/*
	 * Approach:
	 * We will find area with x as longest bar
	 * for eg :
	 * largest rectangle with bar at index 0 as smallest = 2  (2*1)
	 * largest rectangle with bar at index 1 as smallest = 6  (1*6)
	 * largest rectangle with bar at index 2 as smallest = 10 (5*2)
	 * largest rectangle with bar at index 3 as smallest = 6  (6*1)
	 * largest rectangle with bar at index 4 as smallest = 8  (2*4)
	 * largest rectangle with bar at index 5 as smallest = 3   (3*1)
	 */
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		int top = 0;
		int maxArea = Integer.MIN_VALUE;
		while (index < heights.length) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
				stack.add(index++);
			} else {
				top = stack.pop();
				int area = heights[top]*(stack.isEmpty()?index:index-stack.peek()-1);
				maxArea = Math.max(maxArea, area);
			}
		}
		while(!stack.isEmpty() ) {
			top = stack.pop();
			int area = heights[top]*(stack.isEmpty()?index:index-stack.peek()-1);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
}
