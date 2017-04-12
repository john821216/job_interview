package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _54 {
	public static void main(String[] args) {
		_54 a = new _54();
		a.execute();

	}

	public void execute() {
		int[][] arr = { { 3 }, { 2 } };
		spiralOrder(arr);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new ArrayList<Integer>();
		}
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int curDir = 0;
		int curX = 0;
		int curY = 0;
		int minX = 0;
		int maxX = matrix.length - 1;
		int minY = 0;
		int maxY = matrix[0].length - 1;
		List<Integer> l = new ArrayList<Integer>();
		l.add(matrix[0][0]);
		while (minY <= maxY && minX <= maxX) {
			// next step
			int nextX = curX + dir[curDir][0];
			int nextY = curY + dir[curDir][1];
			if (nextY >= minY && nextY <= maxY && nextX >= minX
					&& nextX <= maxX) {
				System.out.println(matrix[nextX][nextY]);
				l.add(matrix[nextX][nextY]);
				curX = nextX;
				curY = nextY;
			} else {
				if (curDir == 0) {
					minX++;
					System.out.println(minX);
				} else if (curDir == 1) {
					maxY--;
				} else if (curDir == 2) {
					maxX--;
				} else {
					minY++;
				}
				curDir = (curDir + 1) % 4;
			}
		}
		return l;
	}
}
