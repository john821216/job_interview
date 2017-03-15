package Graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Dijkstra_list {
	LinkedList<Pair>[] adjacencyList;
	NavigableSet<Vertex> p;
	Vertex[] v;
	public final int V = 9;

	// constructor
	public Dijkstra_list() {
		adjacencyList = (LinkedList<Pair>[]) new LinkedList[V];

		for (int i = 0; i < V; i++) {
			adjacencyList[i] = new LinkedList<Pair>();
		}
	}

	public void addEdge(int startVertex, int endVertex, int weight) {
		adjacencyList[startVertex].add(new Pair(endVertex, weight));
		adjacencyList[endVertex].add(new Pair(startVertex, weight));
	}

	public LinkedList<Pair> getEdgeFromVertex(int startVertex) {
		return adjacencyList[startVertex];
	}

	public void printAdjList() {
		int i = 0;
		for (LinkedList<Pair> l : adjacencyList) {
			System.out.print("adjacencyList[" + i + "] -> ");

			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j).endVertex + "(" + l.get(j).weight
						+ ")");
			}
			++i;
			System.out.println();
		}
	}

	public void printSol() {
		for (int i = 0; i < V; i++) {
			System.out.println(i + " " + v[i].disTo + " " + v[i].edgeTo);
		}
	}

	public static void main(String[] args) {
		Dijkstra_list d = new Dijkstra_list();
		d.execute();
	}

	public void execute() {
	    addEdge( 0, 1, 4);
	    addEdge( 0, 7, 8);
	    addEdge( 1, 2, 8);
	    addEdge( 1, 7, 11);
	    addEdge( 2, 3, 7);
	    addEdge(2, 8, 2);
	    addEdge( 2, 5, 4);
	    addEdge( 3, 4, 9);
	    addEdge( 3, 5, 14);
	    addEdge( 4, 5, 10);
	    addEdge( 5, 6, 2);
	    addEdge( 6, 7, 1);
	    addEdge( 6, 8, 6);
	    addEdge(7, 8, 7);
		di();
		printAdjList();
		printSol();
	}

	public void di() {
		v = new Vertex[V];
		p = new TreeSet<>(new VertexComparator());
		for (int i = 0; i < v.length; i++) {
			v[i] = new Vertex();
			v[i].index = i;
			v[i].disTo = Integer.MAX_VALUE;
			p.add(v[i]);
		}

		v[0].disTo = 0;

		while (!p.isEmpty()) {
			Vertex poll = p.pollFirst();
			poll.isVisited = true;
			if(poll.disTo == Integer.MAX_VALUE) break;
			LinkedList<Pair> neighbor = adjacencyList[poll.index];
			for (int i = 0; i < neighbor.size(); i++) {
				Pair n = neighbor.get(i);
				if (!v[n.endVertex].isVisited && v[poll.index].disTo + n.weight < v[n.endVertex].disTo) {
					p.remove(v[n.endVertex]);
					v[n.endVertex].disTo = v[poll.index].disTo + n.weight;
					v[n.endVertex].edgeTo = poll.index;
					p.add(v[n.endVertex]);
				}
			}
		}

	}

}

class VertexComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex o1, Vertex o2) {
		if (o1.disTo == o2.disTo) {
			return o1.index - o2.index;
		} else {
			return o1.disTo - o2.disTo;
		}
	}

}

class Vertex {
	int index;
	int disTo;
	int edgeTo;
	boolean isVisited;
}

class Pair {
	int endVertex;
	int weight;

	public Pair(int endVertex, int weight) {
		this.endVertex = endVertex;
		this.weight = weight;
	}

}
