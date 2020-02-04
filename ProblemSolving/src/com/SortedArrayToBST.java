package com;
/* Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every node 
 * never differ by more than 1.
 */
public class SortedArrayToBST {
	/* Find the middle element set is as root.
	 * The root.left will be middle element that is found 
	 * from [first index to middle-1] 
	 * The root.right will be middle element that is found
	 * from [middle+1 to last element]
	 * We recursively keep doing it until first>last
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		//Base Case
		if (null == nums || nums.length == 0) {
			return null;
		}
		return getBST(nums, 0, nums.length - 1);
	}
	public TreeNode getBST(int[] nums, int first, int last) {
		if (first > last) {
			return null;
		}
		int middle = first + (last - first) / 2;
		TreeNode current = new TreeNode(nums[middle]);
		current.left = getBST(nums, first, middle - 1);
		current.right = getBST(nums, middle + 1, last);
		return current;
	}

}
