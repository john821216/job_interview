package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _447 {

	public int numberOfBoomerangs(int[][] points) {
      	HashMap<Double, Integer> h;
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			int curX = points[i][0];
			int curY = points[i][1];
		    h = new HashMap<Double, Integer>();
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					int aX = points[j][0];
					int aY = points[j][1];
					double distance = Math.sqrt((aX - curX) * (aX - curX)
							+ (aY - curY) * (aY - curY));
					if (h.get(distance) == null) {
						h.put(distance, 1);
					} else {
					    int newD = h.get(distance)+1;
						h.put(distance, newD);
						count = count - (newD-1) * (newD-2) + newD*(newD-1);
					}
				}
			}
		}
		return count;
	}
}
