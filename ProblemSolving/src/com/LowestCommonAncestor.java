package com;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> l1 = new ArrayList<>();
		List<TreeNode> l2 = new ArrayList<>();
		checkAncestor(root, p, l1);
		checkAncestor(root, q, l2);
		if (l1.isEmpty() || l2.isEmpty()) {
			return null;
		}
		int i = l1.size()-1;
		int j = l2.size()-1;
		TreeNode temp = root;
		while (i >= 0 && j >= 0) {
			if (l1.get(i) != l2.get(j)) {
				return temp;
			} else {
				temp = l1.get(i);
			}
			i--;
			j--;
		}
		return temp;
	}

	private boolean checkAncestor(TreeNode root, TreeNode target, List<TreeNode> l) {
		if (root == null) {
			return false;
		} else if (root.val == target.val || checkAncestor(root.left, target, l)
				|| checkAncestor(root.right, target, l)) {
			l.add(root);
			return true;
		}
		return false;
	}
}
