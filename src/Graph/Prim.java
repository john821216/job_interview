package Graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Prim {
	LinkedList<Pair>[] adjacencyList;
	NavigableSet<Vertex> p;
	Vertex[] v;
	public final int V = 5;

	public static void main(String[] args){
		Prim p = new Prim();
		p.execute();
	}
	
	public void execute(){
		 /* Let us create the following graph
	        2    3
	    (0)--(1)--(2)
	     |   / \   |
	    6| 8/   \5 |7
	     | /     \ |
	    (3)-------(4)
	          9          */
		addEdge(0,1,2);
		addEdge(0,3,6);
		addEdge(1,2,3);
		addEdge(1,4,5);
		addEdge(1,3,8);
		addEdge(2,4,7);
		addEdge(3,4,9);
		prim();
		printMST();
	}
	public Prim() {
		adjacencyList = (LinkedList<Pair>[]) new LinkedList[V];

		for (int i = 0; i < V; i++) {
			adjacencyList[i] = new LinkedList<Pair>();
		}
	}

	public void addEdge(int from, int to, int weight) {
		adjacencyList[from].add(new Pair(to, weight));
		adjacencyList[to].add(new Pair(from, weight));
	}
	
	public void prim(){
		v = new Vertex[V];
		p = new TreeSet<Vertex>(new VertexComparatorPrim());
		for(int i = 0 ; i < V ; i++){
			v[i] = new Vertex();
			v[i].index = i;
			v[i].disTo = Integer.MAX_VALUE;
			p.add(v[i]);
		}
		v[0].disTo = 0;
		
		while(!p.isEmpty()){
			Vertex curV = p.pollFirst();
			curV.isVisited = true;
			LinkedList<Pair> neighbor = adjacencyList[curV.index];
			for(int i = 0 ; i < neighbor.size() ; i++){
				Pair curP = neighbor.get(i);
				if(v[curP.endVertex].isVisited == false && curP.weight < v[curP.endVertex].disTo){
					p.remove(v[curP.endVertex]);
					v[curP.endVertex].disTo = curP.weight;
					v[curP.endVertex].edgeTo = curV.index;
					p.add(v[curP.endVertex]);
				}
			}
 		}
	}
	
	public void printMST(){
		for(int i = 1 ; i < V ; i++){
			System.out.println(v[i].edgeTo +" "+ i +" " +v[i].disTo);
		}
	}
}

class VertexComparatorPrim implements Comparator<Vertex>{

	@Override
	public int compare(Vertex o1, Vertex o2) {
		if(o1.disTo == o2.disTo){
			return o1.index - o2.index;
		} else{
			return o1.disTo - o2.disTo;
		}
	}
	
}
