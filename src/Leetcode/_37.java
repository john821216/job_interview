package Leetcode;

public class _37 {

	public static void main(String[] args) {
		_37 a = new _37();
		a.execute();
	}

	public void execute() {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'},
		};
		solveSudoku(board);
		
		for(int i = 0 ; i < 9 ; i++) {
			for(int j= 0 ; j < 9 ; j++) {
				System.out.print(board[i][j] +" ");
			}
			System.out.println("");
		}
	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		solve(board);
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							if (!solve(board)) {
								board[i][j] = '.';
							}
						}
					}
					if (board[i][j] == '.') {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int i, int j, char c) {
		for (int k = 0; k < 9; k++) {
			if (board[i][k] == c) {
				return false;
			}
			if (board[k][j] == c) {
				return false;
			}
			int row = i / 3;
			int column = j / 3;
			row *= 3;
			column *= 3;
			if (board[row + k / 3][column + k % 3] == c) {
				return false;
			}
		}
		return true;
	}
}
