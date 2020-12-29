package com;

public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {

		// get the node to delete
		if (root == null) {
			return null;
		}
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			// found the node to delete
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left == null && root.right != null) {
				root = root.right;
			} else if (root.left != null && root.right == null) {
				root = root.left;
			} else {
				// find successor and swap value and delete the node at successor
				TreeNode temp = root.right;
				while (temp.left != null) {
					temp = temp.left;
				}
				root.val = temp.val;
				temp.val = key;
				root.right = deleteNode(root.right, key);
			}
		}
		return root;
	}
}
