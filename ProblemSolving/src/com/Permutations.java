package com;
/*
 * Given a collection of distinct integers, return all possible permutations.
 */
import java.util.ArrayList;
import java.util.List;

/*
 * This has a time complexity of o(n*n!)
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		List<List<Integer>> output = new ArrayList<>();
		permutation(output,nums, l, r);
		return output;
	}

	private void permutation(List<List<Integer>> output, int[] nums, int l, int r) {
		if (l == r) {
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<=r;++i) {
				list.add(nums[i]);
			}
			output.add(list);
		}
		for(int i=l;i<=r;++i) {
			swap(nums,l,i);
			permutation(output,nums, l+1, r);
			swap(nums,l,i);
		}
	}
	private void swap(int [] nums, int l,int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
	
}
