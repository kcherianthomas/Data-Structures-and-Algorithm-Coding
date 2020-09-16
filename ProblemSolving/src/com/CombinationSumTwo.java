package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> out = new ArrayList<>();
		getCombinationList(candidates, target, 0, out, new ArrayList<Integer>());
		return out;
	}

	private void getCombinationList(int[] candidates, int target, int index, List<List<Integer>> out,
			ArrayList<Integer> list) {
		if (target == 0) {
			out.add(new ArrayList<Integer>(list));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = index; i < candidates.length; ++i) {
			list.add(candidates[i]);
			getCombinationList(candidates, target - candidates[i], i + 1, out, list);
			list.remove(list.size() - 1);
			while (i + 1 <= candidates.length - 1 && candidates[i + 1] == candidates[i]) {
				i++;
			}
		}
	}
}
