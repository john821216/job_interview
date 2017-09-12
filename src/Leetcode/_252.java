package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _252 {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals.length == 0) {
			return true;
		}
		Arrays.sort(intervals, new IntervalsComparator());
		int endTime = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			int startTime = intervals[i].start;
			if (endTime > startTime) {
				return false;
			}
			endTime = intervals[i].end;
		}
		return true;
	}

	private class IntervalsComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}

	}
}
