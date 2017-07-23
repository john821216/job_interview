package Leetcode;

import java.util.HashSet;

public class _128 {
	public int longestConsecutive(int[] nums) {
		int max = 0;
		if (nums == null || nums.length == 0) {
			return 0;
		}

		HashSet<Integer> h = new HashSet<Integer>();
		for (int n : nums) {
			h.add(n);
		}

		for (int n : nums) {
			if (h.contains(n)) {
				h.remove(n);
				int cur = n;
				int sum = 1;
				while (h.contains(cur + 1)) {
					sum++;
					h.remove(cur + 1);
					cur++;
				}

				cur = n;
				while (h.contains(cur - 1)) {
					sum++;
					h.remove(cur - 1);
					cur--;
				}
				max = Math.max(max, sum);
			}
		}
		return max;
	}
}
