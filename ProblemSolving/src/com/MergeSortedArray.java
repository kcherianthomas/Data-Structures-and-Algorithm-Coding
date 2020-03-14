package com;
/* Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from nums2.
 */
public class MergeSortedArray {
	/* We use to pointers to point to end of both arrays. Now a 
	 * third pointer is used to store the values into num1. 
	 * We start from last position of num1 and add the largest of num1 and num2
	 * to that position, then we decrease the pointer of larger array by 1and keep this
	 * comparison. At the end if we are left to add with some values of num2 to add we do that.
	 */
public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=m-1;
        int k=n-1;
        for(int i=m+n-1;i>=0;--i) {
            if(j>=0 && k>=0) {
                if(nums2[k]>=nums1[j]) {
                    nums1[i] = nums2[k--];
                } else {
                    nums1[i] = nums1[j--];
                }
            } else if(j<0 && k>=0) { //the case when all num1 values are already at right place
                nums1[i] = nums2[k--];
            }
        }
    }
}
