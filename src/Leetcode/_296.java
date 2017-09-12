package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _296 {

	public static void main(String[] args) {
		_296 a = new _296();
		a.execute();
	}

	public void execute() {
		int[][] grid = { { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
		System.out.println(minTotalDistance(grid));
	}

	public int minTotalDistance(int[][] grid) {
		if (grid.length == 0 || grid == null) {
			return 0;
		}
		int XDistance = Integer.MAX_VALUE;
		int YDistance = Integer.MAX_VALUE;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			int dis = 0;
			for (int[] g : q) {
				dis += Math.abs(g[0] - i);
			}
			XDistance = Math.min(XDistance, dis);
		}

		for (int i = 0; i < n; i++) {
			int dis = 0;
			for (int[] g : q) {
				dis += Math.abs(g[1] - i);
			}
			YDistance = Math.min(YDistance, dis);
		}
		return XDistance + YDistance;
	}

	public int minTotalDistance2(int[][] grid) {

		if (grid.length == 0 || grid == null) {
			return 0;
		}

		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					x.add(i);
					y.add(j);
				}
			}
		}
		Collections.sort(x);
		Collections.sort(y);
		int mediX = x.get(x.size() / 2);
		int mediY = y.get(y.size() / 2);
		int XDistance = 0;
		int YDistance = 0;
		for(int i = 0; i < x.size() ; i++) {
			XDistance += Math.abs(x.get(i)-mediX);
		}
		for(int i = 0; i < y.size() ; i++) {
			YDistance += Math.abs(y.get(i)-mediY);
		}
		return XDistance + YDistance;
	}
}
