package com;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if(null ==height || height.length==0 || height.length==1) {
			return 0;
		}
		int left = 0;
		int right = height.length-1;
		int maxArea =0;
		while(left<right) {
			int area = (right - left)*Math.min(height[left], height[right]);
			if(maxArea<area) {
				maxArea=area;
			}
			if(height[left]<=height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}
}
