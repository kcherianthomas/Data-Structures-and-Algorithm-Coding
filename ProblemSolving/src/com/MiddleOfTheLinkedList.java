package com;

/* Given a non-empty, singly linked list with head node head,
 * return a middle node of linked list.If there are two middle nodes,
 * return the second middle node.
*/
public class MiddleOfTheLinkedList {
	//Using the slow and fast pointer to find middle element
	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (null != fast && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
