package Graph;

import java.util.LinkedList;

public class UndirectedGraphCycleDetection {
	LinkedList<Integer> adj[];
	private int V;
	private boolean[] marked;

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		UndirectedGraphCycleDetection g1 = new UndirectedGraphCycleDetection(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCycle())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		UndirectedGraphCycleDetection g2 = new UndirectedGraphCycleDetection(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCycle())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}

	public UndirectedGraphCycleDetection(int v) {
		this.V = v;
		marked = new boolean[V];
		adj = new LinkedList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public boolean isCycle() {
		for (int i = 0; i < V; i++) {
			if (!marked[i]) {
				if (dfs(i, -1)) {
					System.out.println(dfs(i,-1)+" "+ i);
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(int i, int parent) {
		marked[i] = true;
		for (int j = 0; j < adj[i].size(); j++) {
			if (!marked[adj[i].get(j)]) {
				if(dfs(adj[i].get(j),i)){
					return true;
				}
			} else if (adj[i].get(j) != parent) {
				return true;
			}
		}
		return false;
	}

}
