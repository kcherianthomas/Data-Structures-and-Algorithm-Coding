package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> output = new ArrayList<>();
		Map<String, List<String>> anagramMap = new HashMap<>();
		findAnagramForEachString(anagramMap, strs);
		for(List<String> val:anagramMap.values()) {
			output.add(val);
		}
		return output;
	}

	private void findAnagramForEachString(Map<String, List<String>> anagramMap, String[] strs) {
		for (String str : strs) {
			int[] countArray = new int[26];
			for (int i = 0; i < 26; ++i) {
				countArray[i] = 0;
			}
			for (int i = 0; i < str.length(); ++i) {
				countArray[str.charAt(i) - 'a'] += 1;
			}
			StringBuilder bld = new StringBuilder();
			for (int i = 0; i < 26; ++i) {
				bld.append("#");
				bld.append(countArray[i]);
			}
			if (anagramMap.containsKey(bld.toString())) {
				anagramMap.get(bld.toString()).add(str);
			} else {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(str);
				anagramMap.put(bld.toString(), temp);
			}
		}
	}
}
