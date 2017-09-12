package Leetcode;

public class _351 {
	public static void main(String[] args) {
		_351 a = new _351();
		a.execute();
	}

	public void execute() {
		System.out.println(numberOfPatterns(1, 3));
	}

	int count = 0;

	public int numberOfPatterns(int m, int n) {
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 }, { 2, 1 },
				{ 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };
		boolean[][] used;
		for (int i = 0; i < 9; i++) {
			used = new boolean[3][3];
			used[i / 3][i % 3] = true;
			dfs(dir, used, i / 3, i % 3, m, n, 1);
		}
		return count;
	}

	public void dfs(int[][] dir, boolean[][] used, int startX, int startY, int m, int n, int len) {
		if (len > n) {
			return;
		} else {
			if (m <= len && len <= n) {
				count++;
			}
		}
		for (int[] d : dir) {
			int nextX = startX + d[0];
			int nextY = startY + d[1];
			if (-1 <= d[0] && d[0] <= 1 && -1 <= d[1] && d[1] <= 1) {
				if (nextX >= 0 && nextX < 3 && nextY >= 0 && nextY < 3  && used[nextX][nextY]) {
					if (d[0] != 0) {
						nextX += d[0];
					}

					if (d[1] != 0) {
						nextY += d[1];
					}
				}
			}
			if (nextX >= 0 && nextX < 3 && nextY >= 0 && nextY < 3 && !used[nextX][nextY]) {
				used[nextX][nextY] = true;
				dfs(dir, used, nextX, nextY, m, n, len + 1);
				used[nextX][nextY] = false;
			}
		}
	}
}
