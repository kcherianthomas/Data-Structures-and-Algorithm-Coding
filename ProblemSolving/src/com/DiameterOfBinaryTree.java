package com;

public class DiameterOfBinaryTree {
	/*
	 * The time complexity is o(n) and no constant extra space
	 */
	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {

		findHeightUpdateDiameter(root);
		return diameter;
	}

	private int findHeightUpdateDiameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// we keep finding lh and rh for each node and at same time we calculate
		// diameter and calculate max diameter
		int lh = findHeightUpdateDiameter(root.left);
		int rh = findHeightUpdateDiameter(root.right);
		// Please note in some books diameter = 1+lh+rh instead of lh+rh
		diameter = Math.max(diameter, lh + rh);
		return (1 + Math.max(lh, rh));
	}
}
