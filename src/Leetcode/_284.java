package Leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class _284 implements Iterator<Integer> {
	private Integer next;
	private Iterator<Integer> iter;
	boolean done = false;

	public _284(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		if (iter.hasNext()) {
			next = iter.next();
		} else {
			done = true;
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer result = next;
		if (iter.hasNext()) {
			next = iter.next();
		} else {
			done = true;
		}
		return result;

	}

	@Override
	public boolean hasNext() {
		return !done;
	}
}
