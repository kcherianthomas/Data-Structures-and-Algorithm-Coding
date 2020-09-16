package com;

/*
 * This can be used as a comparator when you want to sort many versions in order
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] firstVersion = version1.split("\\.");
		String[] secondVersion = version2.split("\\.");
		int length = Math.max(version1.length(), version2.length());
		for (int i = 0; i < length; ++i) {
			int val1 = i < firstVersion.length ? Integer.parseInt(firstVersion[i]) : 0;
			int val2 = i < secondVersion.length ? Integer.parseInt(secondVersion[i]) : 0;
			if (val1 > val2) {
				return 1;
			} else if (val1 < val2) {
				return -1;
			}
		}
		return 0;
	}
}
