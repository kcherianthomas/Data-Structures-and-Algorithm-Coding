package com;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		right[0] = 1;
		left[0] = 1;
		for(int i=1;i<left.length;++i) {
			left[i]=left[i-1]*nums[i-1];
			}
        int j=nums.length-1;
		for(int i=1;i<right.length;++i) {
			right[i]=right[i-1]*nums[j];
			--j;
		}
        j=right.length-1;
		for(int i=0;i<output.length;++i) {
			output[i] = left[i]*right[j];
            --j;
		}
		
		return output;
	}
}
