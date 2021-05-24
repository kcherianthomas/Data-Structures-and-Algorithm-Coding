package com;

public class DuplicateZeroes {
	public void duplicateZeros(int[] arr) {
		int zeroes = 0;
		int i = 0;
		for (i = 0; i < arr.length - zeroes; ++i) {
			if (arr[i] == 0) {
				// edge case
				if (i == arr.length - zeroes - 1) {
					arr[i + zeroes] = 0;
					// i=i-1;
					break;
				} else {
					zeroes++;
				}
			}
		}
		i = i - 1;
		for (; i >= 0; --i) {
			if (arr[i] == 0) {
				arr[i + zeroes] = 0;
				zeroes--;
				arr[i + zeroes] = 0;
			} else {
				arr[i + zeroes] = arr[i];
			}
		}
	}
}
