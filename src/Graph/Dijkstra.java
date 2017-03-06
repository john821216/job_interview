package Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
	int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
	int V = 9;
	Vertex[] v;
	PriorityQueue<Vertex> p;

	public static void main(String[] args) {
		Dijkstra d = new Dijkstra();
		d.di();
		d.printSol();
	}

	public void printSol() {
		for (int i = 0; i < V; i++) {
			System.out.println(i + " " + v[i].distTo +" " + v[i].edgeTo);
		}
	}

	public void di() {
		v = new Vertex[V];
		p = new PriorityQueue<Vertex>(new VertexComparator());
		v[0] = new Vertex();
		p.add(v[0]);
		for (int i = 1; i < V; i++) {
			v[i] = new Vertex(); 
			v[i].distTo = Integer.MAX_VALUE;
			v[i].index = i;
		}
		v[0].distTo = 0;

		while (!p.isEmpty()) {
			Vertex poll = p.poll();
			poll.isVisited = true;
			for (int i = 0; i < V; i++) {
				if (!v[i].isVisited && graph[poll.index][i] != 0
						&& poll.distTo + graph[poll.index][i] < v[i].distTo) {

					v[i].distTo = poll.distTo + graph[poll.index][i];
					v[i].edgeTo = poll.index;
					p.add(v[i]);
				}
			}
		}
	}
	class Vertex{
		int index;
		int distTo;
		int edgeTo;
		boolean isVisited;
	}
	
	class VertexComparator implements Comparator<Vertex>{

		@Override
		public int compare(Vertex o1, Vertex o2) {
			if(o1.distTo > o2.distTo){
				return 1;
			} else if(o1.distTo < o2.distTo){
				return -1;
			} else{
				if(o1.index > o2.index){
					return 1;
				} else{
					return -1;
				}
			}
		}
		
	}
}
