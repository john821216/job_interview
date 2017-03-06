package POJ;

import java.util.Scanner;

public class _2386 {
	static int[][] field;
	static int count = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		field = new int[input.nextInt()][input.nextInt()];

		for (int i = 0; i < field.length; i++) {
			String nextStr = input.next();
			for (int j = 0; j < field[i].length; j++) {
				if (nextStr.charAt(j) == 'W') {
					field[i][j] = 0;
				} else {
					field[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 0) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void dfs(int i, int j) {
		field[i][j] = 1;

		for (int dx = -1; dx <= 1; dx++) {
			for (int dj = -1; dj <= 1; dj++) {
				if (i + dx >= 0 && i + dx < field.length && j + dj >= 0
						&& j + dj < field[0].length) {
					if (field[i + dx][j + dj] == 0) {
						dfs(i + dx, j + dj);
					}
				}
			}
		}
	}
}
