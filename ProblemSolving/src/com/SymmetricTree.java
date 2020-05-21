package com;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null) { return true;}
        TreeNode l =root.left;
		TreeNode r =root.right;
		return checkSymmetry(l,r); 
	}
	
	public boolean checkSymmetry(TreeNode left,TreeNode right) {if(null==left && null==right) {
        return true;
    }
    if((null==left && null!=right) || (null==right && null!=left)) {
        return false;
    }
	if(left.val!=right.val) {
		return false;
	}
    
	if(!checkSymmetry(left.left,right.right)) {
        return false;
    }
    
    
	if(!checkSymmetry(left.right,right.left)){
        return false;
    }
    
    
	return true;}
}
