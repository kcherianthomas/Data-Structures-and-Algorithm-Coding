package com;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}

		public Node(int _val) {
			val = _val;
		}

		public Node connect(Node root) {
			if (root == null) {
				return root;
			}
			Node pointer = root;
			Queue<Node> q = new LinkedList<>();
			q.add(pointer);
			q.add(null);
			while (!q.isEmpty()) {
				if (pointer != null) {
					if (pointer.left != null) {
						q.add(pointer.left);
					}
					if (pointer.right != null) {
						q.add(pointer.right);
					}
				} else {
					q.add(null);
				}
				Node temp = q.poll();
				if(pointer!=null) {
				pointer.next= temp;
				}
				pointer = temp;
			}
			return root;
		}
	}
}
