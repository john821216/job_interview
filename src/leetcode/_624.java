package Leetcode;

import java.util.List;

public class _624 {
	public int maxDistance(List<List<Integer>> arrays) {
		int l1 = Integer.MIN_VALUE;
		int l2 = Integer.MIN_VALUE;
		int l1Idx = 0;
		int s1 = Integer.MAX_VALUE;
		int s1Idx = 0;
		int s2 = Integer.MAX_VALUE;

		for (int i = 0; i < arrays.size(); i++) {
			List<Integer> l = arrays.get(i);
			if (l.get(0) < s1) {
				int temp = s1;
				s1 = l.get(0);
				s2 = temp;
				l1Idx = i;
			}

			if (l.get(l.size() - 1) > l1) {
				int temp = l1;
				l1 = l.get(l.size() - 1);
				l2 = temp;
				s1Idx = i;
			}
		}

		if (l1Idx == s1Idx) {
			return Math.max(l1 - s2, l2 - s1);
		}
		return l1 - s1;

	}

	public int maxDistance2(List<List<Integer>> arrays) {
		int result = Integer.MIN_VALUE;
		int max = arrays.get(0).get(arrays.get(0).size() - 1);
		int min = arrays.get(0).get(0);

		for (int i = 1; i < arrays.size(); i++) {
			result = Math.max(result, max - arrays.get(i).get(0));
			result = Math.max(result,
					arrays.get(i).get(arrays.get(i).size() - 1) - min);

			max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
			min = Math.min(min, arrays.get(i).get(0));
		}
		return result;
	}
}
