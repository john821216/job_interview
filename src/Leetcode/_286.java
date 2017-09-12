package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _286 {
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0) {
			return;
		}
		Queue<int[]> q = new LinkedList<int[]>();
		int m = rooms.length;
		int n = rooms[0].length;
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					q.add(new int[] { i, j });
				}
			}
		}
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int step = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] XandY = q.poll();
				int x = XandY[0];
				int y = XandY[1];
				for (int[] d : dir) {
					if (x + d[0] >= 0 && x + d[0] < m && y + d[1] >= 0 && y + d[1] < n) {
						if (rooms[x + d[0]][y + d[1]] == Integer.MAX_VALUE) {
							rooms[x + d[0]][y + d[1]] = step;
							q.add(new int[] { x + d[0], y + d[1] });
						}
					}
				}
			}
			step++;
		}
	}
}
