package com;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode first = head;
		if (first.next == null) {
			return first;
		}
		ListNode prev = new ListNode(-10);
		ListNode prevHead = prev;
		while (first != null && first.next != null) {
			ListNode second = first.next;
			ListNode temp = second.next;
			second.next = first;
			prev.next = second;
			first.next = temp;
			prev = first;
			first = temp;
		}
		return prevHead.next;
	}
}
