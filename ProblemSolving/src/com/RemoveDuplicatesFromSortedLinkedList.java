package com;
/* Given a sorted linked list, delete all duplicates such that
 * each element appear only once.
 */
public class RemoveDuplicatesFromSortedLinkedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (null == head) {
			return null;
		}
		ListNode current = head;
		while (null != current.next) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
}
