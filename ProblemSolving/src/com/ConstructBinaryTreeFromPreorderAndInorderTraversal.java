package com;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int leftSubsTree = 0;
		int rightSubTree = preorder.length - 1;
		return buildingTree(preorder, inorder, leftSubsTree, rightSubTree);
	}
	int preIndex = 0;

	private TreeNode buildingTree(int[] preorder, int[] inorder, int leftSubsTree, int rightSubTree) {
		if(preIndex>preorder.length) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preIndex++]);
		int rootIndex = -1;
		for (int i = leftSubsTree; i < rightSubTree; ++i) {
			if (inorder[i] == root.val) {
				rootIndex = i;
				break;
			}
		}
		root.left = buildingTree(preorder, inorder, leftSubsTree, rootIndex - 1);
		root.right = buildingTree(preorder, inorder, rootIndex + 1, rightSubTree);
		return root;
	}
}
