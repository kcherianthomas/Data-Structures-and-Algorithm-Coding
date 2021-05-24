package com;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	String[] color;
	ArrayList<List<Integer>> graph;
/*
 * We just need to check if course contains cycle
 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// check cycle in directed graph
		// use dfs
		graph = new ArrayList<>();
		for (int i = 0; i < numCourses; ++i) {
			graph.add(new ArrayList<>());
		}
		for (int[] preReq : prerequisites) {
			graph.get(preReq[1]).add(preReq[0]);
		}
		color = new String[numCourses];
		for (int i = 0; i < color.length; ++i) {
			color[i] ="white";
		}
		for (int i = 0; i < numCourses; ++i) {
			if (color[i].equals("white")) {
				if (!dfs(i)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean dfs(int i) {
		// back edge cycle
		if (color[i].equals("grey")) {
			return false;
		}
		if (color[i].equals("black")) {
			return true;
		}
		color[i] = "grey";
		for (Integer neighbour : graph.get(i)) {
			if (!dfs(neighbour)) {
				return false;
			}
		}
		color[i] = "black";
		return true;
	}
}
