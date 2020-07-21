package com;

import java.util.HashMap;

public class PathSumIIIUsingHashMap {
	public int pathSum(TreeNode root, int sum) {
		sumAvailable.put(0, 1);
		countSum(root, sum, 0);
		return count;
	}

	HashMap<Integer, Integer> sumAvailable = new HashMap<>();
	int count = 0;

	private void countSum(TreeNode root, int sum, int currentSum) {
		if (root == null) {
			return;
		}
		currentSum += root.val;
		if (sumAvailable.containsKey(currentSum - sum) && sumAvailable.get(currentSum - sum) > 0) {
			count = count + sumAvailable.get(currentSum - sum);
		}

		if (sumAvailable.containsKey(currentSum)) {
			sumAvailable.put(currentSum, sumAvailable.get(currentSum) + 1);
		} else {
			sumAvailable.put(currentSum, 1);
		}
		countSum(root.left, sum, currentSum);
		countSum(root.right, sum, currentSum);
		sumAvailable.put(currentSum, sumAvailable.get(currentSum) - 1);
	}
}
