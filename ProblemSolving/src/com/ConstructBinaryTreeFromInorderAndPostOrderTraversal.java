package com;

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildingTree(inorder, postorder, 0, postorder.length - 1);
	}

	int reduceIndex = 1;

	private TreeNode buildingTree(int[] inorder, int[] postorder, int leftSub, int rightSub) {
		if (leftSub >rightSub) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorder.length - (reduceIndex++)]);
		int rootIndex = 0;
		for (int i = leftSub; i <= rightSub; i++) {
			if (inorder[i] == root.val) {
				rootIndex = i;
				break;
			}
		}
        root.right = buildingTree(inorder, postorder, rootIndex + 1, rightSub);
		root.left = buildingTree(inorder, postorder, leftSub, rootIndex - 1);
		
		return root;
	}
}
