package com;
/*
 * Program to convert binary to decimal. The ListNode 
 * is available as separate java file. Each time you 
 * right shift the binValue is multiplied by two value.
 * Time complexity is O(size of linked list)
 */
public class ConvertBinaryToInteger {
	public static int getDecimalValue(ListNode head) {
		int binVal = head.val;
		while (null != head.next) {
			head = head.next;
			binVal = (binVal << 1) + head.val;
		}
		return binVal;
	}
}
