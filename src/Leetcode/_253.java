package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _253 {

	public static void main(String[] args) {
		_253 a = new _253();
		a.execute();
	}

	public void execute() {
		Interval[] i = new Interval[3];
		i[0] = new Interval(0, 30);
		i[1] = new Interval(5, 10);
		i[2] = new Interval(15, 20);
		System.out.println(minMeetingRooms(i));
	}

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new IntervalsComparator());
		int count = 1;
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		p.add(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			int startTime = intervals[i].start;
			int minEndTime = p.peek();
			if (startTime < minEndTime) {
				count++;
			} else {
				p.poll();
			}
			p.add(intervals[i].end);
		}
		return count;
	}

	private class IntervalsComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}

	}
}
