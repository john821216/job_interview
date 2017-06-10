package Leetcode;

public class _419 {
	public int countBattleships(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		int count = 0;
		boolean[][] isVisited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X' && !isVisited[i][j]) {
					count++;
					isVisited[i][j] = true;
					int tempI = i + 1;
					int tempJ = j + 1;
					while (tempI < m) {
						if (board[tempI][j] == 'X') {
							isVisited[tempI][j] = true;
							tempI++;
						} else {
							break;
						}
					}

					while (tempJ < n) {
						if (board[i][tempJ] == 'X') {
							isVisited[i][tempJ] = true;
							tempJ++;
						} else {
							break;
						}
					}

				}
			}
		}
		return count;
	}
	
	public int countBattleships2(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == '.') continue;
				if(i>0 && board[i-1][j] == 'X') continue;
				if(j>0 && board[i][j-1] == 'X') continue;
				count++;
			}
		}
		return count;
	}
}
