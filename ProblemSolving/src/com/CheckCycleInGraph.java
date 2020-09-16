package com;

public class CheckCycleInGraph {

	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdgeDirected(0, 1);
		g.addEdgeDirected(1, 2);
		g.addEdgeDirected(1, 3);
		g.addEdgeDirected(4, 5);
		g.addEdgeDirected(5, 6);
		g.addEdgeDirected(5, 3);
		CheckCycleDfsRecursive(g);

	}

	private static boolean CheckCycleDfsRecursive(Graph g) {
		boolean[] seen = new boolean[g.getVertex() + 1];
		boolean[] ancestor = new boolean[g.getVertex() + 1];
		for (int i = 0; i < seen.length; ++i) {
			seen[i] = false;
			ancestor[i] = false;
		}
		for (int i = 0; i < seen.length; ++i) {
			if (!seen[i] && CheckCycleDfsRecursiveUtil(g, seen, ancestor, i)) {
				return true;
			}
		}
		return false;
	}

	private static boolean CheckCycleDfsRecursiveUtil(Graph g, boolean[] seen, boolean[] ancestor, int u) {
		if(ancestor[u]) {
			return true;
		}
		
		if(seen[u]) {
			return false;
		}
		seen[u] = true;
		ancestor[u] = true;
		for (Integer v : g.getAdjL().get(u)) {
			if (CheckCycleDfsRecursiveUtil(g, seen, ancestor, v)) {
				return true;
			}
		}

		ancestor[u] = false;
		return false;
	}
}
