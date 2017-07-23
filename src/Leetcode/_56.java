package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _56 {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> l = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			return new ArrayList<Interval>();
		}

		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		int curStart = intervals.get(0).start;
		int curEnd = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			int nextStart = intervals.get(i).start;
			int nextEnd = intervals.get(i).end;
			if (nextStart <= curEnd) {
				curEnd = Math.max(curEnd, nextEnd);
			} else {
				l.add(new Interval(curStart, curEnd));
				curStart = nextStart;
				curEnd = nextEnd;
			}
		}

		l.add(new Interval(curStart, curEnd));
		return l;
	}
}
