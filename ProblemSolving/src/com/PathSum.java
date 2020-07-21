package com;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return checkSum(root, sum, 0);
	}

	private boolean checkSum(TreeNode root, int sum, int i) {
		i += root.val;
		// a leaf does not have any child node
		if (root.left == null && root.right == null && i == sum) {
			return true;
		}
		if (root.left != null && checkSum(root.left, sum, i)) {
			return true;
		} else if (root.right != null) {
			return checkSum(root.right, sum, i);
		}
		return false;
	}
}
