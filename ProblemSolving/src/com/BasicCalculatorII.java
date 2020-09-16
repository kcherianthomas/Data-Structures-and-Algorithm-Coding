package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorII {

	public int calculate(String s) {
		char[] charArray = s.toCharArray();
		Stack<Integer> operand = new Stack<>();
		Stack<Character> operator = new Stack<>();
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('/', 2);
		priority.put('*', 2);
		int tempOperand = 0;
		for (int i = 0; i < charArray.length; ++i) {
			if (Character.isDigit(charArray[i])) {
				if (i == charArray.length - 1 || !Character.isDigit(charArray[i + 1])) {
					tempOperand = tempOperand * 10 + charArray[i] - '0';
					operand.add(tempOperand);
					tempOperand = 0;
				} else if (Character.isDigit(charArray[i + 1])) {
					tempOperand = tempOperand * 10 + charArray[i] - '0';
				}
			} else if (operator.isEmpty() && checkOperator(charArray[i])) {
				operator.add(charArray[i]);
			} else if (checkOperator(charArray[i])) {
				int stackTopPriority = priority.get(operator.peek());
				int currentPriority = priority.get(charArray[i]);
				if (currentPriority <= stackTopPriority) {
					operation(currentPriority, stackTopPriority, operand, operator, priority);
				}
				operator.add(charArray[i]);
			}
		}
		operation(operand, operator);
		return operand.pop();
	}

	boolean checkOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}

	private void operation(Stack<Integer> operand, Stack<Character> operator) {
		while (!operator.isEmpty()) {
			int o2 = operand.pop();
			int o1 = operand.pop();
			char op = operator.pop();
			if (op == '+') {
				operand.push(o1 + o2);
			} else if (op == '-') {
				operand.push(o1 - o2);
			} else if (op == '*') {
				operand.push(o1 * o2);
			} else if (op == '/') {
				operand.push(o1 / o2);
			}
		}
	}

	private void operation(int currentPriority, int stackTopPriority, Stack<Integer> operand, Stack<Character> operator,
			Map<Character, Integer> priority) {
		while (!operator.isEmpty() && currentPriority <= stackTopPriority) {
			int o2 = operand.pop();
			int o1 = operand.pop();
			char op = operator.pop();
			if (op == '+') {
				operand.push(o1 + o2);
			} else if (op == '-') {
				operand.push(o1 - o2);
			} else if (op == '*') {
				operand.push(o1 * o2);

			} else if (op == '/') {
				operand.push(o1 / o2);
			}
			if (!operator.isEmpty()) {
				stackTopPriority = priority.get(operator.peek());
			}
		}
	}
}
