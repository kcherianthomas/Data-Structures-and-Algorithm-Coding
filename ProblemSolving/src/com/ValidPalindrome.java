package com;
/*Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 */
public class ValidPalindrome {
	/* The idea is to keep checking the element from start which is alphanumeric
	 * with element at end which is alphanumeric until start>end
	 */
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			//To lower because question asks to ignore case
			char charStart = Character.toLowerCase(s.charAt(start));
			char charEnd = Character.toLowerCase(s.charAt(end));
			if (!Character.isLetterOrDigit(charStart)) {
				++start;
				continue;
			}
			if (!Character.isLetterOrDigit(charEnd)) {
				--end;
				continue;
			}
			if (charStart!= charEnd) {
				return false;

			}
			++start;
			--end;
		}
		return true;

	}

	
}