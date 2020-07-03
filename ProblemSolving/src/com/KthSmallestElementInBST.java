package com;

import java.util.ArrayList;

public class KthSmallestElementInBST {
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		getValuesinBST(list, root, k);
		return list.get(k - 1);
	}

	/*
	 *  WE us the idea that inorder traversal gives values in sorted order
	 *  Furthermore, we know we only need values until k
	 */
	
	private void getValuesinBST(ArrayList<Integer> list, TreeNode root, int k) {
		if (root == null) {
			return;
		}
		if (list.size() < k) {
			getValuesinBST(list, root.left, k);
			list.add(root.val);
			getValuesinBST(list, root.right, k);
		}
	}
}
