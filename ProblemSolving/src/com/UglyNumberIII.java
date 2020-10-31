package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UglyNumberIII {
	public int nthUglyNumber(int n, int a, int b, int c) {
		int i = 1;
		int j = 1;
		int k = 1;
		Set<Double> unique = new HashSet<>();
		List<Double> list = new ArrayList<>();
		int count = 0;
		while (count < n) {
			if ((a * i <= b * j) && (a * i <= c * k)) {
				if (!unique.contains((double)a * i)) {
					unique.add((double)a * i);
					count++;
					list.add((double)a * i);
				}
				i++;
			} else if ((b * j <= a * i) && (b * j <= c * k)) {
				if (!unique.contains((double)b * j)) {
					unique.add((double)b * j);
					count++;
					list.add((double)b * j);
				}
				j++;
			} else if ((c * k <= a * i) && (c * k <= b * j)) {
				if (!unique.contains((double)c * k)) {
					unique.add((double)c * k);
					count++;
					list.add((double)c * k);
				}
				k++;
			}
		}
		double out =  list.get(list.size()-1);
		return (int)out;
	}
}
