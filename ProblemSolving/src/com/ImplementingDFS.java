package com;

import java.util.Stack;

public class ImplementingDFS {
	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdgeDirected(0, 1);
		g.addEdgeDirected(1, 2);
		g.addEdgeDirected(1, 3);
		g.addEdgeDirected(4, 5);
		g.addEdgeDirected(5, 6);
		g.addEdgeDirected(5, 3);
		dfs(g);
		dfsRecursive(g);
	
	}

	

	private static void dfsRecursive(Graph g) {
		boolean[] seen = new boolean[g.getVertex()];
		for (int i = 0; i < seen.length; ++i) {
			seen[i] = false;
		}
		for (int i = 0; i < g.getVertex(); ++i) {
			// first vertex added
			if (!seen[i]) {
				dfsUtil(seen, g, i);
			}
		}
	}

	private static void dfsUtil(boolean[] seen, Graph g, int u) {
		seen[u] = true;
		System.out.println(u);
		for(int v : g.getAdjL().get(u)) {
			if (!seen[v]) {
			dfsUtil(seen, g, v);
			}
		}

	}

	private static void dfs(Graph g) {
		Stack<Integer> s = new Stack<>();
		boolean[] seen = new boolean[g.getVertex()];
		for (int i = 0; i < seen.length; ++i) {
			seen[i] = false;
		}
		// The for loop is used to make sure all nodes are visited
		for (int i = 0; i < g.getVertex(); ++i) {
			// first vertex added
			if (!seen[i]) {
				s.add(i);
			}
			while (!s.isEmpty()) {
				// we take top element from stack
				int popped = s.pop();
				if (!seen[popped]) {
					seen[popped] = true;
					System.out.println(popped);
					// all edges from a vertex are added
					for (Integer temp : g.getAdjL().get(popped)) {
						if (!seen[temp]) {
							s.add(popped);
							s.add(temp);
						}
					}
				}
			}
		}
	}
}
