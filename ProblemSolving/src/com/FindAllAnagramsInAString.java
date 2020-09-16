package com;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> out = new ArrayList<>();
		if (s.isEmpty() || s.length() < p.length()) {
			return out;
		}
		int[] freq = new int[256];
		for (int i = 0; i < 256; ++i) {
			freq[i] = 0;
		}
		for (int i = 0; i < p.length(); ++i) {
			freq[p.charAt(i)] += 1;
		}
		int left = 0;
		int right = 0;
		int count = 0;
		while (right < s.length()) {
			int val = s.charAt(right);
			if (freq[val] > 0) {
				count++;
			}
			freq[val] = freq[val] - 1;
			if (count == p.length()) {
				out.add(left);
			}
			if (right - left == p.length() - 1) {
				if (freq[s.charAt(left)] >= 0) {
					count--;
				}
				freq[s.charAt(left)] += 1;
				left++;
			}
			right++;
		}
		return out;
	}
}
