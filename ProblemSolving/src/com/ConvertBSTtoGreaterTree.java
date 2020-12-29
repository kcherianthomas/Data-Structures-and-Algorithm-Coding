package com;

public class ConvertBSTtoGreaterTree {
	public TreeNode convertBST(TreeNode root) {
		int sum = findSum(root, 0);
		inorderConvert(root, sum);
		return root;
	}

	private int inorderConvert(TreeNode root, int sum) {
		if (root != null) {
			sum = inorderConvert(root.left, sum);
			int temp = root.val;
			root.val = sum;
			sum = sum - temp;
			sum = inorderConvert(root.right, sum);
		}
		return sum;
	}

	private int findSum(TreeNode root, int sum) {
		if (root != null) {
			sum = findSum(root.left, sum);
			sum += root.val;
			sum = findSum(root.right, sum);
		}
		return sum;
	}
}
