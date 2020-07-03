package com;

public class VersionControl {
	public int firstBadVersion(int n) {
		int low = 1;
		int high = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	//Method available in leetcode
	private boolean isBadVersion(int mid) {
		System.out.println("S".substring(0, 1));
		return false;
	}
	
}
