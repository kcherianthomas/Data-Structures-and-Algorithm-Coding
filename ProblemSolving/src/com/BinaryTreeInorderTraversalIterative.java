package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalIterative {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> out = new ArrayList<>();
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			out.add(cur.val);
			cur = cur.right;
		}
		return out;
	}
}
