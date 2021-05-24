package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule2 {
	int time = 0;
	HashMap<Integer, Integer> startTime;
	HashMap<Integer, Integer> endTime;
	List<List<Integer>> graph;
	String[] color;
	LinkedList<Integer> out;
	boolean hasCycle = false;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		time = 0;
		startTime = new HashMap<>();
		endTime = new HashMap<>();
		graph = new ArrayList<>();

		for (int i = 0; i < numCourses; ++i) {
			graph.add(new ArrayList<>());
		}
		for (int[] prereq : prerequisites) {
			graph.get(prereq[1]).add(prereq[0]);
		}
		color = new String[numCourses];
		for (int i = 0; i < numCourses; ++i) {
			color[i] = "white";
		}
		out = new LinkedList<>();
		for (int i = 0; i < numCourses; ++i) {
			if (color[i].equals("white") && !hasCycle) {
				dfs(i);
			}
		}
		int[] outArray = new int[out.size()];
		for (int i = 0; i < outArray.length; ++i) {
			outArray[i] = out.get(i);
		}
		return hasCycle ? new int[] {} : outArray;
	}

	private void dfs(int i) {
		if (color[i].equals("grey")) {
			hasCycle = true;
			return;
		}
		if (color[i].equals("black")) {
			return;
		}
		color[i] = "grey";
		time++;
		for (Integer neighbour : graph.get(i)) {
			dfs(neighbour);
		}
		time++;
		out.addFirst(i);
		color[i] = "black";
	}
}
