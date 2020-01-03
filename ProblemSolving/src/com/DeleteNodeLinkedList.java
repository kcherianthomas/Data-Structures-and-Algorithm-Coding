package com;
/*
 * Function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 */
public class DeleteNodeLinkedList {
	public void deleteNode(ListNode node) {node.val=node.next.val;
    node.next=node.next.next;
    }
}
