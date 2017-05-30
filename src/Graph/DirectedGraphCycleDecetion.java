package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphCycleDecetion {
	LinkedList<Integer> adj[];
	boolean[] marked;
	boolean[] onStack;
	int[] degree;
	public int V;
	int[] incomingEdge;
	int edgeCount;

	public static void main(String[] args) {
		DirectedGraphCycleDecetion d = new DirectedGraphCycleDecetion(4);
		d.addEdge3(0, 1);
		d.addEdge3(0, 2);
		d.addEdge3(1, 2);
		d.addEdge3(2, 0);
		d.addEdge3(2, 3);
		d.addEdge3(3, 3);
		System.out.println(d.isCycle3());
	}

	public DirectedGraphCycleDecetion(int V) {
		this.V = V;
		adj = new LinkedList[V];
		marked = new boolean[V];
		onStack = new boolean[V];
		degree = new int[V];
		incomingEdge = new int[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void addEdge3(int v, int w) {
		adj[v].add(w);
		edgeCount++;
		incomingEdge[w]++;
	}

	public boolean isCycle() {
		for (int i = 0; i < V; i++) {
			if (!marked[i]) {
				if (dfs(i)) {
					return true;
				}
			}
		}
		return false;
	}

	// kahn

	public boolean isCycle2() {
		computeIndegree();
		System.out.println(degree.length);
		for (int i = 0; i < V; i++) {
			boolean isFind = false;
			int findIndex = 0;
			for (int j = 0; j < V; j++) {
				if (degree[j] == 1) {
					isFind = true;
					findIndex = j;
					break;
				}
			}
			if (!isFind) {
				return true;
			} else {
				degree[findIndex] = -1;
				for (int j = 0; j < adj[findIndex].size(); j++) {
					degree[adj[findIndex].get(j)]--;
				}
			}
		}
		return false;
	}

	public void computeIndegree() {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				degree[adj[i].get(j)]++;
			}
		}
	}

	public boolean dfs(int i) {
		onStack[i] = true;
		marked[i] = true;
		System.out.println(adj[i]);
		for (int j = 0; j < adj[i].size(); j++) {
			System.out.println(i + " " + adj[i].get(j));
			if (!marked[adj[i].get(j)]) {
				if (dfs(adj[i].get(j))) {
					return true;
				}
			} else if (onStack[adj[i].get(j)]) {
				return true;
			}
		}
		onStack[i] = false;
		return false;
	}

	// better kahn
	public boolean isCycle3() {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < V; i++) {
			if (incomingEdge[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < adj[cur].size(); i++) {
				edgeCount--;
				incomingEdge[adj[cur].get(i)]--;
				if (incomingEdge[adj[cur].get(i)] == 0) {
					q.add(incomingEdge[adj[cur].get(i)]);
				}
			}
		}
		return edgeCount > 0;
	}
}
