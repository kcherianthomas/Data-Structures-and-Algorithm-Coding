package com;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode dummyLowHead = new ListNode(-100);
		ListNode dummyHighHead = new ListNode(-100);
		ListNode dummyLow = dummyLowHead;
		ListNode dummyhigh = dummyHighHead;
		ListNode node = head;
		while (node != null) {
			if (node.val < x) {
				dummyLow.next = node;
				dummyLow = dummyLow.next;

			} else {
				dummyhigh.next = node;
				dummyhigh = dummyhigh.next;
			}
			node = node.next;
		}
		// We need to clear last high value.next at end
		dummyhigh.next = null;
		dummyLow.next = dummyHighHead.next;
		return dummyLowHead.next;
	}
}
