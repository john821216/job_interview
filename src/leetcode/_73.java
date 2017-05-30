package Leetcode;

public class _73 {
	public static void main(String[] args) {
		_73 a = new _73();
		a.execute();
	}

	public void execute() {
		// int[][] arr = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
		// { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		int[][] arr = { { 0 }, { 1 } };
		// ////////
		// 1 2 0 //
		// 3 0 5 //
		// 8 9 11//
		// 10 1 2 //
		// ////////

		System.out.println("original");
		// print(arr);
		setZeroes2(arr);
		System.out.println("After");
		// print(arr);
	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[] isZero = new boolean[m + n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					isZero[i] = true;
					isZero[m + j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (isZero[i] == true) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (isZero[m + i] == true) {
				for (int j = 0; j < m; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}

	public void print(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void setZeroes2(int[][] matrix) {
		boolean col0 = false;
		boolean row0 = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						row0 = true;
					}
					if (j == 0) {
						col0 = true;
					}
					if (i > 0 && j > 0) {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (row0) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		if (col0) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
