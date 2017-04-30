package Leetcode;

import java.util.HashSet;

public class _36 {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<Character>();
			HashSet<Character> col = new HashSet<Character>();
			HashSet<Character> grid = new HashSet<Character>();

			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !col.add(board[j][i]))
					return false;
				int rowIndex = 3 * (i / 3) + j / 3;
				int colIndex = 3 * (i % 3) + j % 3;
				if (board[rowIndex][colIndex] != '.'
						&& !grid.add(board[rowIndex][colIndex]))
					return false;
			}
		}
		return true;
	}
}
