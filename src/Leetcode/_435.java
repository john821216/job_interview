package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _435 {
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		int count = 1;
		Arrays.sort(intervals, new intervalsComparator());
		int end = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= end) {
				count++;
				end = intervals[i].end;
			}
		}
		return intervals.length - count;
	}

	class intervalsComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.end - o2.end;
		}
	}

}
