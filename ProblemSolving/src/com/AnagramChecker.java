package com;

import java.util.HashMap;
import java.util.Map;
/*
 * Given two strings s and t , write a function to 
 * determine if t is an anagram of s.
 */
public class AnagramChecker {
	/*
	 * This code is quite slow. New code in future
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char [] sChar = s.toCharArray();
		char [] tChar = t.toCharArray();
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < sChar.length; ++i) {
			if (map1.containsKey(sChar[i])) {
				map1.put(sChar[i], map1.get(sChar[i]) + 1);
			} else {
				map1.put(sChar[i], 1);
			}

			if (map2.containsKey(tChar[i])) {
				map2.put(tChar[i], map2.get(tChar[i]) + 1);
			} else {
				map2.put(tChar[i], 1);
			}
		}
		for (int i = 0; i < s.length(); ++i) {
			if (null==map1.get(sChar[i]) || null==map2.get(sChar[i]) || (map1.get(sChar[i]).intValue() != map2.get(sChar[i]).intValue())) {
				return false;
			}
		}
		return true;
	}
}
