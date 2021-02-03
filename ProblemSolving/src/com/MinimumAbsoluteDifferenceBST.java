package com;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceBST {
	public int getMinimumDifference(TreeNode root) {
        List<Integer> list = inOrder(root,new ArrayList<Integer>());
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++) {
        	min = Math.min(min, list.get(i+1)-list.get(i));
        }
        return  min;
    }

	private ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arrayList) {
		if(root!=null) {
			arrayList = inOrder(root.left,arrayList);
			arrayList.add(root.val);
			arrayList = inOrder(root.right,arrayList);
		}
		return arrayList;
	}
}
