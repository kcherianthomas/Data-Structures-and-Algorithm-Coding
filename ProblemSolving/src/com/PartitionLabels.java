package com;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {

		int[] map = new int[26];
		List<Integer> out = new ArrayList<>();
		for (int i = 0; i < S.length(); ++i) {
			map[S.charAt(i) - 'a'] = i;
		}
		int i = 0;
		int end = 0;
		int count = 0;
		while (i < S.length()) {
			count++;
			end = Math.max(end, map[S.charAt(i) - 'a']);
			if (i == end) {
				out.add(count);
				count = 0;
			}
			i++;
			System.out.println();
		}
		return out;
	}
}
