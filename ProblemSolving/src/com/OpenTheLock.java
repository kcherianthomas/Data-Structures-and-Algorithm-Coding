package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
		HashSet<String> visited = new HashSet<>();
		for (String deadend : deadends) {
			visited.add(deadend);
		}
		// base condition
        if(visited.contains("0000")) {
            return -1;
        }
		int curDepth = -1;
		Queue<String> q = new LinkedList<>();
		q.add("0000");
		visited.add("0000");

		while (!q.isEmpty()) {
			int count = q.size();
			curDepth = curDepth + 1;
			for (int i = 0; i < count; ++i) {
				String cur = q.poll();
				if (cur.equals(target)) {
					return curDepth;
				}
				for (String neighbour : findNeighbour(cur)) {
					if (!visited.contains(neighbour)) {
						q.add(neighbour);
						visited.add(neighbour);
					}
				}

			}

		}
		return -1;
	}

	private List<String> findNeighbour(String cur) {
		List<String> neighbours = new ArrayList<>();
		char[] ch = cur.toCharArray();
		for (int i = 0; i < 4; ++i) {
			char[] temp1 = Arrays.copyOf(ch, ch.length);
			char[] temp2 = Arrays.copyOf(ch, ch.length);
			temp1[i] = (char) ((((temp1[i] - '0') + 1) % 10) + '0');
			temp2[i] = (char) ((((temp2[i] - '0') + 9) % 10) + '0');
			neighbours.add(String.valueOf(temp1));
			neighbours.add(String.valueOf(temp2));
		}
		return neighbours;
	}

	public static void main(String args[]) {
		OpenTheLock obj = new OpenTheLock();
		for (String neighbour : obj.findNeighbour("9999")) {
			System.out.println(neighbour);
		}
	}
}
