package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinareyTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Map<Integer, List<Integer>> lvlMap = new HashMap();
		lvlOrderTracersal(root, lvlMap, 0);
		List<List<Integer>> output = new ArrayList<>();
		lvlMap.forEach((k,v)-> output.add(v));
		return output;
	}

	private void lvlOrderTracersal(TreeNode root, Map<Integer, List<Integer>> lvlMap, int lvl) {
		if(root!=null) {
			if(lvlMap.containsKey(lvl)) {
				lvlMap.get(lvl).add(root.val);
			} else {
				List<Integer> tempList = new ArrayList<>();
				tempList.add(root.val);
				lvlMap.put(lvl, tempList);
			}
			lvlOrderTracersal(root.left, lvlMap, lvl+1);
			lvlOrderTracersal(root.right, lvlMap, lvl+1);
		}
		
	}
}
