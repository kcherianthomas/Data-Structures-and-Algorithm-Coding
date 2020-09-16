package com;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int vertex;
	private List<List<Integer>> adjL = new ArrayList<>();

	public Graph(int vertex) {
		this.vertex = vertex;
		for (int i = 0; i < this.vertex; ++i) {
			adjL.add(new ArrayList<>());
		}
	}

	public void addEdgeUndirected(int u, int v) {
		adjL.get(u).add(v);
		adjL.get(v).add(u);
	}

	public void addEdgeDirected(int u, int v) {
		adjL.get(u).add(v);
	}

	public int getVertex() {
		return vertex;
	}

	public List<List<Integer>> getAdjL() {
		return adjL;
	}

}
