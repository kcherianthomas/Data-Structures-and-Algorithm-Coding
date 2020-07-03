package com;

public class SplitLinkedListInParts {
	public ListNode[] splitListToParts(ListNode root, int k) {

		if (k == 0) {
			return new ListNode[] { root };
		}
		ListNode[] output = new ListNode[k];
		// Get count of no of elemets in linkedList
		int count = getCount(root);
		int noOfElements = count / k;
		int noOfAdditionalElements = count % k;
		ListNode node = root;
		for (int i = 0; i < output.length; ++i) {
			//If a node is null we can fill rest all outputs with null
			if (node == null) {
				output[i] = node;
			} else {
				output[i] = node;
				int totalSkipping = 0;
				totalSkipping = noOfElements - 1;
				if (noOfAdditionalElements - (i) > 0) {
					totalSkipping++;
				}
				while (totalSkipping != 0) {
					node = node.next;
					totalSkipping--;
				}

				ListNode temp = node.next;
				node.next = null;
				node = temp;
			}
		}

		return output;
	}

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
}
