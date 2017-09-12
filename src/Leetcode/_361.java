package Leetcode;

public class _361 {
	public int maxKilledEnemies(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[][][] kill = new int[grid.length][grid[0].length][4];
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][grid[0].length - 1] == 'E') {
				kill[i][grid[0].length - 1][0] = 1;
			}
			for (int j = grid[0].length - 2; j >= 0; j--) {
				if (grid[i][j] == 'E') {
					kill[i][j][0] = kill[i][j + 1][0] + 1;
				} else if (grid[i][j] == 'W') {
					kill[i][j][0] = 0;
				} else {
					kill[i][j][0] = kill[i][j + 1][0];
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0] == 'E') {
				kill[i][0][1] = 1;
			}
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[i][j] == 'E') {
					kill[i][j][1] = kill[i][j - 1][1] + 1;
				} else if (grid[i][j] == 'W') {
					kill[i][j][1] = 0;
				} else {
					kill[i][j][1] = kill[i][j - 1][1];
				}
			}
		}

		for (int j = 0; j < grid[0].length; j--) {
			if (grid[0][j] == 'E') {
				kill[0][j][2] = 1;
			}
			for (int i = 1; i < grid.length; i++) {
				if (grid[i][j] == 'E') {
					kill[i][j][2] = kill[i - 1][j][2] + 1;
				} else if (grid[i][j] == 'W') {
					kill[i][j][2] = 0;
				} else {
					kill[i][j][2] = kill[i - 1][j][2];
				}
			}
		}

		for (int j = 0; j < grid[0].length; j--) {
			if (grid[grid.length - 1][j] == 'E') {
				kill[grid.length - 1][j][2] = 1;
			}
			for (int i = grid.length - 2; i >= 0; i--) {
				if (grid[i][j] == 'E') {
					kill[i][j][3] = kill[i + 1][j][3] + 1;
				} else if (grid[i][j] == 'W') {
					kill[i][j][3] = 0;
				} else {
					kill[i][j][3] = kill[i + 1][j][3];
				}
			}
		}
		int maxKill = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 'E' && grid[i][j] != 'W') {
					int k = kill[i][j][0] + kill[i][j][1] + kill[i][j][2] + kill[i][j][3];
					maxKill = Math.max(maxKill, k);
				}
			}
		}
		return maxKill;
	}

}
