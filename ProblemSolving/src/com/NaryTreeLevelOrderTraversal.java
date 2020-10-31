package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> out = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		if (root != null) {
			q.add(root);
		}
		while (!q.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int count = q.size();
			for (int i = 0; i < count; ++i) {
				Node cur = q.poll();
				list.add(cur.val);
				for (Node child : cur.children) {
					q.add(child);
				}

			}
			out.add(list);
		}
		return out;

	}
}
