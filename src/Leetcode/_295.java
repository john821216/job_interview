package Leetcode;

import java.util.PriorityQueue;

public class _295 {
	/** initialize your data structure here. */
	PriorityQueue<Long> large;
	PriorityQueue<Long> small;

	public _295() {
		large = new PriorityQueue<Long>();
		small = new PriorityQueue<Long>();
	}

	public void addNum(int num) {
		large.add((long) num);
		small.add(large.poll() * -1);
		if(small.size() > large.size()) {
			large.add(small.poll()*-1);
		}
	}

	public double findMedian() {
		if(large.size() > small.size()) {
			return large.peek();
		} else {
			return (large.peek()-small.peek())/2.0;
		}
	}
}
