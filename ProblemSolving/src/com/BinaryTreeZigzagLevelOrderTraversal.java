package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> out = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		boolean reverse = false;
		if (null != root) {
			q.add(root);
		}
		while (!q.isEmpty()) {
			int count = q.size();
			LinkedList<Integer> l = new LinkedList<>();
			for (int i = 0; i < count; ++i) {
				TreeNode temp = q.poll();
				if (!reverse) {
					l.add(temp.val);
				} else {
					l.addFirst(temp.val);
				}
				if (null != temp.left) {
					q.add(temp.left);
				}
				if (null != temp.right) {
					q.add(temp.right);
				}
			}
			out.add(l);
			reverse = !reverse;
		}
		return out;
	}
}
