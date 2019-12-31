package com;
/*
 * Maximum Depth of Binary Tree
 */
public class MaxDepthBinaryTree {
	public int maxDepth(TreeNode root) {
		int depth = 0;
		return findMaxDepth(root, depth, depth);
	}

	int findMaxDepth(TreeNode root, int depth, int max) {

		if (root == null) {
			return max;
		} else {
			depth = depth + 1;
			int depth1 = depth;
			depth = findMaxDepth(root.left, depth, depth);
			if (depth > max) {
				max = depth;
			}
			depth = findMaxDepth(root.right, depth1, depth1);
			if (depth > max) {
				max = depth;
			}
		}
		return max;
	}
}
