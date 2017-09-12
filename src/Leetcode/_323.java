package Leetcode;

public class _323 {
	public static void main(String[] args) {
		_323 a = new _323();
		a.execute();
	}

	public void execute() {
		countComponents(10, new int[][] { { 5, 6 }, { 0, 2 }, { 1, 7 }, { 5, 9 }, { 1, 8 }, { 3, 4 }, { 0, 6 },
				{ 0, 7 }, { 0, 3 }, { 8, 9 } });
	}

	public int countComponents(int n, int[][] edges) {
		int count = n;
		int[] parent = new int[n];
		int[] size = new int[n];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		for (int i = 0; i < edges.length; i++) {
			int pA = find(parent,edges[i][0]);
			int pB = find(parent,edges[i][1]);
			if ((pA != pB)) {
				connect(parent, size, edges[i][0], edges[i][1]);
				count--;
			}
		}
		return count;
	}

	public void connect(int[] parent, int[] size, int p, int q) {
		int parentP = find(parent, p);
		int parentQ = find(parent, q);
		if (parentP == parentQ) {
			return;
		}

		if (size[parentP] < size[parentQ]) {
			parent[parentP] = parentQ;
			size[parentQ] += size[parentP];
		} else {
			parent[parentQ] = parentP;
			size[parentP] += size[parentQ];
		}
	}

	public int find(int[] parent, int p) {
		if (p == parent[p]) {
			return p;
		} else {
			parent[p] = find(parent, parent[p]);
			return parent[p];
		}
	}
}
