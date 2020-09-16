package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
	/*
	 * I am assuming that -100 is a value that never occurs as a value
	 */
	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {

			ArrayList<Integer> out = serializeUsingPreorder(root, new ArrayList<Integer>());
			StringBuilder bld = new StringBuilder();
			for (Integer temp : out) {
				bld.append(temp);
				bld.append(",");
			}
			return bld.toString();
		}

		private ArrayList<Integer> serializeUsingPreorder(TreeNode root, ArrayList<Integer> out) {
			if (root == null) {
				out.add(-100);
				return out;
			}
			out.add(root.val);
			out = serializeUsingPreorder(root.left, out);
			return serializeUsingPreorder(root.right, out);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] nodeVal = data.split(",");
			Queue<Integer> q = new LinkedList<>();
			for (String temp : nodeVal) {
				q.add(Integer.parseInt(temp));
			}
			return buildTree(q);
		}

		private TreeNode buildTree(Queue<Integer> q) {
			TreeNode root = null;
			if (q.isEmpty()) {
				return null;
			}
			if (q.peek() == -100) {
				q.poll();
				return null;
			}
			root = new TreeNode(q.poll());
			root.left = buildTree(q);
			root.right = buildTree(q);
			return root;
		}
	}
}
