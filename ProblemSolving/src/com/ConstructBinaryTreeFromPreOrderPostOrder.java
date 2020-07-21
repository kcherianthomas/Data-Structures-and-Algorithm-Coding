package com;

/*
 * Note: If preorder and post order are given,
 * It is not possible to create a unique binary tree. 
 * However, it is possible to construct a unique Full Binary Tree
 */
public class ConstructBinaryTreeFromPreOrderPostOrder {
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		return construct(pre, post, 0, 0,pre.length);
	}

	private TreeNode construct(int[] pre, int[] post, int preStart,int postStart,int length ) {
		if(length==0) {
			return null;
		}
		/*
		 *  Once we use first element from pre order we are going to
		 *  use second element in preorder to split into left and right
		 */
        TreeNode root = new TreeNode(pre[preStart++]);
		if(length==1) {
			return root;
		}
		
		int index =1;
		for(;index<length;++index) {
			if(pre[preStart]==post[postStart+index-1]) {
				break;
			}
		}
		root.left = construct(pre, post, preStart, postStart,index);
		//The last element will be root, so root.right can omit that one
		root.right = construct(pre, post, preStart+index, postStart+index,length-1-index);
		return root;
	}
}
