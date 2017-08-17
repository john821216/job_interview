package Leetcode;

import java.util.HashMap;

public class _149 {
	public static void main(String[] args) {
		System.out.println(new _149().gcd(0, 5));
	}

	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		}

		if (points.length <= 2) {
			return points.length;
		}

		HashMap<Integer, HashMap<Integer, Integer>> h = new HashMap<Integer, HashMap<Integer, Integer>>();
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			int overlap = 0;
			int maxVal = 0;
			h.clear();
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}
				int gcd = gcd(x, y);
				x /= gcd;
				y /= gcd;

				if (h.containsKey(x)) {
					if (h.get(x).containsKey(y)) {
						h.get(x).put(y, h.get(x).get(y) + 1);
					} else {
						h.get(x).put(y, 1);
					}
				} else {
					HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
					newMap.put(y, 1);
					h.put(x, newMap);
				}
				maxVal = Math.max(maxVal, h.get(x).get(y));
			}
			result = Math.max(result, maxVal + overlap + 1);
		}
		return result;
	}

	public int gcd(int x, int y) {
		while (y != 0) {
			int temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}

	// Definition for a point.
	private class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

}
