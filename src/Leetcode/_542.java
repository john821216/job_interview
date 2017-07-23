package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _542 {
	public static void main(String[] args) {
		_542 a = new _542();
		a.execute();
	}

	public void execute() {
		int[][] arr = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] an = updateMatrix(arr);

		for (int i = 0; i < an.length; i++) {
			for (int j = 0; j < an[0].length; j++) {
				System.out.print(an[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] updateMatrix(int[][] matrix) {
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					q.add(new int[] { i, j });
				} else {

					// either Integer.MaxValue or -1 is ok
					matrix[i][j] = -1;
				}
			}
		}

		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!q.isEmpty()) {
			int[] pop = q.poll();
			int nextX;
			int nextY;
			for (int i = 0; i < dir.length; i++){
				nextX = pop[0] + dir[i][0];
				nextY = pop[1] + dir[i][1];

				if (nextX < 0 || nextY < 0 || nextX >= matrix.length
						|| nextY >= matrix[0].length) {
					continue;
				}

				if (matrix[nextX][nextY] == -1) {
					matrix[nextX][nextY] = matrix[pop[0]][pop[1]] + 1;
					q.add(new int[] { nextX, nextY });
				} else {
					if (matrix[pop[0]][pop[1]] + 1 < matrix[nextX][nextY]) {
						matrix[nextX][nextY] = matrix[pop[0]][pop[1]] + 1;
						q.add(new int[] { nextX, nextY });
					}
				}

				//
				for (int k = 0; k < matrix.length; k++) {
					for (int z = 0; z < matrix[0].length; z++) {
						System.out.print(matrix[k][z] + " ");
					}
					System.out.println();
				}
				System.out.println();

				// /
			}

		}
		return matrix;
	}
}
