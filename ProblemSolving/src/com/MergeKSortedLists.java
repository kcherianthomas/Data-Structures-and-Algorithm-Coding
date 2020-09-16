package com;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (null == lists || lists.length == 0) {
			return null;
		}
		ListNode head = new ListNode(-20);
		ListNode node = head;
		PriorityQueue<ListNode> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
		for (ListNode list : lists) {
			if (list != null) {
				q.add(list);
			}
		}
		while (!q.isEmpty()) {
			ListNode minVal = q.poll();
			ListNode val = new ListNode(minVal.val);
			node.next = val;
			node = node.next;
			minVal = minVal.next;
			if (minVal != null) {
				q.add(minVal);
			}
		}
		return head.next;
	}
}
