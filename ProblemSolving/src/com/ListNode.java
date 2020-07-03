package com;

public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;

	}

	@Override
	public String toString() {
		ListNode temp = this;
		StringBuilder bld = new StringBuilder();
		while(temp!=null) {
			bld.append(temp.val);
			bld.append(" ");
			temp=temp.next;
		}
		return bld.toString();
	}
	
}
