package com;

//Given a linked list, remove the n-th node from the end of list and return its head.
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// when you use a dummy and return dummy.next it will help to avoid corner cases
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		int i = n;
		while (i > 0) {
			fast = fast.next;
			i--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		if (slow.next != null) {
			slow.next = slow.next.next;
		}
		return dummy.next;
	}
}
