package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _417 {
	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> an = new ArrayList<int[]>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return an;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visitedPacific = new boolean[m][n];
		boolean[][] visitedAtlantic = new boolean[m][n];
		Queue<int[]> pacificQ = new LinkedList<int[]>();
		Queue<int[]> atlanticQ = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			visitedPacific[0][i] = true;
			visitedAtlantic[m - 1][i] = true;
			pacificQ.add(new int[] { 0, i });
			atlanticQ.add(new int[] { m - 1, i });
		}

		for (int i = 0; i < m; i++) {
			visitedPacific[i][0] = true;
			visitedAtlantic[i][n - 1] = true;
			pacificQ.add(new int[] { i, 0 });
			atlanticQ.add(new int[] { i, n - 1 });
		}

		bfs(m, n, matrix, visitedPacific, pacificQ);
		bfs(m, n, matrix, visitedAtlantic, atlanticQ);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(visitedPacific[i][j] && visitedAtlantic[i][j]) {
					an.add(new int[] {i,j});
				}
			}
		}
		return an;
	}

	public void bfs(int m, int n, int[][] matrix, boolean[][] visited, Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] pop = q.poll();
			int curX = pop[0];
			int curY = pop[1];
			visited[curX][curY] = true;
			for (int[] d : dir) {
				int nextX = curX + d[0];
				int nextY = curY + d[1];
				if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || visited[nextX][nextY]
						|| matrix[nextX][nextY] < matrix[curX][curY]) {
					continue;
				}
				q.add(new int[] { curX + d[0], curY + d[1] });
			}

		}
	}
}
