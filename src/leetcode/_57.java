package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _57 {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		List<Interval> an = new ArrayList<Interval>();
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			an.add(intervals.get(i++));
		}

		while (i < intervals.size()
				&& newInterval.start <= intervals.get(i).end
				&& intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval(Math.min(intervals.get(i).start,
					newInterval.start), Math.max(intervals.get(i).end,
					newInterval.end));
			i++;
		}
		an.add(newInterval);

		while (i < intervals.size()) {
			an.add(intervals.get(i++));
		}
		return an;
	}
}
