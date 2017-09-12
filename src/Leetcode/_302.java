package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _302 {

	public static void main(String[] args) {
		_302 a = new _302();
		a.execute();
	}

	public void execute() {
		char[][] image = { { '0', '0', '1', '1' }, { '0', '1', '1', '0' }, { '0', '1', '0', '0' } };
		System.out.println(minArea(image, 0, 2));
	}

	public int minArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0) {
			return 0;
		}
		int m = image.length;
		int n = image[0].length;
		int left = binarySearch(image, 0, y, m, n, 1);
		int right = binarySearch(image, y, n, m, n, 2);
		int top = binarySearch(image, 0, x, m, n, 3);
		int bottom = binarySearch(image, x, m, m, n, 4);
		return (right - left ) * (bottom-top);
	}

	public int binarySearch(char[][] image, int from, int to, int m, int n, int dir) {
		while (from < to) {
			int mid = (to - from) / 2 + from;
			if (dir == 1) {
				boolean foundOne = false;
				for (int i = 0; i < m; i++) {
					if (image[i][mid] == '1') {
						foundOne = true;
						break;
					}
				}
				if (foundOne) {
					to = mid;
				} else {
					from = mid + 1;
				}
			} else if (dir == 2) {
				boolean foundZero = true;
				for (int i = 0; i < m; i++) {
					if (image[i][mid] == '1') {
						foundZero = false;
						break;
					}
				}

				if (foundZero) {
					to = mid;
				} else {
					from = mid+1;
				}

			} else if (dir == 3) {
				boolean foundOne = false;
				for (int i = 0; i < n; i++) {
					if (image[mid][i] == '1') {
						foundOne = true;
						break;
					}
				}
				if (foundOne) {
					to = mid;
				} else {
					from = mid + 1;
				}
			} else if (dir == 4) {
				boolean foundZero = true;
				for (int i = 0; i < n; i++) {
					if (image[mid][i] == '1') {
						foundZero = false;
						break;
					}
				}
				if (foundZero) {
					to = mid;
				} else {
					from = mid+1;
				}
			}
		}
		return from;
	}
}
