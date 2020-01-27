package com;
//Given a linked list, determine if it has a cycle in it.
public class LinkedListCycle {
	/* Use a slow and fast pointer where fast pointer goes at
	 * twice the speed as slow pointer. We can verify loop
	 * when slow == fast.
	 */
	public boolean hasCycle(ListNode head) {
		if (null == head || null == head.next) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (null == fast.next || null == fast.next.next) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}
}
