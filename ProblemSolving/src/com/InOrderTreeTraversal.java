package com;

import java.util.ArrayList;
import java.util.List;

public class InOrderTreeTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		addInOrder(root, list);
		return list;
	}

	private void addInOrder(TreeNode root, List<Integer> list) {
		if (root!=null) {
			inorderTraversal(root.left);
			list.add(root.val);
			inorderTraversal(root.right);
		} 
	}
}
