package com;

import java.util.HashSet;
import java.util.Set;
// Find the node at which the intersection of two singly linked lists begins
public class IntersectionOfTwoLinkedList {
	/* Using a set to store nodes of one list
	 * Now start from head of second linkedlist 
	 * if the node is already available its the intersectionNode
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		if(null==headA || null==headB) {
			return null;
		}
		while(headA!=null) {
			set.add(headA);
			headA=headA.next;
		}
		while(headB!=null) {
			if(set.contains(headB)) {
				return headB;
			} 
			headB=headB.next;
		}
		return null;
	}
}
