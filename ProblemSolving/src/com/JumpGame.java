package com;

public class JumpGame {
	 public boolean canJump(int[] nums) {
	        int currIndex=0;
	        int maxIndex = 0;
	        while(currIndex<=maxIndex && currIndex<nums.length) {
	            if(currIndex + nums[currIndex]>maxIndex) {
	                maxIndex = currIndex + nums[currIndex];
	            }
	            currIndex++;
	        }
	        return currIndex==nums.length;
	    }
}
