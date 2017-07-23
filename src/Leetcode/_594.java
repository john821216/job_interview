package Leetcode;

import java.util.HashMap;

public class _594 {
	public static void main(String[] args) {
		_594 a = new _594();
		a.execute();
	}

	public void execute() {
		int[] n = { 1, 3, 2, 2, 5, 2, 3, 7 };
		findLHS(n);
	}

	public int findLHS(int[] nums) {
		HashMap<Long, Integer> h = new HashMap<Long, Integer>();
		for (int i : nums) {
			h.put((long) i, h.getOrDefault((long) i, 0) + 1);
		}

		int max = 0;
		for (long key : h.keySet()) {
			System.out.println(key + " " + h.get(key));
			if (h.containsKey(key + 1)) {
				max = Math.max(h.get(key) + h.get(key + 1), max);
			}
		}
		return max;
	}
}
