package com;

import java.util.ArrayList;
import java.util.List;

public class ImplementingGraphUsingListOfArrayList {
	public static void main() {
		int vertex = 5;
		List<List<Integer>> graph = createGraph(vertex);
		addEdgeUndirected(graph,0,1);
	}

	private static void addEdgeUndirected(List<List<Integer>> graph, int i, int j) {
		graph.get(i).add(j);
		graph.get(j).add(i);
		
	}

	public static List<List<Integer>> createGraph(int vertex) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < vertex; ++i) {
			graph.add(new ArrayList<>());
		}
		return graph;
	}
}
