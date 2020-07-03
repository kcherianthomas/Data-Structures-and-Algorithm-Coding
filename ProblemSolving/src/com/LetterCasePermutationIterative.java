package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCasePermutationIterative {
	public List<String> letterCombinations(String digits) {
		List<String> outputList = new ArrayList<>();
		if (digits.length() == 0) {
			return outputList;
		}
		Map<String, String[]> telMap = new HashMap<>();
		telMap.put("2", new String[] { "a", "b", "c" });
		telMap.put("3", new String[] { "d", "e", "f" });
		telMap.put("4", new String[] { "g", "h", "i" });
		telMap.put("5", new String[] { "j", "k", "l" });
		telMap.put("6", new String[] { "m", "n", "o" });
		telMap.put("7", new String[] { "p", "q", "r", "s" });
		telMap.put("8", new String[] { "t", "u", "v" });
		telMap.put("9", new String[] { "w", "x", "y", "z" });
		return letterPerm(digits, outputList,  telMap);
	}

	private List letterPerm(String digits, List<String> outputList, Map<String, String[]> telMap) {
		int index = 0;
		outputList.add("");
		while (digits.length() >index) {
			List<String> tempList = new ArrayList<>();
			for (String out : outputList) {
				for (int i = 0; i < telMap.get(String.valueOf(digits.charAt(index))).length; ++i) {
					tempList.add(out+telMap.get(String.valueOf(digits.charAt(index)))[i]);
				}
			}
			outputList = new ArrayList<>();
			outputList.addAll(tempList);
			++index;
		}
		return outputList;
	}
	public static void main(String[] args) {
		LetterCasePermutationIterative a = new LetterCasePermutationIterative();
		a.letterCombinations("23");
	}
}
