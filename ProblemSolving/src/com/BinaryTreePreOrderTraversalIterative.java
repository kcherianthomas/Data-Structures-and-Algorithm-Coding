package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversalIterative {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> out = new ArrayList<>();
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				out.add(cur.val);
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			cur = cur.right;
		}
		return out;
	}
}
