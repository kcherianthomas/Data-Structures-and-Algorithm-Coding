package com;

public class CopyListWithRandomPointer {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node org = head;
		while (org != null) {
			Node dup = new Node(org.val);
			Node next = org.next;
			org.next = dup;
			dup.next = next;
			org = next;
		}
		org = head;
		Node dup = org.next;
		while (org != null) {
			if (org.random != null) {
				dup.random = org.random.next;
			}

			org = org.next.next;
			if (dup.next != null) {
				dup = dup.next.next;
			}
		}
		org = head;
		dup = org.next;
		Node dupHead = dup;
		while (org != null) {
			org.next = org.next.next;
			if (dup.next != null) {
				dup.next = dup.next.next;
			}
			org = org.next;
			dup = dup.next;
		}
		return dupHead;
	}
}
