package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l;
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length; i++) {
			l = new ArrayList<Integer>();
			subsetWithDupHelper(ll, l, nums, i, 0);
		}
		return ll;
	}

	public void subsetWithDupHelper(List<List<Integer>> ll, List<Integer> l,
			int[] nums, int count, int i) {
		if (count == 0) {
			ll.add(new ArrayList<Integer>(l));
		}

		for (int j = i; j < nums.length; j++) {
			if (j == i || nums[j] != nums[j - 1]) {
				l.add(nums[j]);
				subsetWithDupHelper(ll, l, nums, count - 1, j + 1);
				l.remove(l.size() - 1);
			}
		}
	}
}
