package com;

import java.util.Stack;

public class DailyTemperature {
	public int[] dailyTemperatures(int[] T) {
		int[] out = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < T.length; ++i) {
			while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
				int topVal = stack.pop();
				out[topVal] = i - topVal;
			}
			stack.add(i);
		}
		return out;
	}
}

//73, 74, 75, 71, 69, 72, 76, 73
//73    i =1 74