package com;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		ListNode head1 = head;
		ListNode head2 = head.next;
		ListNode odd = head;
		ListNode even = head.next;
		while (true) {
			if (null == odd.next.next) {
				break;
			}
			odd.next = odd.next.next;
			odd = odd.next;
			if (null == even.next.next) {
				even.next = null;
				break;
			}
			even.next = even.next.next;
			even = even.next;
		}
		odd.next = head2;

		return head1;
	}
}
