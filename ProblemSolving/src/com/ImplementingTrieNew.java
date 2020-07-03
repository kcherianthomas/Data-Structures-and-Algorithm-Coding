package com;

import java.util.HashMap;
import java.util.Map;

// I enclosed in a new class because i already had a trie class
public class ImplementingTrieNew {
	class Trie {
		Map<Character, Trie> node = null;
		boolean isComplete = false;

		/** Initialize your data structure here. */
		public Trie() {
			node = new HashMap();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			if (null != word) {
				char[] charArray = word.toCharArray();
				int i=0;
				Trie t = this;
				while(i<charArray.length) {
					if (!t.node.containsKey(charArray[i])) {
						t.node.put(charArray[i],new Trie());
					}
					t = t.node.get(charArray[i]);
					i++;
					}
				t.isComplete=true;
			}
		}


		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			char[] charArray = word.toCharArray();
			int i=0;
			Trie t = this;
			while(i<charArray.length) {
				if (!t.node.containsKey(charArray[i])) {
					return false;
				}
				t = t.node.get(charArray[i]);
				i++;
				}
			return t.isComplete;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {

			char[] charArray = prefix.toCharArray();
			int i=0;
			Trie t = this;
			while(i<charArray.length) {
				if (!t.node.containsKey(charArray[i])) {
					return false;
				}
				t = t.node.get(charArray[i]);
				i++;
				}
			return true;
		
		}

		
	}

}
