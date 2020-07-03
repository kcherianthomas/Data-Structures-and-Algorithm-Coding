package com;

import java.util.ArrayList;

/*
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123","132","213","231","312","321"
 * Given n and k, return the kth permutation sequence.
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {

		ArrayList<String> list = new ArrayList();

		// we add all numbers from 1 to n in list
		for (int i = 1; i <= n; ++i) {
			list.add(Integer.toString(i));
		}

		// the k-- is done to match indexing in arraylist
		k--;

		int fac = 1;
		// we find the factorial factorial
		for (int i = 1; i <= n; ++i) {
			fac = fac * i;
		}

		// Initial String
		String output = "";
		for (int i = 0; i < n; ++i) {
			fac = fac / (n - i);
			int index = k / fac;
			k = k % fac;
			output += list.get(index);
			list.remove(index);
		}

		return output;

	}
}
