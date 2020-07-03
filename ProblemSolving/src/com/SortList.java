package com;

public class SortList {
	public ListNode sortList(ListNode head) {
		head = mergeSort(head);
		return head;

	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode mid = splitList(head);
			ListNode a = mergeSort(head);
			ListNode b = mergeSort(mid);
			ListNode aux = mergeLists(a, b);
			return aux;
		}
	}

	private ListNode mergeLists(ListNode a, ListNode b) {
		ListNode dummyA = a;
		ListNode dummyB = b;
		ListNode temp = new ListNode(-10);
		ListNode c = temp;
		while (dummyA != null && dummyB != null) {
			if (dummyA.val <= dummyB.val) {
				c.next = dummyA;
				c = c.next;
				dummyA = dummyA.next;
			} else if (dummyA.val > dummyB.val) {
				c.next = dummyB;
				c = c.next;
				dummyB = dummyB.next;
			}

		}
		if (dummyA == null) {
			c.next = dummyB;
		} else {
			c.next = dummyA;
		}
		return temp.next;
	}

	private ListNode splitList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		return mid;
	}

	public static void main(String[] args) {
		ListNode test1 = new ListNode(9);
		ListNode test2 = new ListNode(4);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(2);
		ListNode test5 = new ListNode(1);
		test1.next = test2;
		//test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		System.out.println(new SortList().sortList(test1));
		
	}
}
