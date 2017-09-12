package Leetcode;

import java.util.HashSet;

public class _490 {

	public static void main(String[] args) {

		_490 a = new _490();
		a.execute();
	}

	public void execute() {
		int[][] m = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(hasPath(m, new int[] { 0, 4 }, new int[] { 3, 2 }));
	}

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(start[0] * maze.length + start[1]);

		return visit(visited, maze, dir, start, destination);
	}

	public boolean visit(HashSet<Integer> visited, int[][] maze, int[][] dir, int[] start, int[] des) {
		if (start[0] == des[0] && start[1] == des[1]) {
			return true;
		}
		int tempX = start[0];
		int tempY = start[1];
		for (int[] d : dir) {
			while (true) {
				int nextX = start[0] + d[0];
				int nextY = start[1] + d[1];
				if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length
						&& maze[nextX][nextY] == 0) {
					start[0] = nextX;
					start[1] = nextY;
				} else {
					break;
				}
			}
			if (visited.contains(start[0] * maze[0].length + start[1])) {
				start[0] = tempX;
				start[1] = tempY;
				continue;
			}
			visited.add(start[0] * maze[0].length + start[1]);
			if (visit(visited, maze, dir, start, des) == true) {
				return true;
			}
			start[0] = tempX;
			start[1] = tempY;
		}
		return false;
	}
}
