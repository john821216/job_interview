package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _491 {
	public static void main(String[] args) {
		_491 a = new _491();
		a.execute();
		System.out.println((double)(2)/((double)1/(double)3));
	}

	public void execute() {
		int[] arr = { 4, 3, 2, 1 };
		findSubsequences(arr);
	}

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		findSubsequencesHelper(ll, l, nums, 0);
		return ll;
	}

	public void findSubsequencesHelper(List<List<Integer>> ll, List<Integer> l,
			int[] nums, int idx) {
		if (l.size() >= 2) {
			ll.add(new ArrayList<Integer>(l));
			System.out.println(l);
		}
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i = idx; i < nums.length; i++) {
			if (h.contains(nums[i])){
				continue;
			}
			h.add(nums[i]);
			if (l.isEmpty() || nums[i] >= l.get(l.size() - 1)) {
				l.add(nums[i]);
				findSubsequencesHelper(ll, l, nums, i + 1);
				l.remove(l.size() - 1);
			}
		}
	}
}
