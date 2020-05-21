package com;
/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefixUsingTrie {
	/* It was my first time trying to implement trie. This is definitely
	 * not the way to find longest common subsequence
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		Trie t = new Trie();
		Trie head = t;
		for (int i = 0; i < strs.length; ++i) {
			char[] cur = strs[i].toCharArray();
			t = head;
			for (int j = 0; j < cur.length; ++j) {
				if (!t.node.containsKey(cur[j])) {
					Trie child = new Trie();
					t.node.put(cur[j], child);
				}
				t = t.node.get(cur[j]);
			}
			t.isComplete = true;
		}
		int count = 0;
		t = head;
		while (t.node.size() == 1 && !t.isComplete) {
			t = t.node.get(strs[0].charAt(count++));
		}
		return strs[0].substring(0, count);
	}
}
