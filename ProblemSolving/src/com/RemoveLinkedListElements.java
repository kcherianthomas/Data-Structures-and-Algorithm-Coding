package com;

/*
 * Remove all elements from a linked list of integers that have value val.
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode curr = head;
		ListNode node = new ListNode(-2000);
		ListNode newHead = node;
		while (curr != null) {
			if (curr.val != val) {
				node.next = new ListNode(curr.val);
				node = node.next;
			}
			curr = curr.next;
		}
		return newHead.next;
	}
}
