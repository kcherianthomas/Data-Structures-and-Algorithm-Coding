package com;

import java.util.ArrayList;
import java.util.List;

public class FindAncestorsForANodeBinaryTree {
	private List<Integer> findAncestor(TreeNode root, TreeNode target) {
		List output = new ArrayList<>();
		checkAncestor(root, target, output);
		return output;
	}

	private boolean checkAncestor(TreeNode root, TreeNode target, List output) {
		if (root == null) {
			return false;
		} else if (root.val == target.val) {
			output.add(root.val);
			return true;
		} else if(checkAncestor(root.left, target, output)||checkAncestor(root.right, target, output) ) {
			output.add(root.val);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode test1 = new TreeNode(1);
		TreeNode test2 = new TreeNode(2);
		TreeNode test3 = new TreeNode(3);
		TreeNode test4 = new TreeNode(4);
		TreeNode test5 = new TreeNode(5);
		TreeNode test6 = new TreeNode(6);
		TreeNode test7 = new TreeNode(7);
		TreeNode test8 = new TreeNode(8);
		TreeNode test9 = new TreeNode(9);
		test1.left = test2;
		test1.right = test3;
		test2.left = test4;
		test2.right = test5;
		test5.right = test8;
		test3.left = test6;
		test3.right = test7;
		FindAncestorsForANodeBinaryTree a = new FindAncestorsForANodeBinaryTree();
		System.out.println(a.findAncestor(test1, test4));
	}
}
