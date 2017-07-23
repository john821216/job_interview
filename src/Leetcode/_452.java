package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _452 {
	public int findMinArrowShots(int[][] points) {
	    if(points.length == 0){
	        return 0;
	    }
		Point[] p = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			p[i] = new Point(points[i][0], points[i][1]);
		}
		
		Arrays.sort(p, new pointsComparator());
		int count = 1;
		int end = p[0].end;
		for(int i = 1 ; i < p.length; i++){
			if(p[i].start > end){
				count++;
				end = p[i].end;
			}
		}
		return count;
	}

	class Point {
		int start;
		int end;

		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	private class pointsComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			return o1.end - o2.end;
		}

	}
}
