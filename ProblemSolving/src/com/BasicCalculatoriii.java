package com;

import java.util.Stack;

public class BasicCalculatoriii {
	public int calculate(String s) {
		// check null condition
		if (s.trim().length() == 0) {
			return 0;
		}

		// Defining required stacks
		Stack<Integer> operand = new Stack<>();
		Stack<Character> operation = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			char val = s.charAt(i);
			if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                operand.push(num);
            }else if ((operation.isEmpty() && (val == '+' || val == '-' || val == '*' || val == '/' || val == '('))
					|| val == '(') {
				operation.add(val);
				i++;
			} else if (val == '*' || val == '/') {
				char top = operation.peek();
				if (top == '(' || top == '+' || top == '-') {
					operation.add(val);
					i++;
				} else if (top == '*' || top == '/') {
					calculate(operand, operation);
				}
			} else if (val == '+' || val == '-') {
				char top = operation.peek();
				if (top == '(') {
					operation.add(val);
					i++;
				} else {
					calculate(operand, operation);
				}
			} else if (val == ')') {
				while (operation.peek() != '(') {
					calculate(operand, operation);
				}
				operation.pop();
				i++;
			}
		}
		while(!operation.isEmpty()) {
			calculate(operand, operation);
		}
		return operand.pop();
	}

	private void calculate(Stack<Integer> operand, Stack<Character> operation) {
		int inp2 = operand.pop();
		int inp1 = operand.pop();
		char op = operation.pop();
		if (op == '+') {
			operand.push(inp1 + inp2);
		} else if (op == '-') {
			operand.push(inp1 - inp2);
		} else if (op == '*') {
			operand.push(inp1 * inp2);
		} else if (op == '/') {
			operand.push(inp1 / inp2);
		}
	}
}
