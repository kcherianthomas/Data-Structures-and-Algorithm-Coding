package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> outputList = new ArrayList<>();
		if (digits.length() == 0) {
			return outputList;
		}
		String str = "";
		Map<String, String[]> telMap = new HashMap<>();
		telMap.put("2", new String[] { "a", "b", "c" });
		telMap.put("3", new String[] { "d", "e", "f" });
		telMap.put("4", new String[] { "g", "h", "i" });
		telMap.put("5", new String[] { "j", "k", "l" });
		telMap.put("6", new String[] { "m", "n", "o" });
		telMap.put("7", new String[] { "p", "q", "r", "s" });
		telMap.put("8", new String[] { "t", "u", "v" });
		telMap.put("9", new String[] { "w", "x", "y", "z" });
		letterPerm(digits, outputList, str, telMap, 0);
		return outputList;
	}

	private void letterPerm(String digits, List<String> outputList, String str, Map<String, String[]> telMap,
			int index) {
		if (str.length() == digits.length()) {
			outputList.add(str);
		} else {
			for (int i = 0; i < telMap.get(String.valueOf(digits.charAt(index))).length; ++i) {
				str += telMap.get(String.valueOf(digits.charAt(index)))[i];
				letterPerm(digits, outputList, str, telMap, index + 1);
				str = str.substring(0, str.length() - 1);
			}
		}

	}
}
