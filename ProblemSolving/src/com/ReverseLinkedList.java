package com;
/*
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
	/*
	 * The time complexity would be O(sizeOfLinkedList)
	 */
	public ListNode reverseList(ListNode head) {
		if (head==null) {
            return null;
        }
		ListNode newList = new ListNode(head.val);
		while(null!=head.next) {
			head=head.next;
			int value = head.val;
			ListNode tempList = new ListNode(value);
			tempList.next = newList;
			newList=tempList;
		}
		return newList;
	}
}


