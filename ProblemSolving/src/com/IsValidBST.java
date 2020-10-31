package com;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	     list =  inOrder(root,list);
	        for(int i=1;i<list.size();++i) {
	            if(list.get(i-1)>list.get(i)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    private List<Integer> inOrder(TreeNode root,List<Integer>  list) {
	        if(root!=null) {
	            list = inOrder(root.left,list);
	            list.add(root.val);
	            list =inOrder(root.right,list);
	        }
	        return list;
	    }
}
