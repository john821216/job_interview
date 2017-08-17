package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class _352 {
	TreeMap<Integer, Interval> t;

	/** Initialize your data structure here. */
	public _352() {
		t = new TreeMap<Integer, Interval>();
	}

	public void addNum(int val) {
		if(t.containsKey(val)) {
			return;
		}
		Integer low = t.lowerKey(val);
		Integer high = t.higherKey(val);
		if (low != null && high != null && t.get(low).end + 1 == val && high == val + 1) {
			t.get(low).end = t.get(high).end;
			t.remove(high);
		} else if(low!= null && t.get(low).end+1 >= val) {
			t.get(low).end = Math.max(val, t.get(low).end);
		} else if(high!= null && val+1 == high) {
			t.put(val, new Interval(val,t.get(high).end));
		} else {
			t.put(val, new Interval(val,val));
		}
	}

	public List<Interval> getIntervals() {
		return new ArrayList<Interval>(t.values());
	}

	private class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
