package com;

public class InsertIntoASortedCircularLinkedList {
	class Node {
		public int val;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _next) {
			val = _val;
			next = _next;
		}
	}

	public Node insert(Node head, int insertVal) {
		Node nodeToInsert = new Node(insertVal);
		// No value
		if (head == null) {
			head = nodeToInsert;
			head.next = head;
			return head;
		}
		Node prev = head;
		Node cur = head.next;

		do {
			// case 1 when insert val between a range
			if (prev.val <= insertVal && cur.val >= insertVal) {
				prev.next = nodeToInsert;
				nodeToInsert.next = cur;
				return head;
			}
			// case2
			if (prev.val > cur.val) {
				// insert val less than or greater than existing range
				if (insertVal < cur.val || insertVal > prev.val) {
					prev.next = nodeToInsert;
					nodeToInsert.next = cur;
					return head;
				}
			}
			prev = prev.next;
			cur = cur.next;
		} while (prev != head);
		// case 3 when all exisitng values are same
		prev.next = nodeToInsert;
		nodeToInsert.next = cur;
		return head;
	}
}
