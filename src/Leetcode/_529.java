package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _529 {
	public char[][] updateBoard(char[][] board, int[] click) {
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		q.add(click);
		isVisited[click[0]][click[1]] = true;

		while (!q.isEmpty()) {
			int[] xDir = { -1, 0, 1 };
			int[] yDir = { -1, 0, 1 };
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			int mineCount = 0;
			Queue<int[]> temp = new LinkedList<int[]>();
			for (int dirX : xDir) {
				for (int dirY : yDir) {
					if (x + dirX < 0 || x + dirX >= board.length
							|| y + dirY < 0 || y + dirY >= board[0].length) {
						continue;
					}

					if (board[x + dirX][y + dirY] == 'M') {
						mineCount++;
					}
					if (!isVisited[x + dirX][y + dirY]) {
						temp.add(new int[] { x + dirX, y + dirY });
					}
				}
			}

			if (mineCount == 0) {
				while (!temp.isEmpty()) {
					int[] add = temp.poll();
					q.add(add);
					isVisited[add[0]][add[1]] = true;
				}
				board[x][y] = 'B';
			} else {
				board[x][y] = (char) (mineCount + '0');
			}
		}
		return board;

	}
}
