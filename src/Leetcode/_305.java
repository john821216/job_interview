package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _305 {

	public static void main(String[] args) {
		_305 a = new _305();
		a.execute();
	}

	public void execute() {
		numIslands2(3, 3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 2 }, { 0, 0 }, { 1, 1 } });
	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		int[] parent = new int[m * n];
		int[] size = new int[m * n];
		int[] pos = new int[m * n];
		int count = 0;
		List<Integer> an = new ArrayList<Integer>();
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int i = 0; i < positions.length; i++) {
			int curX = positions[i][0];
			int curY = positions[i][1];
			pos[curX * n + curY] = 1;
			count++;
			// four directions
			for (int[] d : dir) {
				int nextX = positions[i][0] + d[0];
				int nextY = positions[i][1] + d[1];
				if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
					if (pos[nextX * n + nextY] == 1) {
						if (connect(curX * n + curY, nextX * n + nextY, parent, size)) {
							count--;
						}
					}
				}
			}
			an.add(count);
		}
		System.out.println(an);
		return an;
	}

	public boolean connect(int p, int q, int[] parent, int[] size) {
		int pParent = find(p, parent);
		int qParent = find(q, parent);
		if (pParent == qParent) {
			return false;
		}
		if (size[pParent] < size[qParent]) {
			parent[pParent] = qParent;
			size[qParent] += size[pParent];
		} else {
			parent[qParent] = pParent;
			size[pParent] += size[qParent];
		}
		return true;
	}

	public boolean isConnected(int p, int q, int[] parent) {
		return find(p, parent) == find(q, parent);
	}

	public int find(int p, int[] parent) {
		if (p == parent[p]) {
			return p;
		} else {
			parent[p] = find(parent[p], parent);
			return parent[p];
		}
	}

}
