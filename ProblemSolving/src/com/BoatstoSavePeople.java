package com;

import java.util.Arrays;

public class BoatstoSavePeople {
	public int numRescueBoats(int[] people, int limit) {
		if (people.length == 0) {
			return 0;
		} else if (people.length == 1) {
			return 1;
		}
		Arrays.sort(people);
		int count = 0;
		int first = 0;
		int last = people.length - 1;
		while (first < last) {
			if (people[first] + people[last] <= limit) {
				count++;
				first++;
				last--;
			} else {
				last--;
			}
		}
		return count + (people.length - count * 2);
	}
}
