package com;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t , write a function to 
 * determine if t is an anagram of s.
 * We assume only lower case letters
 */
public class AnagramChecker {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		//We initialize a count array with all values as zero
		int[] countChar = new int[26];
		for (int i = 0; i < 26; ++i) {
			countChar[i] = 0;

		}
		/*
		 * We increment count of the character when found in 
		 * the first string and decrement count when found in second
		 * Finally, we check if the count of all elements in
		 * count array is 0 to verify anagram
		 */
		for (int i = 0; i < s.length(); ++i) {
			countChar[sChar[i] - 'a'] += 1;
			countChar[tChar[i] - 'a'] -= 1;
		}
		for (int i = 0; i < 26; ++i) {
			if (countChar[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
