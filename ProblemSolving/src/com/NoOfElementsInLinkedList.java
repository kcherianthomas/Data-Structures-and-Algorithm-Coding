package com;

public class NoOfElementsInLinkedList {
	private int getCount(ListNode root) {
		int count = 0;
		ListNode slow = root;
		ListNode fast = root;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			count++;
		}
		// To get correct count we multiple with 2 and add 1 if fast !=null
		count = count * 2;
		if (fast != null) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode test1 = new ListNode(9);
		ListNode test2 = new ListNode(4);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(2);
		ListNode test5 = new ListNode(1);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		System.out.println(new NoOfElementsInLinkedList().getCount(test1));
		
	}
}
