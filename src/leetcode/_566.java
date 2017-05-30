package Leetcode;

public class _566 {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums.length * nums[0].length != r * c) {
			return nums;
		}

		int[][] newNums = new int[r][c];
		int curX = 0;
		int curY = 0;
		curY++;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				newNums[curX][curY] = nums[i][j];
				if (curY / c == 1) {
					curY = 0;
					curX += 1;
				} else {
					curY++;
				}
			}
		}
		return newNums;
	}
}
