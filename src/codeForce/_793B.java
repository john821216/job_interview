package CodeForce;

import java.util.Scanner;

public class _793B {
	static String[][] matrix;
	static boolean[][][][] isvisited;
	static int m;
	static int n;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		matrix = new String[m][n];
		isvisited = new boolean[4][3][m][n];
		int startI = 0;
		int startJ = 0;
		for (int i = 0; i < m; i++) {
			String nStr = input.next();
			for (int j = 0; j < nStr.length(); j++) {
				matrix[i][j] = nStr.charAt(j) + "";
				if (matrix[i][j].equals("S")) {
					startI = i;
					startJ = j;
				}
			}

		}

		// dfs
		boolean result = dfs(startI, startJ, 2, 0)
				|| dfs(startI, startJ, 2, 1);
		if (result == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static boolean dfs(int x, int y, int turn, int dirI) {
		if (x >= m || y >= n || x < 0 || y < 0 || turn < 0
				|| matrix[x][y].equals("*")
				|| isvisited[dirI][turn][x][y] == true) {
			return false;
		}
		if (matrix[x][y].equals("T")) {
			return true;
		}

		isvisited[dirI][turn][x][y] = true;

		boolean ok = false;
		for (int i = 0; i < 4; i++) {
			if ((i / 2) != dirI) {
				ok |= dfs(x + dir[i][0], y + dir[i][1], turn - 1, i);

			} else {
				ok |= dfs(x + dir[i][0], y + dir[i][1], turn, i);
			}
		}
		return ok;
	}
}
