package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderIterative {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> out = new ArrayList<>();
		if (root == null) {
			return out;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.add(root);
		while (!stack1.isEmpty()) {
			TreeNode cur = stack1.pop();
			if (cur.left != null) {
				stack1.push(cur.left);
			}
			if (cur.right != null) {
				stack1.push(cur.right);
			}
			stack2.push(cur);
		}
		while (!stack2.isEmpty()) {
			TreeNode popped = stack2.pop();
			out.add(popped.val);
		}
		return out;
	}
}
