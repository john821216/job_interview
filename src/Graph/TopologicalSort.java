package Graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
	LinkedList<Pair>[] l;
	public final int V = 8;
	Stack<Integer> reversePostOrder;
	Vertex[] v;

	public static void main(String[] args) {
		TopologicalSort s = new TopologicalSort();
		s.execute();
	}

	public void execute() {
		// ignored the weight;
		addEdge(0, 1, 1);
		addEdge(0, 3, 1);
		addEdge(1, 4, 1);
		addEdge(2, 3, 1);
		addEdge(2, 5, 1);
		addEdge(3, 4, 1);
		addEdge(4, 7, 1);
		addEdge(5, 4, 1);
		addEdge(5, 6, 1);
		sort();
		print();
	}

	public TopologicalSort() {
		l = (LinkedList<Pair>[]) new LinkedList[V];

		for (int i = 0; i < l.length; i++) {
			l[i] = new LinkedList<Pair>();
		}
		reversePostOrder = new Stack<Integer>();
		v = new Vertex[V];
		for (int i = 0; i < V; i++) {
			v[i] = new Vertex();
		}

	}

	public void addEdge(int startV, int endV, int weight) {
		l[startV].add(new Pair(endV, weight));
		// l[endV].add(new Pair(startV, weight));
	}

	public void sort() {
		for (int i = 0; i < V; i++) {
			if (!v[i].isVisited) {
				dfs(i);
			}
		}
	}

	public void dfs(int d) {
		v[d].isVisited = true;
		for (int i = 0; i < l[d].size(); i++) {
			if (!v[l[d].get(i).endVertex].isVisited) {
				dfs(l[d].get(i).endVertex);
			}
		}
		reversePostOrder.push(d);
	}

	public void print() {
		while (!reversePostOrder.isEmpty()) {
			System.out.print(reversePostOrder.pop() + " ");
		}
	}
}
