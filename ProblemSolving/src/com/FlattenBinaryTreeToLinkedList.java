package com;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        flat(root);
    }
    public void flat(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return;
        }
        if(root.left!=null) {
        flat(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null) {
            root = root.right;
        }
        root.right = temp;
        }
        if(root.right!=null) {
            flat(root.right);
        }
    }
}
