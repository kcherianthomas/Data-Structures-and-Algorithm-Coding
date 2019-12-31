package com;
/*
 * Given the root node of a binary search tree, return the sum of values
 * of all nodes with value between L and R (inclusive).
 */
public class RangeSumBST {
	public int rangeSumBST(TreeNode root, int L, int R) {
		int sum = 0;
		return sumBST(root, L, R, sum);
	}

	public int sumBST(TreeNode root, int L, int R, int sum) {
		if (root == null) {
			return sum;
		}
		if (root.val >= L && root.val <= R) {
			sum += root.val;
		}
		if (root.val >= R) {
			sum = sumBST(root.left, L, R, sum);
		} else if (root.val < L) {
			sum = sumBST(root.right, L, R, sum);
		} else if (root.val >= L && root.val <= R) {
			sum = sumBST(root.left, L, R, sum);
			sum = sumBST(root.right, L, R, sum);
		}
		return sum;
	}
}
