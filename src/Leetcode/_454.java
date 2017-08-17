package Leetcode;

import java.util.HashMap;

public class _454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (!h.containsKey(A[i] + B[j])) {
					h.put(A[i] + B[j], 1);
				} else {
					h.put(A[i] + B[j], h.get(A[i] + B[j]) + 1);
				}
			}
		}

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				if (h.containsKey(-1 * (C[i] + D[j]))) {
					count += h.get(-1 * (C[i] + D[j]));
				}
			}
		}
		return count;
	}
}
