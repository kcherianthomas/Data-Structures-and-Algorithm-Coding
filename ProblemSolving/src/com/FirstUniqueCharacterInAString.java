package com;

/*
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
 */
public class FirstUniqueCharacterInAString {
	/*
	 * Slightly modified the previous approach to use
	 * an array[26] instead of hashmap as its told
	 * the string contains only lowercase letters
	 */
	public int firstUniqChar(String s) {
		if(null==s || s.equals("")) {
			return -1;
		}
		int [] arr = new int[26];
		for(int i=0;i<26;++i) {
			arr[i]=0;
		}
		for(int i=0;i<s.length();++i) {
			arr[s.charAt(i)-'a'] = arr[s.charAt(i)-'a']+1;
		}
		for(int i=0;i<s.length();++i) {
			if(arr[s.charAt(i)-'a']==1) {
				return i;
			}
		}
		return -1;
	}
}
