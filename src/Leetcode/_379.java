package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _379 {
	int maxN;
	LinkedList<Integer> q;
	HashSet<Integer> h;

	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *            - The maximum numbers that can be stored in the phone directory.
	 */
	public _379(int maxNumbers) {
		maxN = maxNumbers;
		q = new LinkedList<Integer>();
		h = new HashSet<Integer>();
		for (int i = 0; i < maxNumbers; i++) {
			q.add(i);
			h.add(i);
		}
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		int g = q.getFirst();
		q.removeFirst();
		h.remove(g);
		return g;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return h.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (!h.contains(number)) {
			q.add(number);
			h.add(number);
		}
	}
}
