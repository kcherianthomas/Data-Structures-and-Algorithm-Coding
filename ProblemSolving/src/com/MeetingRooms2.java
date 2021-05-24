package com;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int max = 0;
		for(int [] interval : intervals) {
			while(!pq.isEmpty() && pq.peek()<=interval[0]) {
				pq.poll();
			}
			pq.add(interval[1]);
			max = Math.max(max, pq.size());
		}
		return max;
	}
}
