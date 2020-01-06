package com;

import java.util.HashMap;
import java.util.Map;
/*
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
 */
public class FirstUniqueCharacterInAString {
	/*
	 * Uses the hashmap to save frequency and
	 * Iterate again to find first unique
	 */
	public int firstUniqChar(String s) {
		if(null==s || s.equals("")) {
			return -1;
		}
		Map<Character,Integer> m = new HashMap<>();
		for(int i=0;i<s.length();++i) {
		if(!m.containsKey(s.charAt(i))) {
		m.put(s.charAt(i), 1);
		} else {
			m.put(s.charAt(i), m.get(s.charAt(i))+1);
		}
		}
		for(int i=0;i<s.length();++i) {
			if(m.get(s.charAt(i))==1) {
				return i;
			}
		}
		return -1;
	}
}
