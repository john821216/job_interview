package Leetcode;

public class _348 {
	int[] r;
	int[] c;
	int n;
	int d1;// from top left to bottom right
	int d2;// from top right to bottom left

	public _348(int n) {
		this.n = n;
		r = new int[n];
		c = new int[n];
		d1 = 0;
		d2 = 0;
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		int count = 1;
		if (player == 1) {
			count = 1;
		} else {
			count = -1;
		}
		r[row] += count;
		c[col] += count;
		if (row == col) {
			d1 += count;
		}

		if (row + col == n - 1) {
			d2 += count;
		}

		if (r[row] == n || c[col] == n || d1 == n || d2 == n) {
			return 1;
		}

		if (r[row] == -n || c[col] == -n || d1 == -n || d2 == -n) {
			return 2;
		}

		return 0;
	}
}
