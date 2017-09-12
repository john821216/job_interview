package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _317 {

	public static void main(String[] args) {
		_317 a = new _317();
		a.execute();
	}

	public void execute() {
		System.out.println(shortestDistance(new int[][] { { 0, 2, 1 }, 
									   { 1, 0, 2 }
								     , { 0, 1, 0 } }));
	}

	public int shortestDistance(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dis = new int[m][n];
		int[][] time = new int[m][n];
		int count = 0;
		List<int[]> l = new ArrayList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					l.add(new int[] { i, j });
					count++;
					dis[i][j] = -1;
				} else if (grid[i][j] == 2) {
					dis[i][j] = -1;
				}
			}
		}

		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		for (int i = 0; i < l.size(); i++) {
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] visited = new boolean[m][n];
			q.add(l.get(i));
			visited[l.get(i)[0]][l.get(i)[1]] = true;
			for(int k = 0 ; k < m ; k++) {
				for(int j = 0 ; j < n ; j++) {
					System.out.print(dis[k][j] +" ");
				}
				System.out.println("-------");
			}
			int curDis = 1;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
					int[] XandY = q.poll();
					int x = XandY[0];
					int y = XandY[1];
					for (int[] d : dir) {
						int nextX = x + d[0];
						int nextY = y + d[1];
						if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] != 1
								&& grid[nextX][nextY] != 2 && !visited[nextX][nextY]) {
							visited[nextX][nextY] = true;
							dis[nextX][nextY] += curDis;
							time[nextX][nextY] += 1;
							q.add(new int[] { nextX, nextY });
						}
					}
				}
				curDis++;
			}

		}
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(dis[i][j] +" ");
			}
			System.out.println();
		}
		int minDis = Integer.MAX_VALUE;
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis[0].length; j++) {
				if (dis[i][j] != -1 && time[i][j] == count) {
					minDis = Math.min(minDis, dis[i][j]);
				}
			}
		}
		if (minDis == Integer.MAX_VALUE) {
			return -1;
		}
		
		return minDis;
	}
}
