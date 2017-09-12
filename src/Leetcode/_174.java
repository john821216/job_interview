package Leetcode;

public class _174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int step;
				if (i == m - 1 && j == n - 1) {
					step = 1 - dungeon[i][j];
				} else if (i == m - 1) {
					step = dungeon[i][j+1] - dungeon[i][j];
				} else if (j == n - 1) {
					step = dungeon[i+1][j] - dungeon[i][j];
				} else {
					step = Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j];
				}
				if (step <= 0) {
					step = 1;
				}
				dungeon[i][j] = step;
			}
		}
		return dungeon[0][0];
	}
}
