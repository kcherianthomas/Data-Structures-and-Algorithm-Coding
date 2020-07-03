package com;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens.length == 0) {
			return 0;
		}
		Stack<String> operands = new Stack();
		int out = 0;
		for (int i = 0; i < tokens.length; ++i) {
			if (tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/")) {
				int input2 = Integer.parseInt(operands.pop());
				int input1 = Integer.parseInt(operands.pop());
				if (tokens[i].equals("*")) {
					out = input1 * input2;
				} else if (tokens[i].equals("+")) {
					out = input1 + input2;
				} else if (tokens[i].equals("-")) {
					out = input1 - input2;
				} else if (tokens[i].equals("/")) {
					out = input1 / input2;
				}
				operands.push(String.valueOf(out));
			} else {
				operands.push(tokens[i]);
			}
		}
		return Integer.parseInt(operands.pop());}
}
