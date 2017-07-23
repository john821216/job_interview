package Leetcode;

public class _498 {

	public static void main(String[] args) {
		_498 a = new _498();
		a.execute();
	}

	public void execute() {
		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 } };
		findDiagonalOrder(m);
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0){
			return new int[0];
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] an = new int[m * n];
		an[0] = matrix[0][0];
		int idx = 1;
		int sum = 1;
		boolean yIsBig = true;
		while (idx < an.length) {
			// find first suitable element;
			int x;
			int y;
			if (yIsBig) {
				x = 0;
				y = sum;
				while (!(x >= 0 && y >= 0 && x < m && y < n)) {
					x++;
					y--;
				}
				while (x >= 0 && y >= 0 && x < m && y < n) {
					an[idx++] = matrix[x++][y--];
				}
			} else {
				x = sum;
				y = 0;
				while (!(x >= 0 && y >= 0 && x < m && y < n)) {
					x--;
					y++;
				}
				while (x >= 0 && y >= 0 && x < m && y < n) {
					an[idx++] = matrix[x--][y++];
				}
			}
			sum++;
			yIsBig = !yIsBig;
		}
		for (int i : an) {
			System.out.print(i + " ");
		}
		return an;
	}
}
