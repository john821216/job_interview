package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _51 {
	public static void main(String[] args) {
		_51 a = new _51();
		a.execute();
	}

	public void execute() {
		solveNQueens(9);
	}

	public List<List<String>> solveNQueens(int n) {
		boolean[][] hasQueens = new boolean[n][n];
		List<List<String>> an = new ArrayList<List<String>>();
		List<Integer> rowan = new ArrayList<Integer>();
		solve(an, rowan, hasQueens, 0, 0, n);
		return an;
	}

	public void solve(List<List<String>> an, List<Integer> rowAn, boolean[][] hasQueens, int row, int pos, int n) {
		if (row == n) {
			addAnswer(an, rowAn, n);
			return;
		} else {
			for (int i = pos; i < n; i++) {
				if (!hasQueens[row][i]) {
					rowAn.add(i);
					// copy hasQueens
					boolean[][] tempFill = new boolean[n][n];
					for (int r = 0; r < n; r++) {
						for (int c = 0; c < n; c++) {
							tempFill[r][c] = hasQueens[r][c];
						}
					}
					fillQueen(hasQueens, row, i);
					solve(an, rowAn, hasQueens, row + 1, 0, n);

					for (int r = 0; r < n; r++) {
						for (int c = 0; c < n; c++) {
							hasQueens[r][c] = tempFill[r][c];
						}
					}
					rowAn.remove(rowAn.size() - 1);
				}
			}
		}
	}

	public void addAnswer(List<List<String>> an, List<Integer> l, int n) {
		List<String> newL = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String temp = "";
			for (int j = 0; j < n; j++) {
				if (l.get(i) == j) {
					temp += "Q";
				} else {
					temp += ".";
				}
			}
			newL.add(temp);
		}
		an.add(newL);
	}

	public void fillQueen(boolean[][] hasQueens, int x, int y) {
		int len = hasQueens.length;
		for (int i = 0; i < len; i++) {
			hasQueens[x][i] = true;
			hasQueens[i][y] = true;
		}

		int tempX = x;
		int tempY = y;
		while (tempX < len && tempY < len) {
			hasQueens[tempX++][tempY++] = true;
		}

		tempX = x;
		tempY = y;
		while (tempX >= 0 && tempY < len) {
			hasQueens[tempX--][tempY++] = true;
		}

		tempX = x;
		tempY = y;
		while (tempX >= 0 && tempY >= 0) {
			hasQueens[tempX--][tempY--] = true;
		}

		tempX = x;
		tempY = y;
		while (tempX < len && tempY >= 0) {
			hasQueens[tempX++][tempY--] = true;
		}
	}
}
