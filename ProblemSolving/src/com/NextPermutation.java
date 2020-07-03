package com;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= -1) {
            if(i==-1) {
                reverse(nums,0);
            }else if (nums[i] < nums[i + 1]) {
				int index = findIndexOfNumGreaterThanI(nums, i+1);
				swap(nums,i,index);
				reverse(nums,i+1);
                break;
			}
			i--;
		}

	}

	private int findIndexOfNumGreaterThanI(int[] nums, int i) {
		int index =i;
		int checkValue = i-1;
		while(i<nums.length) {
			if(nums[i]<=nums[index] && nums[i]> nums[checkValue]) {
				index = i;
			}
			i++;
		}
		return index;
	}

	private void swap(int[] nums, int indexToBeSwapped, int minIndex) {
		int temp = nums[minIndex];
		nums[minIndex] = nums[indexToBeSwapped];
		nums[indexToBeSwapped] = temp;
        for(int i=0;i<nums.length;++i) {
        System.out.println(nums[i]);
        }
	}

	private void reverse(int[] nums, int indexToBeSwapped) {
        int right = nums.length - 1;
		int left = indexToBeSwapped;
		while (left <= right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			++left;
			--right;
		}
	}
}
