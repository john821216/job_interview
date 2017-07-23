package Leetcode;

public class _59 {
	public int[][] generateMatrix(int n) {
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[][] arr = new int[n][n];
		if (n == 0) {
			return new int[0][0];
		}
		arr[0][0] = 1;
		int curCount = 2;
		int curDir = 0;
		int curX = 0;
		int curY = 0;
		for (int i = curCount; i <= n * n; i++) {
			int nextX = curX + dir[curDir][0];
			int nextY = curY + dir[curDir][1];
			if (nextX == n || nextX == -1 || nextY == n || nextY == -1
					|| arr[nextX][nextY] != 0) {
				curDir = (curDir + 1) % 4;
				nextX = curX + dir[curDir][0];
				nextY = curY + dir[curDir][1];
			}
			arr[nextX][nextY] = curCount++;
			curX = nextX;
			curY = nextY;
		}
		return arr;
	}
}
