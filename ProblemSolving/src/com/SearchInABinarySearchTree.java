package com;

/*
 * Given the root node of a binary search tree (BST) and a value. 
 * You need to find the node in the BST that the node's value equals
 * the given value. Return the subtree rooted with that node. 
 * If such node doesn't exist, you should return NULL.
 */
public class SearchInABinarySearchTree {
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (val == root.val) {
			return root;
		} else if (val < root.val) {
			return searchBST(root.left, val);
		} else {
			return searchBST(root.right, val);
		}
	}
}
