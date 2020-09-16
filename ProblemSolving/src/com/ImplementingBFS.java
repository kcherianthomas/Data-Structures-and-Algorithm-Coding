package com;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementingBFS {

	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdgeDirected(0, 1);
		g.addEdgeDirected(1, 2);
		g.addEdgeDirected(1, 3);
		g.addEdgeDirected(4, 5);
		g.addEdgeDirected(5, 6);
		g.addEdgeDirected(5, 3);
		bfs(4, g);
	}

	private static void bfs(int edge, Graph g) {
		boolean[] seen = new boolean[g.getVertex()];
		Queue<Integer> q = new LinkedList<>();
		q.add(edge);
		System.out.println(edge);
		seen[edge] = true;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (Integer v : g.getAdjL().get(u)) {
				if (!seen[v]) {
					q.add(v);
					System.out.println(v);
					seen[v] = true;
				}
			}
		}

	}
}
