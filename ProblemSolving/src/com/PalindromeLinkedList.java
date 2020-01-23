package com;

import java.util.Stack;
//Given a singly linked list, determine if it is a palindrome.
public class PalindromeLinkedList {
	/* I have used the idea of stack for checking palindrome
	 * I have used one slow and fast node to find middle element
	 * and added the first half to stack. From now I pop the values from stack
	 * and check if it equals value from second half on LinkedLIst
	 */
	public boolean isPalindrome(ListNode head) {
		// Base cases
		if (head == null || head.next == null) {
			return true;
		}
		ListNode oneXSpeed = head;
		ListNode twoXSpeed = head;
		//Note: Can use deque instead which could be faster
		Stack<Integer> stack = new Stack<>();
		while (twoXSpeed != null) {
			if (twoXSpeed.next != null) {
				stack.push(oneXSpeed.val);
				oneXSpeed = oneXSpeed.next;
			}
			/* Did not want to add middle element when total 
			 * no of elements are odd
			 */
			if (twoXSpeed.next == null) {
				oneXSpeed = oneXSpeed.next;
				break;
			}
			twoXSpeed = twoXSpeed.next.next;
		}
		while (oneXSpeed != null) {
			if (stack.pop() != oneXSpeed.val) {
				return false;
			}
			oneXSpeed = oneXSpeed.next;
		}
		return true;
	}
}
