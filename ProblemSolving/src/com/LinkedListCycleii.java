package com;

public class LinkedListCycleii {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast==slow) {
                break;
            }
		}
		// no cycle
		if (fast == null) {
			return null;
		}
		// the distance from head to start of cycle will be equal to distance from
		// intersection of slow and fast to start of cycle
		slow = head;
		
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
}
