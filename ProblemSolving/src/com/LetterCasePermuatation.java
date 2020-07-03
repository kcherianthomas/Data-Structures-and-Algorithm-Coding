package com;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermuatation {
	public List<String> letterCasePermutation(String S) {
		List<String> output = new ArrayList<>();
		int l = 0;
		int r = S.length();
		permute(output, S, l, r);
		System.out.println(output);
		return output;
	}

	private void permute(List<String> output, String S, int l, int r) {
		output.add(S);
		for (int i = l; i < r; ++i) {
			if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
				S = convertCase(S, i);
				permute(output, S, i+1, r);
				S = convertCase(S, i);
			}
		}
	}

	private String convertCase(String S, int i) {
		if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
			char[] array = S.toCharArray();
			array[i] = Character.toUpperCase(array[i]);
			S = "";
			for (int j = 0; j < array.length; ++j) {
				S += array[j];
			}

		} else {
			char[] array = S.toCharArray();
			array[i] = Character.toLowerCase(array[i]);
			S = "";
			for (int j = 0; j < array.length; ++j) {
				S += array[j];
			}
		}
		return S;
	}

	public static void main(String[] args) {
		LetterCasePermuatation a = new LetterCasePermuatation();
		a.letterCasePermutation("a1B2");
	}
}
