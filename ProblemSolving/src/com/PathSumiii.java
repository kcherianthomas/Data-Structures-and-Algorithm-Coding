package com;

public class PathSumiii {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return count;
		}
		countSum(root, sum, 0);
		if (root.left != null) {
			pathSum(root.left, sum);
		}
		if (root.right != null) {
			pathSum(root.right, sum);
		}
		return count;
	}

	int count = 0;

	private void countSum(TreeNode root, int sum, int i) {
		if (root == null) {
			return;
		}
		i += root.val;
		if (sum == i) {
			count++;
		}

		countSum(root.left, sum, i);
		countSum(root.right, sum, i);

	}
}
