package Leetcode;

public class _573 {
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int closestOne = 0;
		int minDis = Integer.MAX_VALUE;
		int totalDis = 0;
		for (int i = 0; i < nuts.length; i++) {
			int x = Math.abs(squirrel[0] - nuts[i][0]);
			int y = Math.abs(squirrel[1] - nuts[i][1]);
			int dis = x + y;
			if (dis < minDis) {
				minDis = dis;
				closestOne = i;
			}
		}
		totalDis = minDis + Math.abs(tree[0] - nuts[closestOne][0]) + Math.abs(tree[1] - nuts[closestOne][1]);

		for (int i = 0; i < nuts.length; i++) {
			if (i != closestOne) {
				int x = Math.abs(tree[0] - nuts[i][0]);
				int y = Math.abs(tree[1] - nuts[i][1]);
				totalDis += x + y;
			}
		}
		return totalDis;

	}
}
