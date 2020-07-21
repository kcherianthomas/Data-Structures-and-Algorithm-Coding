package com;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> out = new ArrayList<>();
		List<Integer> l = new ArrayList<>();

		if (root == null) {
			return out;
		}
		checkSum(root, sum, 0, out, l);
		return out;
	}

	private boolean checkSum(TreeNode root, int sum, int i, List<List<Integer>> out, List<Integer> l) {
		i += root.val;
		l.add(root.val);
		// a leaf does not have any child node
		if (root.left == null && root.right == null && i == sum) {
			out.add(new ArrayList<>(l));
			l.remove(l.size() - 1);
			return true;
		}
		boolean left = false;
		boolean right = false;
		if (root.left != null) {
			left = checkSum(root.left, sum, i, out, l);
		}
		if (root.right != null) {
			right = checkSum(root.right, sum, i, out, l);
		}
		l.remove(l.size() - 1);
		return (left || right);

	}
}
