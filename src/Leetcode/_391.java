package Leetcode;

import java.util.HashSet;

public class _391 {
	public boolean isRectangleCover(int[][] rectangles) {
		int x1 = Integer.MAX_VALUE;
		int y1 = Integer.MAX_VALUE;
		int x2 = Integer.MIN_VALUE;
		int y2 = Integer.MIN_VALUE;
		int area = 0;
		HashSet<String> h = new HashSet<String>();
		for (int[] r : rectangles) {
			x1 = Math.min(r[0], x1);
			y1 = Math.min(r[1], y1);
			x2 = Math.max(r[2], x2);
			y2 = Math.max(r[3], y2);

			area += (r[2] - r[0]) * (r[3] - r[1]);

			String side1 = r[0] + "_" + r[1];
			String side2 = r[0] + "_" + r[3];
			String side3 = r[2] + "_" + r[1];
			String side4 = r[2] + "_" + r[3];

			if (h.contains(side1)) {
				h.remove(side1);
			} else {
				h.add(side1);
			}

			if (h.contains(side2)) {
				h.remove(side2);
			} else {
				h.add(side2);
			}
			if (h.contains(side3)) {
				h.remove(side3);
			} else {
				h.add(side3);
			}
			if (h.contains(side4)) {
				h.remove(side4);
			} else {
				h.add(side4);
			}
		}

		if (h.size() != 4 || !h.contains(x1 + "_" + y1) || !h.contains(x1 + "_" + y2) || !h.contains(x2 + "_" + y1)
				|| !h.contains(x2 + "_" + y2)) {
			return false;
		}
		
		
		//only if the same rectangle appear many times; 
		if(area != (x2-x1)* (y2-y1)) {
			return false;
		} else {
			return true;
		}
	}
}
