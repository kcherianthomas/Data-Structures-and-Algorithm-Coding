package com;

public class DivideLinkedListTwoHalf {
	private static ListNode splitList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid= slow.next;
		System.out.println(mid.toString());
		slow.next =null;
		return mid;
	}

	public static void main(String[] args) {
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(4);
		ListNode test5 = new ListNode(5);
		test1.next=test2;
		test2.next=test3;
		test3.next=test4;
		test4.next=test5;
		System.out.println(test1.toString());
		
		System.out.println(splitList(test1).toString());
	}

}
