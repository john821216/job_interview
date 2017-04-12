package Graph;

import java.util.LinkedList;
import java.util.Stack;

public class DAGSPT {
	LinkedList<Pair>[] l;
	public final int V = 6;
	Stack<Integer> reversePostOrder;
	Vertex[] v;

	public static void main(String[] args) {
		DAGSPT s = new DAGSPT();
		s.execute();
	}

	public void execute() {
		// ignored the weight;
		addEdge(0, 1, 2);
		addEdge(0, 3, 2);
		addEdge(1, 2, 6);
		addEdge(2, 4, 1);
		addEdge(2, 5, 2);
		addEdge(3, 1, 4);
		addEdge(3, 4, 3);
		addEdge(4, 5, 1);
		sort();
		spt();
//		print();
	}

	public DAGSPT() {
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

	public void spt() {
		for (int i = 0; i < V; i++) {
			v[i].disTo = Integer.MAX_VALUE;
			v[i].edgeTo = -1;
		}
		v[0].disTo = 0;
		while (!reversePostOrder.isEmpty()) {
			int curIndex = reversePostOrder.pop();
			for (int i = 0; i < l[curIndex].size(); i++) {
				Pair curDes = l[curIndex].get(i);
				if (v[curIndex].disTo + curDes.weight < v[curDes.endVertex].disTo) {
					v[curDes.endVertex].disTo = v[curIndex].disTo + curDes.weight;
					v[curDes.endVertex].edgeTo = curIndex;
				}
			}
		}
		
		for(int i = 1 ; i < V ; i++){
			System.out.println(v[i].edgeTo +" " +i);
		}
	}

	public void print() {
		// while (!reversePostOrder.isEmpty()) {
		// System.out.print(reversePostOrder.pop() + " ");
		// }
	}
}
