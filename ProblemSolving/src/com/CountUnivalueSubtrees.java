package com;

public class CountUnivalueSubtrees {
	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return count;
		}
		countUnivalSubtreesHelper(root);
		return count;
	}

	public int countUnivalSubtreesHelper(TreeNode root) {

		if (root.left == null && root.right == null) {
			count++;
			return root.val;

		} else if (root.left != null && root.right != null) {
			int left = countUnivalSubtreesHelper(root.left);
			int right = countUnivalSubtreesHelper(root.right);
			if (left == right && left == root.val) {
				count++;
				return root.val;
			} else {
				return 1001;
			}
		} else if (root.left != null) {
			int left = countUnivalSubtreesHelper(root.left);
			if (left == root.val) {
				count++;
				return root.val;
			} else {
				return 1001;
			}
		} else if (root.right != null) {
			int right = countUnivalSubtreesHelper(root.right);
			if (right == root.val) {
				count++;
				return root.val;
			} else {
				return 1001;
			}
		}
		return 1001;

	}
}
