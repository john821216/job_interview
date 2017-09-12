package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _277 {
	public int findCelebrity(int n) {
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && knows(i, j)) {
					if (count[j] != -1) {
						count[j]++;
					}
					count[i] = -1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (count[i] == n - 1) {
				return i;
			}
		}
		return -1;
	}

	public int findCelebrity2(int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
				return -1;
			}
		}
		return candidate;
	}

	boolean knows(int a, int b) {
		return false;
	}
}
