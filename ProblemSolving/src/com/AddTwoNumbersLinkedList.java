package com;

public class AddTwoNumbersLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode dummyHead = dummy;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val + carry;
			carry = val / 10;
			dummy.next = new ListNode(val % 10);
			l1 = l1.next;
			l2 = l2.next;
			dummy = dummy.next;
		}
		if (l1 == null) {
			while (l2 != null) {
				int val = l2.val + carry;
				carry = val / 10;
				dummy.next = new ListNode(val % 10);
				l2 = l2.next;
				dummy = dummy.next;
			}
		}
		if (l2 == null) {
			while (l1 != null) {
				int val = l1.val + carry;
				carry = val / 10;
				dummy.next = new ListNode(val % 10);
				l1 = l1.next;
				dummy = dummy.next;
			}
		}
		if (carry == 1) {
			dummy.next = new ListNode(1);
		}
		return dummyHead.next;
	}
}
