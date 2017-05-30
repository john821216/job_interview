package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashMap<Integer, UndirectedGraphNode> h = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		q.add(node);
		h.put(cloneNode.label, cloneNode);

		while (!q.isEmpty()) {
			UndirectedGraphNode poll = q.poll();
			for (int i = 0; i < poll.neighbors.size(); i++) {
				UndirectedGraphNode neighbor = poll.neighbors.get(i);
				if (!h.containsKey(neighbor.label)) {
					h.put(neighbor.label, new UndirectedGraphNode(
							neighbor.label));
					q.add(neighbor);
				}
				h.get(poll.label).neighbors.add(h.get(neighbor.label));
			}

		}
		return cloneNode;
    }

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}
