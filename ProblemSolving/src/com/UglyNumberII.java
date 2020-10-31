package com;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		if (n == 1) {
			return 1;
		}
		Queue<Double> queue = new PriorityQueue<>();
		Set<Double> unique = new HashSet<>();
		queue.add(1.0);
		unique.add(1.0);
		for (int i = 1; i < n; ++i) {
			Double curVal = queue.poll();
			System.out.println(curVal);
			if (!unique.contains(curVal * 2)) {
				queue.add(curVal * 2);
				unique.add(curVal * 2);
			}
			if (!unique.contains(curVal * 3)) {
				queue.add(curVal * 3);
				unique.add(curVal * 3);
			}
			if (!unique.contains(curVal * 5)) {
				queue.add(curVal * 5);
				unique.add(curVal * 5);
			}
		}
		double d= queue.poll() ; 
		return (int) d;
	}
}
