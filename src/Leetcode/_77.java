package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		combineHelper(ll, l, 1, n, k);
		return ll;
	}

	public void combineHelper(List<List<Integer>> ll, List<Integer> l, int s,
			int n, int k) {
		if (k == 0) {
			ll.add(new ArrayList<Integer>(l));
			return;
		}

		for (int i = s; i <= n; i++) {
			// pick
			l.add(i);
			combineHelper(ll, l, i + 1, n, k - 1);
			l.remove(l.size() - 1);
		}
	}
}
