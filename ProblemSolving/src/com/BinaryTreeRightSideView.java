package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	// Almost same as level order traversal. we just get the rightmost element in
	// each level
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> out = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root == null) {
			return out;
		}
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; ++i) {
				TreeNode node = q.poll();
				if (i == count - 1) {
					out.add(node.val);
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
		return out;
	}
}
