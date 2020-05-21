package com;

public class TestingTrieWorking {

	public static void main(String[] args) {
		String[] s = new String[] { "CATWOMAN", "CABA", "CALL", "CA" };
		Trie t = new Trie();
		Trie head = t;
		for (int i = 0; i < s.length; ++i) {
			char[] cur = s[i].toCharArray();
			t=head;
			for (int j = 0; j < cur.length; ++j) {
				if(!t.node.containsKey(cur[j])) {
					Trie child = new Trie();
				t.node.put(cur[j],child);
				}
				t=t.node.get(cur[j]);
			}
			t.isComplete=true;
		}
		int count =0;
		t=head;
		String ans="";
		while(t.node.size()==1 &&!t.isComplete) {
			ans+=s[0].charAt(count);
			t=t.node.get(s[0].charAt(count++));
		}
		System.out.println(s[0].substring(0, count));
		 
	}

}
